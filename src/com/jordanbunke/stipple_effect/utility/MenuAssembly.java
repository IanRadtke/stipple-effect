package com.jordanbunke.stipple_effect.utility;

import com.jordanbunke.delta_time.error.GameError;
import com.jordanbunke.delta_time.image.GameImage;
import com.jordanbunke.delta_time.menus.Menu;
import com.jordanbunke.delta_time.menus.MenuBuilder;
import com.jordanbunke.delta_time.menus.menu_elements.MenuElement;
import com.jordanbunke.delta_time.menus.menu_elements.button.SimpleMenuButton;
import com.jordanbunke.delta_time.menus.menu_elements.button.SimpleToggleMenuButton;
import com.jordanbunke.delta_time.utility.Coord2D;
import com.jordanbunke.stipple_effect.StippleEffect;
import com.jordanbunke.stipple_effect.layer.SELayer;
import com.jordanbunke.stipple_effect.menu_elements.colors.ColorButton;
import com.jordanbunke.stipple_effect.menu_elements.colors.ColorSelector;
import com.jordanbunke.stipple_effect.menu_elements.scrollable.HorizontalSlider;
import com.jordanbunke.stipple_effect.menu_elements.scrollable.ScrollableMenuElement;
import com.jordanbunke.stipple_effect.menu_elements.scrollable.SelectableListItemButton;
import com.jordanbunke.stipple_effect.menu_elements.scrollable.VerticalScrollingMenuElement;
import com.jordanbunke.stipple_effect.tools.*;

import java.util.List;

public class MenuAssembly {

    private static final Tool[] ALL_TOOLS = new Tool[] {
            Hand.get(), Zoom.get(),
            StipplePencil.get(), Pencil.get(), Brush.get(), Eraser.get(),
            ColorPicker.get()
            // TODO - populate
    };

    public static Menu stub() {
        return new Menu();
    }

    public static Menu buildProjectsMenu() {
        final MenuBuilder mb = new MenuBuilder();

        final String[] iconIDs = new String[] {
                "new_project",
                "open_file",
                "save",
                "save_as",
                "wip", // TODO - resize
                "wip" // TODO - pad
        };

        final boolean[] preconditions = new boolean[] {
                true, true, true, true, true, true
        };

        final Runnable[] behaviours = new Runnable[] {
                () -> {}, // TODO all
                () -> {},
                () -> {},
                () -> {},
                () -> {},
                () -> {}
        };

        populateButtonsIntoBuilder(mb, iconIDs, preconditions,
                behaviours, Constants.getProjectsPosition());

        // TODO - project previews themselves

        return mb.build();
    }

    public static Menu buildFramesMenu() {
        final MenuBuilder mb = new MenuBuilder();

        final String[] iconIDs = new String[] {
                "new_frame",
                "duplicate_frame",
                "remove_frame",
                "to_first_frame",
                "previous",
                "play", // TODO - composite button with stop depending on scenario
                "next",
                "to_last_frame"
        };

        final boolean[] preconditions = new boolean[] {
                true, // TODO - consider a setting check ... if frames are enabled for project
                true, // TODO rest
                true,
                true,
                true,
                true,
                true,
                true
        };

        final Runnable[] behaviours = new Runnable[] {
                () -> {}, // TODO all
                () -> {},
                () -> {},
                () -> {},
                () -> {},
                () -> {},
                () -> {},
                () -> {}
        };

        populateButtonsIntoBuilder(mb, iconIDs, preconditions,
                behaviours, Constants.getFramesPosition());

        // TODO - frames themselves

        return mb.build();
    }

    public static Menu buildLayersMenu() {
        final MenuBuilder mb = new MenuBuilder();

        final String[] iconIDs = new String[] {
                "new_layer",
                "duplicate_layer",
                "remove_layer",
                "move_layer_up",
                "move_layer_down",
                "combine_with_layer_below"
        };

        final boolean[] preconditions = new boolean[] {
                StippleEffect.get().getContext().getState().canAddLayer(),
                StippleEffect.get().getContext().getState().canAddLayer(),
                StippleEffect.get().getContext().getState().canRemoveLayer(),
                StippleEffect.get().getContext().getState().canMoveLayerUp(),
                StippleEffect.get().getContext().getState().canMoveLayerDown(),
                // identical precondition for combine case
                StippleEffect.get().getContext().getState().canMoveLayerDown()
        };

        final Runnable[] behaviours = new Runnable[] {
                () -> StippleEffect.get().getContext().addLayer(),
                () -> StippleEffect.get().getContext().duplicateLayer(),
                () -> StippleEffect.get().getContext().removeLayer(),
                () -> StippleEffect.get().getContext().moveLayerUp(),
                () -> StippleEffect.get().getContext().moveLayerDown(),
                () -> StippleEffect.get().getContext().combineWithLayerBelow()
        };

        populateButtonsIntoBuilder(mb, iconIDs, preconditions,
                behaviours, Constants.getLayersPosition());

        final List<SELayer> layers = StippleEffect.get().getContext().getState().getLayers();
        final int amount = layers.size(), elementsPerLayer = 3; // TODO - 4: isolate button

        final ScrollableMenuElement[] layerButtons = new ScrollableMenuElement[amount * elementsPerLayer];

        final Coord2D firstPos = Constants.getLayersPosition()
                .displace(Constants.TOOL_NAME_X, Constants.LAYERS_BUTTONS_OFFSET_Y);
        int realBottomY = firstPos.y;

        for (int i = amount - 1; i >= 0; i--) {
            final SELayer layer = layers.get(i);

            final GameImage baseImage = GraphicsUtils.drawTextButton(Constants.LAYER_BUTTON_W,
                    layer.getName(), false, Constants.GREY),
                    highlightedImage = GraphicsUtils.drawHighlightedButton(baseImage),
                    selectedImage = GraphicsUtils.drawTextButton(Constants.LAYER_BUTTON_W,
                            layer.getName(), true, Constants.GREY);

            final Coord2D pos = firstPos.displace(0,
                    (amount - (i + 1)) * Constants.STD_TEXT_BUTTON_INC),
                    dims = new Coord2D(baseImage.getWidth(), baseImage.getHeight());

            layerButtons[i] = new ScrollableMenuElement(new SelectableListItemButton(pos, dims,
                    MenuElement.Anchor.LEFT_TOP, baseImage, highlightedImage, selectedImage,
                    i, () -> StippleEffect.get().getContext().getState().getLayerEditIndex(),
                    s -> {
                        StippleEffect.get().getContext().getState().setLayerEditIndex(s);
                        StippleEffect.get().rebuildLayersMenu();
                    }
            ));

            // opacity slider

            final int MAX_OPACITY = 255, index = i;

            final Coord2D osPos = pos.displace(
                    Constants.LAYER_BUTTON_W + Constants.BUTTON_OFFSET,
                    Constants.STD_TEXT_BUTTON_H / 2);

            final HorizontalSlider opacitySlider = new HorizontalSlider(osPos,
                    Constants.LAYER_OPACITY_SLIDER_W, MenuElement.Anchor.LEFT_CENTRAL,
                    0, MAX_OPACITY,
                    (int)(StippleEffect.get().getContext().getState().getLayers()
                            .get(index).getOpacity() * MAX_OPACITY),
                    o -> StippleEffect.get().getContext()
                            .changeLayerOpacity(o / (double) MAX_OPACITY, index));

            opacitySlider.updateAssets();
            layerButtons[amount + i] = new ScrollableMenuElement(opacitySlider);

            // visibility toggle

            final Coord2D vtPos = osPos.displace(Constants.LAYER_OPACITY_SLIDER_W +
                    Constants.BUTTON_OFFSET, 0);

            layerButtons[(2 * amount) + i] =
                    new ScrollableMenuElement(generateVisibilityToggle(i, vtPos));

            // TODO - isolate layer

            realBottomY = pos.y + dims.y;
        }

        final int
                selectedIndex = StippleEffect.get().getContext().getState().getLayerEditIndex(),
                initialOffsetY = layerButtonDisplacement(selectedIndex, amount).y;

        mb.add(new VerticalScrollingMenuElement(firstPos,
                new Coord2D(Constants.VERT_SCROLL_WINDOW_W, Constants.VERT_SCROLL_WINDOW_H),
                layerButtons, realBottomY, initialOffsetY));

        return mb.build();
    }

    private static SimpleToggleMenuButton generateVisibilityToggle(
            final int index, final Coord2D pos
    ) {
        // 0: is enabled, button click should DISABLE; 1: vice-versa

        final GameImage enabled = GraphicsUtils.getIcon("layer_enabled"),
                disabled = GraphicsUtils.getIcon("layer_disabled");

        return new SimpleToggleMenuButton(pos,
                new Coord2D(Constants.BUTTON_DIM, Constants.BUTTON_DIM),
                MenuElement.Anchor.LEFT_CENTRAL, true,
                new GameImage[] { enabled, disabled },
                new GameImage[] {
                        GraphicsUtils.highlightIconButton(enabled),
                        GraphicsUtils.highlightIconButton(disabled)
                },
                new Runnable[] {
                        () -> StippleEffect.get().getContext().disableLayer(index),
                        () -> StippleEffect.get().getContext().enableLayer(index)
                },
                () -> StippleEffect.get().getContext().getState()
                        .getLayers().get(index).isEnabled() ? 0 : 1,
                () -> {});
    }

    private static Coord2D layerButtonDisplacement(final int index, final int amount) {
        // by default, selecting a layer should display the two layers above it
        return new Coord2D(0, (amount - ((index +
                Constants.LAYERS_ABOVE_TO_DISPLAY) + 1)) *
                Constants.STD_TEXT_BUTTON_INC);
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
            final Coord2D pos = segmentPosition
                    .displace(Constants.SEGMENT_TITLE_BUTTON_OFFSET_X,
                            Constants.BUTTON_OFFSET)
                    .displace(i * Constants.BUTTON_INC, 0);
            mb.add(GraphicsUtils.generateIconButton(iconIDs[i],
                    pos, preconditions[i], behaviours[i]));
        }
    }

    public static Menu buildColorsMenu() {
        final MenuBuilder mb = new MenuBuilder();

        populateButtonsIntoBuilder(
                mb, new String[] { "swap_colors" }, new boolean[] { true },
                new Runnable[] { () -> StippleEffect.get().swapColors() }, Constants.getColorsPosition()
        );

        final int NUM_COLORS = 2;

        for (int i = 0; i < NUM_COLORS; i++) {
            final int width = Constants.STD_TEXT_BUTTON_W;
            final Coord2D pos = Constants.getColorsPosition().displace(
                    Constants.COLOR_PICKER_W - (Constants.TOOL_NAME_X +
                            ((NUM_COLORS - i) * (width + Constants.BUTTON_OFFSET))),
                    Constants.BUTTON_OFFSET);

            mb.add(new ColorButton(pos, i));
        }

        mb.add(ColorSelector.make());

        return mb.build();
    }

    public static Menu buildToolButtonMenu() {
        final MenuBuilder mb = new MenuBuilder();

        for (int i = 0; i < ALL_TOOLS.length; i++) {
            mb.add(toolButtonFromTool(ALL_TOOLS[i], i));
        }

        return mb.build();
    }

    private static SimpleMenuButton toolButtonFromTool(
            final Tool tool, final int index
    ) {
        final Coord2D position = Constants.getToolsPosition().displace(
                Constants.BUTTON_OFFSET,
                Constants.BUTTON_OFFSET + (Constants.BUTTON_INC * index)
        );

        return new SimpleMenuButton(position, Constants.TOOL_ICON_DIMS,
                MenuElement.Anchor.LEFT_TOP, true, () -> StippleEffect.get().setTool(tool),
                StippleEffect.get().getTool().equals(tool) ? tool.getSelectedIcon() : tool.getIcon(),
                tool.getHighlightedIcon());
    }

}
