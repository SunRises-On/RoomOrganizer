package com.room.org.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RoundButton extends JPanel implements MouseListener{
	private double roundButtonWidth;
	private double roundButtonHeight;
	private double startingPointX = 1;
	private double startingPointY = 1;
	private final double arcWidth = 50;	// arcWidth = the width to set the arc of this RoundRectangle2D
	private final double arcHeight = 50;// archHeight = the height to which to set the arc of this RoundRectangle
	
	public RoundButton(){
		super();
		this.setOpaque(false);
		System.out.println("I'm in Round Button.");
		
		//this.setSize(400, 400); //width x height
		this.setPreferredSize(new Dimension(162,52));
		this.setMinimumSize(new Dimension(162,52));
		this.setMaximumSize(new Dimension(162,52));
		
		this.roundButtonWidth = 160.0;
		this.roundButtonHeight = 50.0;
		//this.setSize(150,100);
		this.addMouseListener(this);
		// b68ded
	//	this.setFocusable(false);
	//	this.setFont(new Font("Futura", Font.PLAIN, 12));
	//	this.setForeground(Color.white);
	//	this.setBackground( Color.decode("#b68ded"));
	//	this.setText("LOGIN");
	//	this.setBackground(Color.decode("#b68ded"));
		System.out.println("Round Button is created");
	}
	/**
	 * This method centers a String into a bounding 
	 * Rectangle shape. The Rectangle shape is then used
	 * to draw the String in the middle of the JPanel.
	 * 
	 * How it centers it is that we have the rectangle for 
	 * the JPanel we divide the width by 2. The we divide
	 * the framing rectangle by 2. Then we subtract the
	 * the former from the later and subtract the 
	 * framing triangles starting x. What we get is 
	 * (the leftover width) is The starting x point 
	 * for the String so that it would be center.We 
	 * do the same for the y-axis and height. 
	 * 
	 * @param g2 - The Graphics instance.
	 * @param s  - The String in which we need to center 
	 * @param font - The display font of the String.
	 * 
	 * */
	public void centerString(Graphics2D g2, String s,
			Font font) {
		FontRenderContext frc = 
				new FontRenderContext(null, true, true);
		Rectangle2D r2D = font.getStringBounds(s, frc);
		int rWidth = (int) Math.round(r2D.getWidth());
		int rHeight = (int) Math.round(r2D.getHeight());
		int rX = (int) Math.round(r2D.getX());
		int rY = (int) Math.round(r2D.getY());
		
		// Get the round button width and divide by 2
		int a = ( (int)this.roundButtonWidth / 2) -
		// Divide the width needed for the text by 2
		// subtract starting framing rectangle x point
				(rWidth / 2) - rX;
		int b = ( ( (int) this.roundButtonHeight ) / 2) -
				(rHeight / 2) - rY;
		
		
		
		g2.setFont(font);
		g2.drawString(s,
				(int)this.getStartingPointX()+ a,
				(int)this.getStartingPointY() + b);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON
				);
		//Color c = Color.BLACK;
	//	g2.setPaint(c);
		Shape shape = new RoundRectangle2D.Double(
				this.getStartingPointX(), 
				this.getStartingPointY(), 
				this.getRoundButtonWidth(),
				this.getRoundButtonHeight(), 
				this.getArcWidth(), 
				this.getArcHeight());
		//g2.draw(shape);
		g2.setPaint(Color.decode("#b68ded"));
		g2.fill(shape);
		//Write text
		Color c = Color.white;
		g2.setPaint(c);
		Font font = new Font("Futura", Font.BOLD, 16);
		//g2.setFont(font);
		String s = "LOGIN";
		centerString(g2, s, font);
	//	g2.drawString("LOGIN", 100, 50);
	}

	public double getRoundButtonWidth() {
		return roundButtonWidth;
	}

	public void setRoundButtonWidth(double width) {
		this.roundButtonWidth = width;
	}

	public double getRoundButtonHeight() {
		return roundButtonHeight;
	}

	public void setRoundButtonHeight(double height) {
		this.roundButtonHeight = height;
	}

	public double getStartingPointX() {
		return startingPointX;
	}

	public void setStartingPointX(double startingPointX) {
		this.startingPointX = startingPointX;
	}

	public double getStartingPointY() {
		return startingPointY;
	}

	public void setStartingPointY(double startingPointY) {
		this.startingPointY = startingPointY;
	}

	public double getArcWidth() {
		return arcWidth;
	}

	public double getArcHeight() {
		return arcHeight;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Clicked Login Button");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
