package com.jordanbunke.stipple_effect.tools;

import com.jordanbunke.delta_time.events.GameMouseEvent;
import com.jordanbunke.delta_time.image.GameImage;
import com.jordanbunke.delta_time.utility.Coord2D;
import com.jordanbunke.stipple_effect.project.SEContext;
import com.jordanbunke.stipple_effect.utility.Constants;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;

public final class Brush extends ToolWithBreadth {
    private static final Brush INSTANCE;

    private boolean painting;
    private BiFunction<Integer, Integer, Color> c;
    private Set<Coord2D> painted;

    static {
        INSTANCE = new Brush();
    }

    private Brush() {
        painting = false;
        c = (x, y) -> Constants.BLACK;
        painted = new HashSet<>();
    }

    public static Brush get() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Brush";
    }

    @Override
    public void onMouseDown(
            final SEContext context, final GameMouseEvent me
    ) {
        if (!context.getTargetPixel().equals(Constants.NO_VALID_TARGET) &&
                me.button != GameMouseEvent.Button.MIDDLE) {
            painting = true;
            c = ToolThatDraws.getColorMode(me);
            painted = new HashSet<>();

            reset();
            context.getState().markAsCheckpoint(false, context);
        }
    }

    @Override
    public void update(
            final SEContext context, final Coord2D mousePosition
    ) {
        final Coord2D tp = context.getTargetPixel();

        if (painting && !tp.equals(Constants.NO_VALID_TARGET)) {
            final int w = context.getState().getImageWidth(),
                    h = context.getState().getImageHeight();
            final Set<Coord2D> selection = context.getState().getSelection();

            if (isUnchanged(context))
                return;

            if (!stillSameFrame(context))
                painted.clear();

            final GameImage edit = new GameImage(w, h);
            populateAround(edit, tp, selection);

            final int xDiff = tp.x - getLastTP().x, yDiff = tp.y - getLastTP().y,
                    xUnit = (int)Math.signum(xDiff),
                    yUnit = (int)Math.signum(yDiff);
            if (!getLastTP().equals(Constants.NO_VALID_TARGET) &&
                    (Math.abs(xDiff) > 1 || Math.abs(yDiff) > 1)) {
                if (Math.abs(xDiff) > Math.abs(yDiff)) {
                    for (int x = 1; x < Math.abs(xDiff); x++) {
                        final int y = (int)(x * Math.abs(yDiff / (double)xDiff));
                        populateAround(edit, getLastTP().displace(
                                xUnit * x, yUnit* y), selection);
                    }
                } else {
                    for (int y = 1; y < Math.abs(yDiff); y++) {
                        final int x = (int)(y * Math.abs(xDiff / (double)yDiff));
                        populateAround(edit, getLastTP().displace(
                                xUnit * x, yUnit* y), selection);
                    }
                }
            }

            context.paintOverImage(edit.submit());
            updateLast(context);
        }
    }

    private void populateAround(
            final GameImage edit, final Coord2D tp,
            final Set<Coord2D> selection
    ) {
        final int halfB = breadthOffset();
        final boolean[][] mask = breadthMask();

        for (int x = 0; x < mask.length; x++)
            for (int y = 0; y < mask[x].length; y++) {
                final Coord2D b = new Coord2D(x + (tp.x - halfB),
                        y + (tp.y - halfB));

                if (!(selection.isEmpty() || selection.contains(b)))
                    continue;

                if (mask[x][y] && !painted.contains(b)) {
                    edit.dot(c.apply(b.x, b.y), b.x, b.y);
                    painted.add(b);
                }
            }
    }

    @Override
    public void onMouseUp(
            final SEContext context, final GameMouseEvent me
    ) {
        if (painting) {
            painting = false;
            context.getState().markAsCheckpoint(true, context);
            me.markAsProcessed();
        }
    }
}
