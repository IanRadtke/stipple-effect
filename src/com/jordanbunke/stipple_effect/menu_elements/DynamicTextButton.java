package com.jordanbunke.stipple_effect.menu_elements;

import com.jordanbunke.delta_time.debug.GameDebugger;
import com.jordanbunke.delta_time.error.GameError;
import com.jordanbunke.delta_time.image.GameImage;
import com.jordanbunke.delta_time.menus.menu_elements.button.MenuButton;
import com.jordanbunke.delta_time.utility.Coord2D;
import com.jordanbunke.stipple_effect.utility.Constants;
import com.jordanbunke.stipple_effect.utility.GraphicsUtils;

import java.util.concurrent.Callable;

public class DynamicTextButton extends MenuButton {
    private final Callable<String> getter;
    private String text;

    private GameImage baseImage, highlightedImage;

    public DynamicTextButton(
            final Coord2D position, final int width,
            final Anchor anchor, final Runnable onClick,
            final Callable<String> getter
    ) {
        super(position, new Coord2D(width, Constants.STD_TEXT_BUTTON_H),
                anchor, true, onClick);

        this.getter = getter;
        text = fetchText();

        updateAssets();
    }

    @Override
    public void update(final double deltaTime) {
        final String fetched = fetchText();

        if (!text.equals(fetched)) {
            text = fetched;
            updateAssets();
        }
    }

    @Override
    public void render(final GameImage canvas) {
        draw(isHighlighted() ? highlightedImage : baseImage, canvas);
    }

    @Override
    public void debugRender(GameImage canvas, GameDebugger debugger) {

    }

    private String fetchText() {
        try {
            return getter.call();
        } catch (Exception e) {
            GameError.send("Failed to fetch updated text");
            return text;
        }
    }

    private void updateAssets() {
        baseImage = GraphicsUtils.drawTextButton(getWidth(), text, false, Constants.GREY);
        highlightedImage = GraphicsUtils.drawHighlightedButton(baseImage);
    }
}
