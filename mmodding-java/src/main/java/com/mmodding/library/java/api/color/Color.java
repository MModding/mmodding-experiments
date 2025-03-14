package com.mmodding.library.java.api.color;

import com.mmodding.library.java.api.object.Copyable;

import java.util.function.Supplier;

public interface Color extends Copyable<Color> {

	Supplier<Color> EMPTY = () -> Color.rgb(0, 0, 0);

	Supplier<Color> BLANK = () -> Color.rgb(255, 255, 255);

	static RGB rgb(Color color) {
		return Color.rgb(color.toDecimal());
	}

	/**
	 * RGB Color Format
	 * @param red red value, between 0 and 255
	 * @param green green value, between 0 and 255
	 * @param blue blue value, between 0 and 255
	 * @return the RGB object
	 */
	static RGB rgb(int red, int green, int blue) {
		return new RGB(red, green, blue);
	}

	static RGB rgb(int decimal) {
		return new RGB(decimal >> 16 & 255, decimal >> 8 & 255, decimal & 255);
	}

	static RGB rgb(java.awt.Color javaColor) {
		return new RGB(javaColor.getRed(), javaColor.getGreen(), javaColor.getBlue());
	}


	/**
	 * ARGB Color Format
	 * @param alpha alpha value, between 0 and 255
	 * @param red red value, between 0 and 255
	 * @param green green value, between 0 and 255
	 * @param blue blue value, between 0 and 255
	 * @return the RGB object
	 */
	static ARGB argb(int alpha, int red, int green, int blue) {
		return new ARGB(alpha, red, green, blue);
	}

	static ARGB argb(int decimal) {
		return new ARGB(decimal >> 24 & 255, decimal >> 16 & 255, decimal >> 8 & 255, decimal & 255);
	}

	static ARGB argb(java.awt.Color javaColor) {
		return new ARGB(javaColor.getAlpha(), javaColor.getRed(), javaColor.getGreen(), javaColor.getBlue());
	}

	/**
	 * HSB Color Format
	 * @param hue hue value, can be any floating point value
	 * @param saturation value, between 0.0f and 1.0f
	 * @param brightness value, between 0.0f and 1.0f
	 * @return the RGB object
	 */
	static HSB hsb(float hue, float saturation, float brightness) {
		return new HSB(hue, saturation, brightness);
	}

	static HSB hsb(int decimal) {
		return Color.rgb(decimal).toHSB();
	}

	static HSB hsb(java.awt.Color javaColor) {
		return Color.rgb(javaColor).toHSB();
	}

	int toDecimal();

	java.awt.Color toJavaColor();
}
