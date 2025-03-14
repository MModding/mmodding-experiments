package com.mmodding.library.java.api.color;

public class RGB implements Color {

	protected int red;
	protected int green;
	protected int blue;

	RGB(int red, int green, int blue) {
		this.red = this.safe(red);
		this.green = this.safe(green);
		this.blue = this.safe(blue);
	}

	protected int safe(int value) {
		return Math.max(0, Math.min(255, value));
	}

	public int getRed() {
		return this.red;
	}

	public int getGreen() {
		return this.green;
	}

	public int getBlue() {
		return this.blue;
	}

	public int setRed(int red) {
		return this.red = this.safe(red);
	}

	public int setGreen(int green) {
		return this.green = this.safe(green);
	}

	public int setBlue(int blue) {
		return this.blue = this.safe(blue);
	}

	public int alterRed(int alteration) {
		return this.setRed(this.safe(this.getRed() + alteration));
	}

	public int alterGreen(int alteration) {
		return this.setGreen(this.safe(this.getGreen() + alteration));
	}

	public int alterBlue(int alteration) {
		return this.setBlue(this.safe(this.getBlue() + alteration));
	}

	public ARGB toARGB(int alpha) {
		return new ARGB(alpha, this.red, this.green, this.blue);
	}

	public HSB toHSB() {
		float[] hsb = java.awt.Color.RGBtoHSB(this.getRed(), this.getGreen(), this.getBlue(), null);
		return new HSB(hsb[0], hsb[1], hsb[2]);
	}

	@Override
	public int toDecimal() {
		return 255 << 24 | this.red << 16 | this.green << 8 | this.blue;
	}

	@Override
	public java.awt.Color toJavaColor() {
		return new java.awt.Color(this.red, this.green, this.blue);
	}

	@Override
	public Color copy() {
		return new RGB(this.red, this.green, this.blue);
	}
}
