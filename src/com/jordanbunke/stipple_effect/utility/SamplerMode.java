package com.jordanbunke.stipple_effect.utility;

import com.jordanbunke.delta_time.utility.math.Coord2D;
import com.jordanbunke.stipple_effect.visual.menu_elements.colors.ColorComponent;

public enum SamplerMode {
    RGB_SLIDERS, HSV_SLIDERS, SAT_VAL_MATRIX, COLOR_WHEEL;

    @Override
    public String toString() {
        return switch (this) {
            case RGB_SLIDERS -> "RGB Sliders";
            case HSV_SLIDERS -> "HSV Sliders";
            case SAT_VAL_MATRIX -> "Sat-Value Matrix";
            default -> EnumUtils.formattedName(this);
        };
    }

    public int componentCount() {
        return switch (this) {
            case RGB_SLIDERS, HSV_SLIDERS -> 3;
            default -> 0;
        };
    }

    public ColorComponent getForIndex(
            final int index, final Coord2D position
    ) {
        final boolean rgb = this == RGB_SLIDERS;

        if (!rgb && this != HSV_SLIDERS)
            return null;

        return switch (index) {
            case 0 -> rgb ? ColorComponent.red(position)
                    : ColorComponent.hue(position);
            case 1 -> rgb ? ColorComponent.green(position)
                    : ColorComponent.sat(position);
            case 2 -> rgb ? ColorComponent.blue(position)
                    : ColorComponent.value(position);
            default -> null;
        };
    }
}
