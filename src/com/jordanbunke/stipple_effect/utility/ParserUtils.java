package com.jordanbunke.stipple_effect.utility;

import com.jordanbunke.delta_time.image.GameImage;
import com.jordanbunke.delta_time.io.FileIO;
import com.jordanbunke.delta_time.io.ResourceLoader;
import com.jordanbunke.delta_time.text.TextBuilder;
import com.jordanbunke.stipple_effect.stip.ParserSerializer;
import com.jordanbunke.stipple_effect.utility.settings.Settings;
import com.jordanbunke.stipple_effect.visual.GraphicsUtils;
import com.jordanbunke.stipple_effect.visual.theme.Theme;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ParserUtils {
    public static final int CODE = 0, VALUE = 1, DESIRED = 2;

    public static GameImage generateStatusEffectText(final String message) {
        final Theme t = Settings.getTheme();
        final TextBuilder tb = GraphicsUtils.uiText(t.textLight.get());

        final String[] segments = extractHighlight(message,
                Constants.OPEN_COLOR, Constants.CLOSE_COLOR);

        for (int i = 0; i < segments.length; i++) {
            if (i % 2 == 0)
                tb.setColor(t.textLight.get());
            else {
                tb.setColor(t.affixTextLight.get());
                tb.addText("#");
                tb.setColor(ParserSerializer.deserializeColor(segments[i]));
            }

            tb.addText(segments[i]);
        }

        return tb.build().draw();
    }

    public static String[] extractHighlight(final String inputLine) {
        return extractHighlight(inputLine,
                Constants.OPEN_HIGHLIGHT, Constants.CLOSE_HIGHLIGHT);
    }

    private static String[] extractHighlight(
            final String inputLine, final String open, final String close
    ) {
        String leftToProcess = inputLine;
        final List<String> blocks = new ArrayList<>();

        while (leftToProcess.contains(open) && leftToProcess.contains(close) &&
                leftToProcess.indexOf(open) < leftToProcess.indexOf(close)) {
            final int openIndex = leftToProcess.indexOf(open),
                    closeIndex = leftToProcess.indexOf(close);

            blocks.add(leftToProcess.substring(0, openIndex));
            blocks.add(leftToProcess.substring(openIndex + open.length(), closeIndex));

            leftToProcess = leftToProcess.substring(closeIndex + close.length());
        }

        if (!leftToProcess.isEmpty())
            blocks.add(leftToProcess);

        return blocks.toArray(String[]::new);
    }

    public static String[] getBlurb(final String blurbCode) {
        final Path blurbFile = Constants.BLURB_FOLDER.resolve(blurbCode + ".txt");

        return FileIO.readResource(
                ResourceLoader.loadResource(blurbFile), "\"" + blurbCode + "\" blurb"
        ).split("\n");
    }

    public static String[] getToolTip(final String toolTipCode) {
        if (toolTipCode.startsWith(Constants.COLOR_TOOL_TIP_PREFIX))
            return toolTipCode.substring(Constants.COLOR_TOOL_TIP_PREFIX.length()).split("\n");

        final Path blurbFile = Constants.TOOL_TIP_FOLDER
                .resolve(toolTipCode + ".txt");

        return FileIO.readResource(ResourceLoader.loadResource(blurbFile),
                "\"" + toolTipCode + "\" tooltip").split("\n");
    }

    public static String[] splitIntoCodeAndValue(final String line) {
        final String sep = Constants.SETTING_SEPARATOR,
                o = Constants.OPEN_SETTING_VAL,
                c = Constants.CLOSE_SETTING_VAL;
        final int oi = line.indexOf(o), ol = o.length(),
                ci = line.indexOf(c), si = line.indexOf(sep);

        final boolean hasValue = oi > si && oi < ci, valid = si > 0 && hasValue;

        if (!valid)
            return new String[] {};

        final String code = line.substring(0, si),
                value = line.substring(oi + ol, ci);

        return new String[] { code, value };
    }

    public static String encloseSetting(final String code, final String value) {
        final String sep = Constants.SETTING_SEPARATOR,
                o = Constants.OPEN_SETTING_VAL,
                c = Constants.CLOSE_SETTING_VAL;

        return code + sep + o + value + c + "\n";
    }
}
