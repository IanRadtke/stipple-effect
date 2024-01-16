package com.jordanbunke.stipple_effect.visual;

import com.jordanbunke.delta_time.error.GameError;
import com.jordanbunke.delta_time.image.GameImage;
import com.jordanbunke.delta_time.menus.Menu;
import com.jordanbunke.delta_time.menus.MenuBuilder;
import com.jordanbunke.delta_time.menus.menu_elements.MenuElement;
import com.jordanbunke.delta_time.menus.menu_elements.button.SimpleMenuButton;
import com.jordanbunke.delta_time.menus.menu_elements.button.SimpleToggleMenuButton;
import com.jordanbunke.delta_time.menus.menu_elements.invisible.GatewayMenuElement;
import com.jordanbunke.delta_time.menus.menu_elements.visual.StaticMenuElement;
import com.jordanbunke.delta_time.utility.Coord2D;
import com.jordanbunke.stipple_effect.StippleEffect;
import com.jordanbunke.stipple_effect.color_selection.Palette;
import com.jordanbunke.stipple_effect.project.PlaybackInfo;
import com.jordanbunke.stipple_effect.project.SEContext;
import com.jordanbunke.stipple_effect.layer.OnionSkinMode;
import com.jordanbunke.stipple_effect.layer.SELayer;
import com.jordanbunke.stipple_effect.selection.SelectionMode;
import com.jordanbunke.stipple_effect.utility.Layout;
import com.jordanbunke.stipple_effect.visual.menu_elements.*;
import com.jordanbunke.stipple_effect.visual.menu_elements.colors.ColorTextBox;
import com.jordanbunke.stipple_effect.visual.menu_elements.colors.ColorSelector;
import com.jordanbunke.stipple_effect.visual.menu_elements.colors.PaletteColorButton;
import com.jordanbunke.stipple_effect.visual.menu_elements.scrollable.HorizontalScrollingMenuElement;
import com.jordanbunke.stipple_effect.visual.menu_elements.scrollable.HorizontalSlider;
import com.jordanbunke.stipple_effect.visual.menu_elements.scrollable.ScrollableMenuElement;
import com.jordanbunke.stipple_effect.visual.menu_elements.scrollable.VerticalScrollingMenuElement;
import com.jordanbunke.stipple_effect.tools.*;
import com.jordanbunke.stipple_effect.utility.Constants;
import com.jordanbunke.stipple_effect.utility.IconCodes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuAssembly {

    public static Menu stub() {
        return new Menu();
    }

    public static Menu buildProjectsMenu() {
        final MenuBuilder mb = new MenuBuilder();
        final SEContext c = StippleEffect.get().getContext();

        mb.add(TextLabel.make(Layout.getProjectsPosition().displace(
                        Layout.CONTENT_BUFFER_PX, Layout.TEXT_Y_OFFSET),
                "Projects", Constants.WHITE));

        final String[] iconIDs = new String[] {
                IconCodes.SETTINGS,
                IconCodes.NEW_PROJECT, IconCodes.OPEN_FILE,
                IconCodes.SAVE, IconCodes.SAVE_AS,
                IconCodes.RESIZE, IconCodes.PAD, IconCodes.PREVIEW,
                IconCodes.UNDO, IconCodes.GRANULAR_UNDO,
                IconCodes.GRANULAR_REDO, IconCodes.REDO
        };

        final boolean[] preconditions = new boolean[] {
                true, true, true, true, true, true, true, true,
                c.getStateManager().canUndo(),
                c.getStateManager().canUndo(),
                c.getStateManager().canRedo(),
                c.getStateManager().canRedo()
        };

        final Runnable[] behaviours = new Runnable[] {
                DialogAssembly::setDialogToProgramSettings,
                DialogAssembly::setDialogToNewProject,
                () -> StippleEffect.get().openProject(),
                c.projectInfo::save,
                DialogAssembly::setDialogToSave,
                DialogAssembly::setDialogToResize,
                DialogAssembly::setDialogToPad,
                () -> PreviewWindow.set(c),
                () -> c.getStateManager().undoToCheckpoint(),
                () -> c.getStateManager().undo(true),
                () -> c.getStateManager().redo(true),
                () -> c.getStateManager().redoToCheckpoint()
        };

        populateButtonsIntoBuilder(mb, iconIDs, preconditions,
                behaviours, Layout.getProjectsPosition());

        // exit program button

        final Coord2D exitProgPos = Layout.getProjectsPosition().displace(
                Layout.getProjectsWidth() - (Layout.CONTENT_BUFFER_PX + Layout.BUTTON_DIM),
                Layout.ICON_BUTTON_OFFSET_Y);
        mb.add(IconButton.make(IconCodes.EXIT_PROGRAM, exitProgPos,
                DialogAssembly::setDialogToExitProgramAYS));

        // project previews

        final int amount = StippleEffect.get().getContexts().size(), elementsPerProject = 2,
                selectedIndex = StippleEffect.get().getContextIndex();

        final ScrollableMenuElement[] projectElements = new ScrollableMenuElement[amount * elementsPerProject];

        final Coord2D firstPos = Layout.getProjectsPosition()
                .displace(Layout.getSegmentContentDisplacement());
        int realRightX = firstPos.x, cumulativeWidth = 0, initialOffsetX = 0;

        for (int i = 0; i < amount; i++) {
            final String text = StippleEffect.get().getContexts().get(i)
                    .projectInfo.getFormattedName(true, true);
            final int paddedTextWidth = GraphicsUtils.uiText()
                    .addText(text).build().draw().getWidth() +
                    Layout.PROJECT_NAME_BUTTON_PADDING_W;

            final GameImage baseImage = GraphicsUtils.drawTextButton(paddedTextWidth,
                    text, false, Constants.GREY),
                    highlightedImage = GraphicsUtils.drawHighlightedButton(baseImage),
                    selectedImage = GraphicsUtils.drawTextButton(paddedTextWidth,
                            text, true, Constants.GREY);

            int offsetX = 0;

            final Coord2D pos = firstPos.displace(cumulativeWidth, 0),
                    dims = new Coord2D(baseImage.getWidth(), baseImage.getHeight());

            offsetX += paddedTextWidth + Layout.BUTTON_OFFSET;

            projectElements[i] = new ScrollableMenuElement(new SelectableListItemButton(pos, dims,
                    MenuElement.Anchor.LEFT_TOP, baseImage, highlightedImage, selectedImage,
                    i, () -> StippleEffect.get().getContextIndex(),
                    s -> StippleEffect.get().setContextIndex(s)
            ));

            // close project button

            final Coord2D cpPos = pos.displace(offsetX,
                    (Layout.STD_TEXT_BUTTON_H - Layout.BUTTON_DIM) / 2);

            offsetX += Layout.BUTTON_DIM + Layout.SPACE_BETWEEN_PROJECT_BUTTONS_X;

            final int index = i;
            final Runnable closeBehaviour = () -> {
                if (StippleEffect.get().getContexts().get(index).projectInfo.hasUnsavedChanges()) {
                    DialogAssembly.setDialogToCloseProjectAYS(index);
                } else {
                    StippleEffect.get().removeContext(index);
                }
            };

            projectElements[amount + i] = new ScrollableMenuElement(
                    IconButton.make(IconCodes.CLOSE_PROJECT, cpPos, closeBehaviour));

            cumulativeWidth += offsetX;
            realRightX = cpPos.x + Layout.BUTTON_DIM;

            if (i == selectedIndex - Layout.PROJECTS_BEFORE_TO_DISPLAY)
                initialOffsetX = pos.x - firstPos.x;
        }

        mb.add(new HorizontalScrollingMenuElement(firstPos, new Coord2D(
                Layout.getFrameScrollWindowWidth(), Layout.FRAME_SCROLL_WINDOW_H),
                projectElements, realRightX, initialOffsetX));

        return mb.build();
    }

    public static Menu buildFramesMenu() {
        final MenuBuilder mb = new MenuBuilder();
        final SEContext c = StippleEffect.get().getContext();

        mb.add(TextLabel.make(Layout.getFramesPosition().displace(
                        Layout.CONTENT_BUFFER_PX, Layout.TEXT_Y_OFFSET),
                "Frames", Constants.WHITE));

        final String[] iconIDs = new String[] {
                IconCodes.NEW_FRAME,
                IconCodes.DUPLICATE_FRAME,
                IconCodes.REMOVE_FRAME,
                IconCodes.MOVE_FRAME_BACK,
                IconCodes.MOVE_FRAME_FORWARD,
                IconCodes.TO_FIRST_FRAME,
                IconCodes.PREVIOUS,
                Constants.ICON_ID_GAP_CODE, // gap for play/stop button
                IconCodes.NEXT,
                IconCodes.TO_LAST_FRAME
        };

        final boolean[] preconditions = new boolean[] {
                c.getState().canAddFrame(),
                c.getState().canAddFrame(),
                c.getState().canRemoveFrame(),
                c.getState().canMoveFrameBack(),
                c.getState().canMoveFrameForward(),
                true,
                true,
                false, // placeholder
                true,
                true
        };

        final Runnable[] behaviours = new Runnable[] {
                () -> StippleEffect.get().getContext().addFrame(),
                () -> StippleEffect.get().getContext().duplicateFrame(),
                () -> StippleEffect.get().getContext().removeFrame(),
                () -> StippleEffect.get().getContext().moveFrameBack(),
                () -> StippleEffect.get().getContext().moveFrameForward(),
                () -> StippleEffect.get().getContext().getState().setFrameIndex(0),
                () -> StippleEffect.get().getContext().getState().previousFrame(),
                () -> {}, // placeholder
                () -> StippleEffect.get().getContext().getState().nextFrame(),
                () -> StippleEffect.get().getContext().getState().setFrameIndex(
                        StippleEffect.get().getContext().getState().getFrameCount() - 1
                )
        };

        populateButtonsIntoBuilder(mb, iconIDs, preconditions,
                behaviours, Layout.getFramesPosition());

        final Coord2D firstPos = Layout.getFramesPosition()
                .displace(Layout.getSegmentContentDisplacement());

        // play/stop as toggle

        final Coord2D playStopTogglePos = Layout.getFramesPosition().displace(
                Layout.SEGMENT_TITLE_BUTTON_OFFSET_X + (7 * Layout.BUTTON_INC),
                Layout.ICON_BUTTON_OFFSET_Y);

        mb.add(generatePlayStopToggle(playStopTogglePos));

        // playback mode toggle button

        final Coord2D playbackModeTogglePos = Layout.getFramesPosition().displace(
                Layout.SEGMENT_TITLE_BUTTON_OFFSET_X + (10 * Layout.BUTTON_INC),
                Layout.ICON_BUTTON_OFFSET_Y);
        mb.add(generatePlaybackModeToggle(playbackModeTogglePos));

        // playback speed slider and dynamic label for playback speed

        final Coord2D labelPos = Layout.getFramesPosition().displace(
                Layout.getFramesWidth() - Layout.CONTENT_BUFFER_PX, Layout.TEXT_Y_OFFSET);

        mb.add(new DynamicLabel(labelPos,
                MenuElement.Anchor.RIGHT_TOP, Constants.WHITE,
                () -> StippleEffect.get().getContext().playbackInfo.getFps() + " fps",
                Layout.DYNAMIC_LABEL_W_ALLOWANCE));

        final Coord2D playbackSliderPos = Layout.getFramesPosition().displace(
                Layout.getFramesWidth() - Layout.DYNAMIC_LABEL_W_ALLOWANCE,
                Layout.ICON_BUTTON_OFFSET_Y);

        final HorizontalSlider slider = new HorizontalSlider(playbackSliderPos,
                Layout.getUISliderWidth(), MenuElement.Anchor.RIGHT_TOP,
                Constants.MIN_PLAYBACK_FPS, Constants.MAX_PLAYBACK_FPS,
                StippleEffect.get().getContext().playbackInfo.getFps(),
                mpf -> StippleEffect.get().getContext()
                        .playbackInfo.setFps(mpf));
        slider.updateAssets();
        mb.add(slider);

        // frame content

        final int amount = StippleEffect.get().getContext().getState().getFrameCount(),
                elementsPerFrame = 1;

        final ScrollableMenuElement[] frameElements =
                new ScrollableMenuElement[amount * elementsPerFrame];

        int realRightX = firstPos.x;

        for (int i = 0; i < amount; i++) {
            final GameImage baseImage = GraphicsUtils.drawTextButton(Layout.FRAME_BUTTON_W,
                    String.valueOf(i + 1), false, Constants.GREY),
                    highlightedImage = GraphicsUtils.drawHighlightedButton(baseImage),
                    selectedImage = GraphicsUtils.drawTextButton(Layout.FRAME_BUTTON_W,
                            String.valueOf(i + 1), true, Constants.GREY);

            final Coord2D pos = firstPos.displace(
                    i * (Layout.FRAME_BUTTON_W + Layout.BUTTON_OFFSET), 0),
                    dims = new Coord2D(baseImage.getWidth(), baseImage.getHeight());

            frameElements[i] = new ScrollableMenuElement(new SelectableListItemButton(pos, dims,
                    MenuElement.Anchor.LEFT_TOP, baseImage, highlightedImage, selectedImage,
                    i, () -> StippleEffect.get().getContext().getState().getFrameIndex(),
                    s -> StippleEffect.get().getContext().getState().setFrameIndex(s)
            ));

            realRightX = pos.x + dims.x;
        }

        mb.add(new HorizontalScrollingMenuElement(firstPos, new Coord2D(
                Layout.getFrameScrollWindowWidth(), Layout.FRAME_SCROLL_WINDOW_H),
                frameElements, realRightX, frameButtonXDisplacement()));

        return mb.build();
    }

    private static SimpleToggleMenuButton generatePlaybackModeToggle(final Coord2D pos) {
        final PlaybackInfo.Mode[] validModes = new PlaybackInfo.Mode[] {
                PlaybackInfo.Mode.FORWARDS,
                PlaybackInfo.Mode.BACKWARDS,
                PlaybackInfo.Mode.LOOP,
                PlaybackInfo.Mode.PONG_FORWARDS
        };

        final String[] codes = Arrays.stream(validModes).map(
                PlaybackInfo.Mode::getIconCode).toArray(String[]::new);

        return IconToggleButton.make(pos, codes,
                Arrays.stream(validModes).map(mode ->
                        (Runnable) () -> {}).toArray(Runnable[]::new),
                () -> StippleEffect.get().getContext().playbackInfo
                        .getMode().buttonIndex(),
                () -> StippleEffect.get().getContext().playbackInfo.toggleMode(),
                i -> codes[i]);
    }

    private static SimpleToggleMenuButton generatePlayStopToggle(final Coord2D pos) {
        // 0: is playing, button click should STOP; 1: vice-versa
        final String[] codes = new String[] { IconCodes.STOP, IconCodes.PLAY };

        return IconToggleButton.make(pos, codes,
                new Runnable[] {
                        () -> StippleEffect.get().getContext()
                                .playbackInfo.stop(),
                        () -> StippleEffect.get().getContext()
                                .playbackInfo.play()
                },
                () -> StippleEffect.get().getContext()
                        .playbackInfo.isPlaying() ? 0 : 1,
                () -> {}, i -> codes[i]);
    }

    private static int frameButtonXDisplacement() {
        return (StippleEffect.get().getContext().getState().getFrameIndex() -
                Layout.FRAMES_BEFORE_TO_DISPLAY) *
                (Layout.FRAME_BUTTON_W + Layout.BUTTON_OFFSET);
    }

    public static Menu buildLayersMenu() {
        final MenuBuilder mb = new MenuBuilder();

        mb.add(TextLabel.make(Layout.getLayersPosition().displace(
                        Layout.CONTENT_BUFFER_PX, Layout.TEXT_Y_OFFSET),
                "Layers", Constants.WHITE));

        final String[] iconIDs = new String[] {
                IconCodes.NEW_LAYER,
                IconCodes.DUPLICATE_LAYER,
                IconCodes.REMOVE_LAYER,
                IconCodes.MOVE_LAYER_UP,
                IconCodes.MOVE_LAYER_DOWN,
                IconCodes.MERGE_WITH_LAYER_BELOW,
                IconCodes.ENABLE_ALL_LAYERS
        };

        final boolean[] preconditions = new boolean[] {
                StippleEffect.get().getContext().getState().canAddLayer(),
                StippleEffect.get().getContext().getState().canAddLayer(),
                StippleEffect.get().getContext().getState().canRemoveLayer(),
                StippleEffect.get().getContext().getState().canMoveLayerUp(),
                StippleEffect.get().getContext().getState().canMoveLayerDown(),
                StippleEffect.get().getContext().getState().canMoveLayerDown(),
                true
        };

        final Runnable[] behaviours = new Runnable[] {
                () -> StippleEffect.get().getContext().addLayer(true),
                () -> StippleEffect.get().getContext().duplicateLayer(),
                () -> StippleEffect.get().getContext().removeLayer(),
                () -> StippleEffect.get().getContext().moveLayerUp(),
                () -> StippleEffect.get().getContext().moveLayerDown(),
                () -> StippleEffect.get().getContext().mergeWithLayerBelow(),
                () -> StippleEffect.get().getContext().enableAllLayers()
        };

        populateButtonsIntoBuilder(mb, iconIDs, preconditions,
                behaviours, Layout.getLayersPosition());

        // layer content

        final List<SELayer> layers = StippleEffect.get().getContext().getState().getLayers();
        final int amount = layers.size(), elementsPerLayer = 6;

        final ScrollableMenuElement[] layerButtons = new ScrollableMenuElement[amount * elementsPerLayer];

        final Coord2D firstPos = Layout.getLayersPosition()
                .displace(Layout.getSegmentContentDisplacement());
        int realBottomY = firstPos.y;

        for (int i = amount - 1; i >= 0; i--) {
            final SELayer layer = layers.get(i);

            final String name = layer.getName(),
                    text = name.length() > Layout.LAYER_NAME_LENGTH_CUTOFF
                            ? name.substring(0, Layout.LAYER_NAME_LENGTH_CUTOFF) + "..."
                            : name;

            final GameImage baseImage = GraphicsUtils.drawTextButton(Layout.LAYER_BUTTON_W,
                    text, false, Constants.GREY),
                    highlightedImage = GraphicsUtils.drawHighlightedButton(baseImage),
                    selectedImage = GraphicsUtils.drawTextButton(Layout.LAYER_BUTTON_W,
                            text, true, Constants.GREY);

            final Coord2D pos = firstPos.displace(0,
                    (amount - (i + 1)) * Layout.STD_TEXT_BUTTON_INC),
                    dims = new Coord2D(baseImage.getWidth(), baseImage.getHeight());

            layerButtons[i] = new ScrollableMenuElement(new SelectableListItemButton(pos, dims,
                    MenuElement.Anchor.LEFT_TOP, baseImage, highlightedImage, selectedImage,
                    i, () -> StippleEffect.get().getContext().getState().getLayerEditIndex(),
                    s -> StippleEffect.get().getContext().getState().setLayerEditIndex(s)
            ));

            final int index = i;

            // visibility toggle

            final Coord2D vtPos = pos.displace(Layout.LAYER_BUTTON_W +
                    Layout.BUTTON_OFFSET, Layout.STD_TEXT_BUTTON_H / 2);

            layerButtons[amount + i] =
                    new ScrollableMenuElement(generateVisibilityToggle(index, vtPos));

            // isolate layer

            final Coord2D ilPos = vtPos.displace(Layout.BUTTON_INC,
                    (int)(Layout.BUTTON_DIM * -0.5));

            layerButtons[(2 * amount) + i] = new ScrollableMenuElement(
                    GraphicsUtils.generateIconButton(IconCodes.ISOLATE_LAYER, ilPos, true,
                    () -> StippleEffect.get().getContext().isolateLayer(index)));

            // onion skin toggle

            final Coord2D onionPos = vtPos.displace(Layout.BUTTON_INC * 2, 0);

            layerButtons[(3 * amount) + i] =
                    new ScrollableMenuElement(generateOnionSkinToggle(index, onionPos));

            // frames linked toggle

            final Coord2D flPos = onionPos.displace(Layout.BUTTON_INC, 0);

            layerButtons[(4 * amount) + i] =
                    new ScrollableMenuElement(generateFramesLinkedToggle(index, flPos));

            // layer settings

            final Coord2D lsPos = ilPos.displace(Layout.BUTTON_INC * 3, 0);

            layerButtons[(5 * amount) + i] = new ScrollableMenuElement(
                    GraphicsUtils.generateIconButton(IconCodes.LAYER_SETTINGS,
                            lsPos, true,
                            () -> DialogAssembly.setDialogToLayerSettings(index)));

            realBottomY = pos.y + dims.y;
        }

        final int initialOffsetY = layerButtonYDisplacement(amount);

        mb.add(new VerticalScrollingMenuElement(firstPos, new Coord2D(
                Layout.VERT_SCROLL_WINDOW_W, Layout.getVertScrollWindowHeight()),
                layerButtons, realBottomY, initialOffsetY));

        return mb.build();
    }

    private static SimpleToggleMenuButton generateVisibilityToggle(
            final int index, final Coord2D pos
    ) {
        // 0: is enabled, button click should DISABLE; 1: vice-versa
        final String[] codes = new String[] {
                IconCodes.LAYER_ENABLED, IconCodes.LAYER_DISABLED
        };

        return IconToggleButton.make(pos.displace(0, -Layout.BUTTON_DIM / 2),
                codes, new Runnable[] {
                        () -> StippleEffect.get().getContext().disableLayer(index),
                        () -> StippleEffect.get().getContext().enableLayer(index)
                },
                () -> StippleEffect.get().getContext().getState()
                        .getLayers().get(index).isEnabled() ? 0 : 1,
                () -> {}, i -> codes[i]);
    }

    private static SimpleToggleMenuButton generateOnionSkinToggle(
            final int index, final Coord2D pos
    ) {
        final String[] codes = Arrays.stream(OnionSkinMode.values())
                .map(OnionSkinMode::getIconCode).toArray(String[]::new);

        final Runnable[] behaviours = Arrays.stream(OnionSkinMode.values()).map(
                osm -> (Runnable) () -> {
                    final int nextIndex = (osm.ordinal() + 1) %
                            OnionSkinMode.values().length;
                    StippleEffect.get().getContext().getState()
                            .getLayers().get(index).setOnionSkinMode(
                                    OnionSkinMode.values()[nextIndex]);
                }).toArray(Runnable[]::new);

        return IconToggleButton.make(
                pos.displace(0, -Layout.BUTTON_DIM / 2),
                codes, behaviours,
                () -> StippleEffect.get().getContext().getState()
                        .getLayers().get(index).getOnionSkinMode().ordinal(),
                () -> {}, i -> codes[i]);
    }

    private static SimpleToggleMenuButton generateFramesLinkedToggle(
            final int index, final Coord2D pos
    ) {
        // 0: is unlinked, button click should LINK; 1: vice-versa
        final String[] codes = new String[] {
                IconCodes.FRAMES_UNLINKED,
                IconCodes.FRAMES_LINKED
        };

        return IconToggleButton.make(
                pos.displace(0, -Layout.BUTTON_DIM / 2),
                codes, new Runnable[] {
                        () -> StippleEffect.get().getContext().linkFramesInLayer(index),
                        () -> StippleEffect.get().getContext().unlinkFramesInLayer(index)
                },
                () -> StippleEffect.get().getContext().getState()
                        .getLayers().get(index).areFramesLinked() ? 1 : 0,
                () -> {}, i -> codes[i]);
    }

    private static int layerButtonYDisplacement(final int amount) {
        return (amount - ((StippleEffect.get().getContext().getState().getLayerEditIndex() +
                Layout.LAYERS_ABOVE_TO_DISPLAY) + 1)) * Layout.STD_TEXT_BUTTON_INC;
    }

    private static void populateButtonsIntoBuilder(
            final MenuBuilder mb, final String[] iconIDs,
            final boolean[] preconditions, final Runnable[] behaviours,
            final Coord2D segmentPosition
    ) {
        if (iconIDs.length != preconditions.length || iconIDs.length != behaviours.length) {
            GameError.send("Lengths of button assembly argument arrays did not match; " +
                    "buttons were not populated into menu builder.");
            return;
        }

        for (int i = 0; i < iconIDs.length; i++) {
            if (iconIDs[i].equals(Constants.ICON_ID_GAP_CODE))
                continue;

            final Coord2D pos = segmentPosition
                    .displace(Layout.SEGMENT_TITLE_BUTTON_OFFSET_X,
                            Layout.ICON_BUTTON_OFFSET_Y)
                    .displace(i * Layout.BUTTON_INC, 0);
            mb.add(GraphicsUtils.generateIconButton(iconIDs[i],
                    pos, preconditions[i], behaviours[i]));
        }
    }

    public static Menu buildColorsMenu() {
        final MenuBuilder mb = new MenuBuilder();

        mb.add(TextLabel.make(Layout.getColorsPosition().displace(
                Layout.CONTENT_BUFFER_PX, Layout.TEXT_Y_OFFSET),
                "Colors", Constants.WHITE));

        populateButtonsIntoBuilder(
                mb, new String[] {
                        IconCodes.SWAP_COLORS,
                        IconCodes.COLOR_MENU_MODE,
                },
                new boolean[] {
                        true,
                        true,
                },
                new Runnable[] {
                        () -> StippleEffect.get().swapColors(),
                        () -> StippleEffect.get().toggleColorMenuMode(),
                },
                Layout.getColorsPosition()
        );

        final int NUM_COLORS = 2;

        for (int i = 0; i < NUM_COLORS; i++) {
            final int offsetY = Layout.getSegmentContentDisplacement().y * 2;
            final Coord2D labelPos = Layout.getColorsPosition().displace(
                    Layout.getSegmentContentDisplacement()).displace(
                            i * (Layout.COLOR_PICKER_W / 2), 0),
                    textBoxPos = Layout.getColorsPosition().displace(
                            (Layout.COLOR_PICKER_W / 4) + (i *
                                    (Layout.COLOR_PICKER_W / 2)), offsetY);

            mb.add(TextLabel.make(labelPos, switch (i) {
                case 0 -> "Primary";
                case 1 -> "Secondary";
                default -> "Other";
            }, Constants.WHITE));

            final ColorTextBox colorTextBox = ColorTextBox.make(textBoxPos, i);
            mb.add(colorTextBox);

            final int index = i;
            final Coord2D dims = new Coord2D(colorTextBox.getWidth(),
                    colorTextBox.getHeight());
            final GatewayMenuElement highlight = new GatewayMenuElement(
                    new StaticMenuElement(textBoxPos, dims, MenuElement.Anchor.CENTRAL_TOP,
                            GraphicsUtils.drawSelectedTextBox(
                                    new GameImage(dims.x, dims.y))),
                    () -> StippleEffect.get().getColorIndex() == index);
            mb.add(highlight);
        }

        switch (StippleEffect.get().getColorMenuMode()) {
            case RGBA_HSV -> mb.add(new ColorSelector());
            case PALETTE -> addPaletteMenuElements(mb);
        }

        return mb.build();
    }

    private static void addPaletteMenuElements(final MenuBuilder mb) {
        final Coord2D startingPos = Layout.getColorsPosition().displace(
                Layout.CONTENT_BUFFER_PX, Layout.COLOR_SELECTOR_OFFSET_Y +
                        Layout.COLOR_LABEL_OFFSET_Y),
                paletteOptionsRef = startingPos.displace(
                        -Layout.CONTENT_BUFFER_PX, -Layout.TEXT_Y_OFFSET);
        final int contentWidth = Layout.COLOR_PICKER_W -
                        (2 * Layout.CONTENT_BUFFER_PX),
                dropDownHAllowance = Layout.getColorPickerHeight() -
                        (Layout.COLOR_SELECTOR_OFFSET_Y + Layout.CONTENT_BUFFER_PX);

        final List<Palette> palettes = StippleEffect.get().getPalettes();
        final int index = StippleEffect.get().getPaletteIndex();
        final boolean hasPaletteContents = StippleEffect.get().hasPaletteContents();

        // palette label
        mb.add(TextLabel.make(startingPos, "Palette", Constants.WHITE));

        // palette options
        populateButtonsIntoBuilder(
                mb, new String[] {
                        IconCodes.ADD_TO_PALETTE,
                        IconCodes.REMOVE_FROM_PALETTE,
                        IconCodes.IMPORT_PALETTE,
                        IconCodes.CONTENTS_TO_PALETTE,
                        IconCodes.SORT_PALETTE,
                        IconCodes.PALETTIZE,
                },
                new boolean[] {
                        hasPaletteContents,
                        hasPaletteContents,
                        true,
                        true,
                        hasPaletteContents,
                        hasPaletteContents
                },
                new Runnable[] {
                        () -> StippleEffect.get().addColorToPalette(),
                        () -> StippleEffect.get().removeColorFromPalette(),
                        // TODO
                        () -> {},
                        () -> {},
                        () -> {},
                        () -> {}
                }, paletteOptionsRef);

        //dropdown menu
        final List<Runnable> behaviours = new ArrayList<>();

        for (int i = 0; i < palettes.size(); i++) {
            final int toSet = i;
            behaviours.add(() -> StippleEffect.get().setPaletteIndex(toSet));
        }

        final Coord2D dropdownPos = startingPos.displace(0,
                Layout.getSegmentContentDisplacement().y);

        mb.add(hasPaletteContents
                ? new DropDownMenu(dropdownPos, contentWidth,
                MenuElement.Anchor.LEFT_TOP, dropDownHAllowance,
                palettes.stream().map(Palette::getName).toArray(String[]::new),
                behaviours.toArray(Runnable[]::new), () -> index)
                : new StaticMenuElement(dropdownPos,
                new Coord2D(contentWidth, Layout.STD_TEXT_BUTTON_H),
                MenuElement.Anchor.LEFT_TOP, GraphicsUtils.drawTextButton(
                contentWidth, "No palettes", false, Constants.DARK)));

        // palette buttons
        if (hasPaletteContents) {
            final Palette palette = palettes.get(index);

            final Coord2D container = startingPos.displace(0,
                    Layout.getColorSelectorIncY());
            final int fitsOnLine = (contentWidth - Layout.SLIDER_OFF_DIM) /
                    Layout.PALETTE_DIMS.x;
            final int height = Layout.getColorPickerHeight() -
                    ((container.y - Layout.getColorsPosition().y) +
                            Layout.CONTENT_BUFFER_PX);

            final List<PaletteColorButton> buttons = new ArrayList<>();
            final Color[] colors = palette.getColors();

            for (int i = 0; i < colors.length; i++) {
                final int x = i % fitsOnLine, y = i / fitsOnLine;
                final Coord2D pos = container.displace(
                        x * Layout.PALETTE_DIMS.x, y * Layout.PALETTE_DIMS.y);

                buttons.add(new PaletteColorButton(pos, colors[i]));
            }

            mb.add(new VerticalScrollingMenuElement(
                    container, new Coord2D(contentWidth, height),
                    buttons.stream().map(ScrollableMenuElement::new)
                            .toArray(ScrollableMenuElement[]::new),
                    container.displace(0, (colors.length / fitsOnLine) *
                            Layout.PALETTE_DIMS.y).y, 0));
        }
    }

    public static Menu buildToolButtonMenu() {
        final MenuBuilder mb = new MenuBuilder();
        final SEContext c = StippleEffect.get().getContext();

        for (int i = 0; i < Constants.ALL_TOOLS.length; i++) {
            mb.add(toolButtonFromTool(Constants.ALL_TOOLS[i], i));
        }

        // zoom slider
        final float base = 2f;
        final HorizontalSlider zoomSlider = new HorizontalSlider(
                Layout.getBottomBarPosition().displace(
                        Layout.getBottomBarZoomSliderX(),
                        Layout.BUTTON_OFFSET),
                Layout.getUISliderWidth(),
                MenuElement.Anchor.LEFT_TOP,
                (int)(Math.log(Constants.MIN_ZOOM) / Math.log(base)),
                (int)(Math.log(Constants.MAX_ZOOM) / Math.log(base)),
                (int)(Math.log(StippleEffect.get().getContext().renderInfo
                        .getZoomFactor()) / Math.log(base)), i ->
                StippleEffect.get().getContext().renderInfo
                        .setZoomFactor((float)Math.pow(base, i)));
        zoomSlider.updateAssets();

        mb.add(zoomSlider);

        // outline button
        final Coord2D outlinePos = Layout.getToolsPosition()
                .displace(Layout.BUTTON_OFFSET,
                        Layout.getWorkspaceHeight() - Layout.BUTTON_INC);

        final MenuElement outlineButton = GraphicsUtils.
                generateIconButton(IconCodes.OUTLINE, outlinePos,
                        true, DialogAssembly::setDialogToOutline);
        mb.add(outlineButton);

        // reflection buttons
        final MenuElement verticalReflectionButton = GraphicsUtils.
                generateIconButton(IconCodes.VERTICAL_REFLECTION,
                        outlinePos.displace(0, -Layout.BUTTON_INC),
                        c.getState().hasSelection(), () -> {
                    if (c.getState().getSelectionMode() == SelectionMode.BOUNDS)
                        c.reflectSelection(false);
                    else
                        c.reflectSelectionContents(false);
                        }
                );
        mb.add(verticalReflectionButton);
        final MenuElement horizontalReflectionButton = GraphicsUtils.
                generateIconButton(IconCodes.HORIZONTAL_REFLECTION,
                        outlinePos.displace(0, -2 * Layout.BUTTON_INC),
                        c.getState().hasSelection(), () -> {
                            if (c.getState().getSelectionMode() == SelectionMode.BOUNDS)
                                c.reflectSelection(true);
                            else
                                c.reflectSelectionContents(true);
                        }
                );
        mb.add(horizontalReflectionButton);

        // help button
        mb.add(IconButton.make(IconCodes.INFO,
                Layout.getBottomBarPosition().displace(
                        Layout.width() - Layout.BUTTON_DIM,
                        Layout.BUTTON_OFFSET),
                DialogAssembly::setDialogToInfo));

        return mb.build();
    }

    private static SimpleMenuButton toolButtonFromTool(
            final Tool tool, final int index
    ) {
        final Coord2D position = Layout.getToolsPosition().displace(
                Layout.BUTTON_OFFSET,
                Layout.BUTTON_OFFSET + (Layout.BUTTON_INC * index)
        );

        return new IconButton(tool.convertNameToFilename(),
                position, () -> StippleEffect.get().setTool(tool),
                StippleEffect.get().getTool().equals(tool)
                        ? tool.getSelectedIcon() : tool.getIcon(),
                tool.getHighlightedIcon());
    }

}
