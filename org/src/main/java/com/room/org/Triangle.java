package com.room.org;

import java.awt.Dimension;
import java.awt.geom.Area;

public class Triangle {
	
	private double height;
	private double width;
	private double xPoints[];
	private double yPoints[];
	public Triangle( Dimension d) {
		this.height = d.getHeight();
		this.width = d.getWidth();
		setXPoints();
		setYPoints();
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double[] getXPoints() {
		return xPoints;
	}
	public void setXPoints() {
		xPoints = new double[4];
		xPoints[0] = 0.0;
		xPoints[1] = this.width;
		xPoints[2] = this.width;
		xPoints[3] = 0.0;
		
	}
	public double[] getYPoints() {
		return yPoints;
	}
	public void setYPoints() {
		yPoints = new double[4];
		yPoints[0] = this.height;
		yPoints[1] = 0.0;
		yPoints[2] = this.height;
		yPoints[3] = this.height;
	}
	
}
