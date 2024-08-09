package com.room.org.login;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
// TODO: stop resizing so as the roundedRectangle looks nice
// TODO: add insets and repaint different from wiindow size
public class LoginPanel extends JPanel implements ComponentListener{
	
	private RoundedRectangle roundedRectangle;
	private JPanel helperPanel;
	private JLabel label;
	private JButton button;
	private LinkButton link;
	public LoginPanel() {
		super();
		this.setOpaque(false);
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		helperPanel = new JPanel();
		helperPanel.setOpaque(false);
		helperPanel.setLayout(new BoxLayout(helperPanel, BoxLayout.PAGE_AXIS));
		//	miniPanel = new JPanel();
	//	miniPanel.setLayout(new BoxLayout(miniPanel, BoxLayout.PAGE_AXIS));//label
		
		// font = bold ... "Futura"
		// like 20
		label = new JLabel("Login");
		
		
//		label.setFont(new Font("Arial", Font.ITALIC,20)); //set font of text

		//text prompt
		//1
		
		
		//2
		
		//button
		button = new JButton("LOGIN");
		
		//link
		link = new LinkButton("Sign Up");
		
		helperPanel.add(label);
		
		helperPanel.add(button);
		helperPanel.add(link);
		this.add(helperPanel);
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
	//	System.out.println( "width = " + width);
	//	System.out.println(" height = " + height);
		
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
