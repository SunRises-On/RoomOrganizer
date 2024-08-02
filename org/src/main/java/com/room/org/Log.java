package com.room.org;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Log extends JPanel implements ComponentListener{
	JLabel label ;
	Triangle triangle;

	Log(){
		this.addComponentListener(this);

		label = new JLabel();
		label.setText("Changed to another panel");
		this.add(label);
		
		Dimension d = this.getSize();
		triangle = new Triangle(d);
		setPoints(d);
		//use layers to add dimensions
		// but blur a button >-<
		

	}
	private void setPoints(Dimension d) {
		double height = d.getHeight();
		double width = d.getWidth();
		System.out.println("height = " + height);
		System.out.println("width = " + width);
		
		triangle = new Triangle(d);
		
		repaint();
		//how do I get every point I need for each x point ???
	}
	/*********************
	 *  Whenever a MouseEvent received, ti is forwarded
	 *  to the moveSquare method, which updates the square's 
	 *  coordinates and repaints the component in an intelligent
	 *  manner. Note that by default, any code that is placed
	 *  within these event handlers will be executed on the Event
	 *  Dispatch Thread.
	 *  
	 *  But the most important change is the invocation of the repaint 
	 *  method. This method is defined by java.awt.Component and is the 
	 *  mechanism that allows you to programmatically repaint the surface
	 *   of any given component. It has a no-arg version (which repaints 
	 *   the entire component) and a multi-arg version (which repaints 
	 *   only the specified area.) This area is also known as the clip.
	 *    Invoking the multi-arg version of repaint takes a little extra 
	 *    effort, but guarantees that your painting code will not waste
	 *     cycles repainting areas of the screen that have not changed.
	 *   
	 *   Because we are manually setting the clip, our moveSquare method 
	 *   invokes the repaint method not once, but twice. The first 
	 *   invocation tells Swing to repaint the area of the component 
	 *   where the square previously was (the inherited behavior uses the
	 *    UI Delegate to fill that area with the current background
	 *     color.) The second invocation paints the area of the component
	 *      where the square currently is. An important point worth
	 *       noting is that although we have invoked repaint twice in a 
	 *       row in the same event handler, Swing is smart enough to take
	 *        that information and repaint those sections of the screen
	 *         all in one single paint operation. In other words, 
	 *         Swing will not repaint the component twice in a row, even 
	 *         if that is what the code appears to be doing.
	 *   
	 *  
	 * */
//	private void moveSquare(int x, int y) {
//		int OFFSET = 1;
//		if ((squareX!=x) || (squareY != y)) {
//			repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
//			squareX=x;
//			squareY=y;
//			repaint(squareX,squareY,squareW+OFFSET,squareH+OFFSET);
//		}
//	}
	/**
	 *  paintComponent - method is where all your custom 
	 *  painting takes place. This method is defined by 
	 *  javax.swing.JComponent and then overridden by your 
	 *  subclasses to provide their custom behavior. 
	 *  
	 *  java.awt.Graphics object exposes a number of methods
	 *  for drawing 2D shapes and obtaining information
	 *  about the application's graphics environment.
	 *  
	 *  Most of the standard Swing components have their look and 
	 *  feel implemented by separate "UI Delegate" objects. The 
	 *  invocation of super.paintComponent(g) passes the graphics 
	 *  context off to the component's UI delegate, 
	 *  which paints the panel's background.
	 * 
	 * 
	 *  
	 *  
	 *  
	 *  **/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Text
		g.drawString("This is my custom Panel!", 10, 20);
		// color html code 788dee
		g.setColor(Color.decode("#788dee"));
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON
				);
		Dimension d = this.getSize();
		triangle = new Triangle(d);
		
		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, triangle.getXPoints().length);
		
		polygon.moveTo( triangle.getXPoints()[0], triangle.getYPoints()[0]); // <- make starting point
		polygon.lineTo( triangle.getXPoints()[1], triangle.getYPoints()[1]); // <- makes diagonal line /
		polygon.lineTo( triangle.getXPoints()[2], triangle.getYPoints()[2]); // <- makes straight line down |
		polygon.lineTo( triangle.getXPoints()[3], triangle.getYPoints()[3]); // <- closes the polygon
		
		polygon.closePath();
		g2.fill(polygon);
		g2.draw(polygon);
		
		
	}//
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		Dimension d = this.getSize();

		setPoints(d);
		
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
