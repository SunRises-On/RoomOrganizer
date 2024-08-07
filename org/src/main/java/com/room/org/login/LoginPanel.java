package com.room.org.login;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class LoginPanel extends JPanel implements ComponentListener{
	
	private RoundedRectangle roundedRectangle;
	public LoginPanel() {
		super();
		this.setOpaque(false);
		repaint();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON
				);
		
		Dimension d = this.getSize();
		//Insets insets = this.getInsets(); ?? idk 
		double w = d.getWidth();
		double h = d.getHeight();
		
		// The rounded rectangle width is 1/3 of the full screen
		double width = w/3; 
		// The rounded rectangle height is 66/80 of the full screen
		double heightRatio = 66.0 / 80;
		double height = heightRatio * h;
		// x = the X coordinate to which to set the location of the Rectangle
		double x = w/3;
		// y = the Y coordinate to which to set the location of the Rectangle
		double topGapRatio = 7.0/ 80; 
		double y = h * topGapRatio;
		// arcWidth = the width to set the arc of this RoundRectangle2D
		double arcWidth = 30;
		// archHeight = the height to which to set the arc of this RoundRectangle2
		double arcHeight = 30;

		
		Color c = Color.BLACK;
		g2.setPaint(c);
		System.out.println( "width = " + width);
		System.out.println(" height = " + height);
		
		Shape shape = new RoundRectangle2D.Double(x, y, width, height, arcWidth, arcHeight);
	//	g2.setPaint(Color.black);
	//	g2.fill(shape);
		g2.draw( shape);
		//Color.decode("#ffffff")
		g2.setPaint(Color.decode("#ffffff"));
		g2.fill(shape);
		
		// the width is 1/3 of the pixel size for full screen
		                                            
		
		// top gap is 7/80
		// height is 66/80
		
		// bottom gap is 7/80 
		
		// make it reactive to 1/4 of the screen size
		
		
		
		
//		//Text
//		g.drawString("This is my custom Panel!", 10, 20);
//		// color html code 788dee
//		g.setColor(Color.decode("#788dee"));
//		
//		Graphics2D g2 = (Graphics2D) g;
//		
//		g2.setRenderingHint(
//				RenderingHints.KEY_ANTIALIASING,
//				RenderingHints.VALUE_ANTIALIAS_ON
//				);
//		Dimension d = this.getSize();
//		triangle = new Triangle(d);
//		
//		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, triangle.getXPoints().length);
//		
//		polygon.moveTo( triangle.getXPoints()[0], triangle.getYPoints()[0]); // <- make starting point
//		polygon.lineTo( triangle.getXPoints()[1], triangle.getYPoints()[1]); // <- makes diagonal line /
//		polygon.lineTo( triangle.getXPoints()[2], triangle.getYPoints()[2]); // <- makes straight line down |
//		polygon.lineTo( triangle.getXPoints()[3], triangle.getYPoints()[3]); // <- closes the polygon
//		
//		polygon.closePath();
//		// left side bottom is first point for the first color 
//		// right side bottom is the last point for the 2nd color 538aec
//		GradientPaint blueToPurple = new GradientPaint(
//				(int) triangle.getXPoints()[0], (int)triangle.getYPoints()[0], Color.decode("#538aec"),
//				(int) triangle.getXPoints()[2], (int)triangle.getYPoints()[2], Color.decode("#a08cec")
//				);
//		g2.setPaint(blueToPurple);
//		g2.fill(polygon);
////		g2.draw(polygon);
		
		
	}//
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
