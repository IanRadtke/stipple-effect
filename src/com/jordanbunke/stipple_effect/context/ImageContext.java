package com.jordanbunke.stipple_effect.context;

import com.jordanbunke.delta_time.events.*;
import com.jordanbunke.delta_time.image.GameImage;
import com.jordanbunke.delta_time.image.ImageProcessing;
import com.jordanbunke.delta_time.io.InputEventLogger;
import com.jordanbunke.delta_time.utility.Coord2D;
import com.jordanbunke.stipple_effect.StippleEffect;
import com.jordanbunke.stipple_effect.layer.LayerCombiner;
import com.jordanbunke.stipple_effect.layer.SELayer;
import com.jordanbunke.stipple_effect.state.ImageState;
import com.jordanbunke.stipple_effect.state.StateManager;
import com.jordanbunke.stipple_effect.tools.Hand;
import com.jordanbunke.stipple_effect.tools.Tool;
import com.jordanbunke.stipple_effect.tools.Zoom;
import com.jordanbunke.stipple_effect.utility.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ImageContext {
    private static final Coord2D UNTARGETED = new Coord2D(-1, -1);

    private final StateManager<ImageState> states;
    private final RenderInfo renderInfo;

    private Coord2D targetPixel;

    public ImageContext(final GameImage image) {
        this(new ImageState(image), image.getWidth(), image.getHeight());
    }

    public ImageContext(
            final int imageWidth, final int imageHeight
    ) {
        this(new ImageState(imageWidth, imageHeight), imageWidth, imageHeight);
    }

    private ImageContext(
            final ImageState imageState, final int imageWidth, final int imageHeight
    ) {
        this.states = new StateManager<>(imageState);
        this.renderInfo = new RenderInfo(imageWidth, imageHeight);
        this.targetPixel = UNTARGETED;
    }

    public GameImage drawWorkspace() {
        final GameImage workspace = new GameImage(Constants.WORKSPACE_W, Constants.WORKSPACE_H);
        workspace.fillRectangle(Constants.BACKGROUND, 0, 0,
                Constants.WORKSPACE_W, Constants.WORKSPACE_H);

        final int zoomFactor = renderInfo.getZoomFactor();
        final Coord2D render = getImageRenderPositionInWorkspace();
        final GameImage image = ImageProcessing.scale(states.getState().draw(), zoomFactor);
        workspace.draw(generateCheckers(), render.x, render.y);
        workspace.draw(image, render.x, render.y);

        return workspace.submit();
    }

    public void process(final InputEventLogger eventLogger, final Tool tool) {
        setTargetPixel(eventLogger);
        processTools(eventLogger, tool);
        processSingleKeyInputs(eventLogger);
        processCompoundKeyInputs(eventLogger);
        // TODO
    }

    private void processTools(
            final InputEventLogger eventLogger, final Tool tool
    ) {
        for (GameEvent e : eventLogger.getUnprocessedEvents()) {
            if (e instanceof GameMouseEvent me) {
                if (me.matchesAction(GameMouseEvent.Action.DOWN) && isInWorkshopBounds(eventLogger)) {
                    tool.onMouseDown(this, me);
                    me.markAsProcessed();
                } else if (me.matchesAction(GameMouseEvent.Action.UP)) {
                    tool.onMouseUp(this, me);
                    me.markAsProcessed();
                }
            }
        }

        tool.update(this, eventLogger.getAdjustedMousePosition());
    }

    private void processCompoundKeyInputs(final InputEventLogger eventLogger) {
        // CTRL but not SHIFT
        if (eventLogger.isPressed(Key.CTRL) && !eventLogger.isPressed(Key.SHIFT)) {
            eventLogger.checkForMatchingKeyStroke(
                    GameKeyEvent.newKeyStroke(Key.Z, GameKeyEvent.Action.PRESS),
                    states::undo
            );
            eventLogger.checkForMatchingKeyStroke(
                    GameKeyEvent.newKeyStroke(Key.X, GameKeyEvent.Action.PRESS),
                    states::redo
            );
            eventLogger.checkForMatchingKeyStroke(
                    GameKeyEvent.newKeyStroke(Key.S, GameKeyEvent.Action.PRESS),
                    () -> {} // TODO - context needs a field for a save path and a save mode ->
                    // PNG, static vs animated,
                    // animated can be frame by frame alongside, saved as separate files, or as GIF
            );
            eventLogger.checkForMatchingKeyStroke(
                    GameKeyEvent.newKeyStroke(Key.A, GameKeyEvent.Action.PRESS),
                    () -> {} // TODO - select all
            );
            eventLogger.checkForMatchingKeyStroke(
                    GameKeyEvent.newKeyStroke(Key.D, GameKeyEvent.Action.PRESS),
                    () -> {} // TODO - deselect
            );
        }

        // SHIFT but not CTRL
        if (!eventLogger.isPressed(Key.CTRL) && eventLogger.isPressed(Key.SHIFT)) {
            // TODO - populate with SHIFT + ? shortcuts
        }

        // CTRL and SHIFT
        if (eventLogger.isPressed(Key.CTRL) && eventLogger.isPressed(Key.SHIFT)) {
            eventLogger.checkForMatchingKeyStroke(
                    GameKeyEvent.newKeyStroke(Key.S, GameKeyEvent.Action.PRESS),
                    () -> {} // TODO - save as
            );
            eventLogger.checkForMatchingKeyStroke(
                    GameKeyEvent.newKeyStroke(Key.X, GameKeyEvent.Action.PRESS),
                    () -> {} // TODO - crop to selection
            );
        }
    }

    private void processSingleKeyInputs(final InputEventLogger eventLogger) {
        if (!(eventLogger.isPressed(Key.CTRL) || eventLogger.isPressed(Key.SHIFT))) {
            // set tools
            eventLogger.checkForMatchingKeyStroke(
                    GameKeyEvent.newKeyStroke(Key.Z, GameKeyEvent.Action.PRESS),
                    () -> StippleEffect.get().setTool(Zoom.get())
            );
            eventLogger.checkForMatchingKeyStroke(
                    GameKeyEvent.newKeyStroke(Key.H, GameKeyEvent.Action.PRESS),
                    () -> StippleEffect.get().setTool(Hand.get())
            );
            // TODO

        }
    }

    private boolean isInWorkshopBounds(final InputEventLogger eventLogger) {
        final Coord2D m = eventLogger.getAdjustedMousePosition();
        final Coord2D workshopM = new Coord2D(m.x - Constants.TOOLS_W, m.y - Constants.CONTEXTS_H);
        return workshopM.x > 0 && workshopM.x < Constants.WORKSPACE_W &&
                        workshopM.y > 0 && workshopM.y < Constants.WORKSPACE_H;
    }

    private void setTargetPixel(final InputEventLogger eventLogger) {
        final Coord2D m = eventLogger.getAdjustedMousePosition();
        final Coord2D workshopM = new Coord2D(m.x - Constants.TOOLS_W, m.y - Constants.CONTEXTS_H);

        if (isInWorkshopBounds(eventLogger)) {
            final int w = states.getState().getImageWidth(),
                    h = states.getState().getImageHeight(),
                    zoomFactor = renderInfo.getZoomFactor();
            final Coord2D render = getImageRenderPositionInWorkspace(),
                    bottomLeft = new Coord2D(render.x + (zoomFactor * w),
                            render.y + (zoomFactor * h));
            final int targetX = (int)(((workshopM.x - render.x) / (double)(bottomLeft.x - render.x)) * w),
                    targetY = (int)(((workshopM.y - render.y) / (double)(bottomLeft.y - render.y)) * h);

            targetPixel = (targetX >= 0 && targetX < w && targetY >= 0 && targetY < h)
                    ? new Coord2D(targetX, targetY) : UNTARGETED;
        } else
            targetPixel = UNTARGETED;
    }

    private Coord2D getImageRenderPositionInWorkspace() {
        final int zoomFactor = renderInfo.getZoomFactor();
        final Coord2D anchor = renderInfo.getAnchor(),
                middle = new Coord2D(Constants.WORKSPACE_W / 2, Constants.WORKSPACE_H / 2);

        return new Coord2D(middle.x - (zoomFactor * anchor.x),
                middle.y - (zoomFactor * anchor.y));
    }

    private GameImage generateCheckers() {
        final int w = states.getState().getImageWidth(),
                h = states.getState().getImageHeight(),
                zoomFactor = renderInfo.getZoomFactor();

        final GameImage image = new GameImage(w * zoomFactor, h * zoomFactor);

        for (int x = 0; x < image.getWidth(); x += Constants.CHECKER_INCREMENT) {
            for (int y = 0; y < image.getHeight(); y += Constants.CHECKER_INCREMENT) {
                final Color c = ((x / Constants.CHECKER_INCREMENT) +
                        (y / Constants.CHECKER_INCREMENT)) % 2 == 0
                        ? Constants.WHITE : Constants.LIGHT_GREY;

                image.fillRectangle(c, x, y, Constants.CHECKER_INCREMENT,
                        Constants.CHECKER_INCREMENT);
            }
        }

        return image.submit();
    }

    // TODO - process all actions here and feed through state manager

    // TODO - TOOL

    // IMAGE EDITING
    public void editImage(final GameImage edit) {
        // build resultant state
        final int w = states.getState().getImageWidth(),
                h = states.getState().getImageHeight();
        final List<SELayer> layers = new ArrayList<>(states.getState().getLayers());
        final SELayer replacement = states.getState().getEditingLayer().returnEdit(edit);
        final int index = states.getState().getLayerEditIndex();
        layers.remove(index);
        layers.add(index, replacement);

        final ImageState result = new ImageState(w, h, layers, index);
        states.performAction(result);
    }

    // LAYER MANIPULATION
    // add layer
    public void addLayer() {
        // build resultant state
        final int w = states.getState().getImageWidth(),
                h = states.getState().getImageHeight();
        final List<SELayer> layers = new ArrayList<>(states.getState().getLayers());
        final int addIndex = states.getState().getLayerEditIndex() + 1;
        layers.add(addIndex, new SELayer(w, h));

        final ImageState result = new ImageState(w, h, layers, addIndex);
        states.performAction(result);
    }

    // remove layer
    public void removeLayer() {
        // pre-check
        if (states.getState().canRemoveLayer()) {
            // build resultant state
            final int w = states.getState().getImageWidth(),
                    h = states.getState().getImageHeight();
            final List<SELayer> layers = new ArrayList<>(states.getState().getLayers());
            final int index = states.getState().getLayerEditIndex();
            layers.remove(index);

            final ImageState result = new ImageState(w, h, layers, index > 0 ? index - 1 : index);
            states.performAction(result);
        }
    }

    // move layer down
    public void moveLayerDown() {
        // pre-check
        if (states.getState().canMoveLayerDown()) {
            // build resultant state
            final int w = states.getState().getImageWidth(),
                    h = states.getState().getImageHeight();
            final List<SELayer> layers = new ArrayList<>(states.getState().getLayers());
            final int removalIndex = states.getState().getLayerEditIndex(),
                    reinsertionIndex = removalIndex - 1;

            final SELayer toMove = layers.get(removalIndex);
            layers.remove(removalIndex);
            layers.add(reinsertionIndex, toMove);

            final ImageState result = new ImageState(w, h, layers, reinsertionIndex);
            states.performAction(result);
        }
    }

    // move layer up
    public void moveLayerUp() {
        // pre-check
        if (states.getState().canMoveLayerUp()) {
            // build resultant state
            final int w = states.getState().getImageWidth(),
                    h = states.getState().getImageHeight();
            final List<SELayer> layers = new ArrayList<>(states.getState().getLayers());
            final int removalIndex = states.getState().getLayerEditIndex(),
                    reinsertionIndex = removalIndex + 1;

            final SELayer toMove = layers.get(removalIndex);
            layers.remove(removalIndex);
            layers.add(reinsertionIndex, toMove);

            final ImageState result = new ImageState(w, h, layers, reinsertionIndex);
            states.performAction(result);
        }
    }

    // combine with layer below
    public void combineWithLayerBelow() {
        // pre-check - identical pass case as can move layer down
        if (states.getState().canMoveLayerDown()) {
            // build resultant state
            final int w = states.getState().getImageWidth(),
                    h = states.getState().getImageHeight();
            final List<SELayer> layers = new ArrayList<>(states.getState().getLayers());
            final int aboveIndex = states.getState().getLayerEditIndex(),
                    belowIndex = aboveIndex - 1;

            final SELayer above = layers.get(aboveIndex),
                    below = layers.get(belowIndex);
            final SELayer combined = LayerCombiner.combine(above, below);
            layers.remove(above);
            layers.remove(below);
            layers.add(belowIndex, combined);

            final ImageState result = new ImageState(w, h, layers, belowIndex);
            states.performAction(result);
        }
    }

    // GETTERS
    public boolean hasTargetPixel() {
        return targetPixel != UNTARGETED;
    }

    public Coord2D getTargetPixel() {
        return targetPixel;
    }

    public String getTargetPixelText() {
        return hasTargetPixel() ? targetPixel.toString() : "--";
    }

    public String getCanvasSizeText() {
        return states.getState().getImageWidth() + " x " + states.getState().getImageHeight();
    }

    public RenderInfo getRenderInfo() {
        return renderInfo;
    }

    public StateManager<ImageState> getStates() {
        return states;
    }
}
