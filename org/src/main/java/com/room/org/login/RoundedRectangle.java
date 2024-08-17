package com.room.org.login;

import java.awt.Dimension;

public class RoundedRectangle {
	private double width;
	private double height;
	private final double widthDivisor = 3.0; //The rounded rectangle width is 1/3 of the full screen
	private final double heightRatio = 66.0 / 80.0; // The rounded rectangle height is 66/80 of the full screen
	private final double topGapRatio = 7.0/ 80; // The starting y coordinate is set to the amount of gap between the top of the screen and the top of the rounded rectangle
	private double startingPointX;
	private double startingPointY;
	private final double arcWidth = 30;	// arcWidth = the width to set the arc of this RoundRectangle2D
	private final double arcHeight = 30;// archHeight = the height to which to set the arc of this RoundRectangle
	
	
	public RoundedRectangle(Dimension d) {

		//The rounded rectangle width is 1/3 of the full screen
		double temp = d.getWidth();
		this.width = temp / widthDivisor;
		//the starting x coordinate is set to the width...
		this.startingPointX = width;
		// The rounded rectangle height is 66/80 of the full screen
		temp = d.getHeight();
		this.height = heightRatio * temp;
		// The starting y coordinate is set to the amount of gap between the top of the screen and the top of the rounded rectangle
		this.startingPointY = height * topGapRatio;
			
	}


	public double getWidth() {
		return width;
	}


	public double getHeight() {
		return height;
	}


	public double getWidthDivisor() {
		return widthDivisor;
	}


	public double getHeightRatio() {
		return heightRatio;
	}


	public double getTopGapRatio() {
		return topGapRatio;
	}


	public double getStartingPointX() {
		return startingPointX;
	}


	public double getStartingPointY() {
		return startingPointY;
	}


	public double getArcWidth() {
		return arcWidth;
	}


	public double getArcHeight() {
		return arcHeight;
	}
	
}
