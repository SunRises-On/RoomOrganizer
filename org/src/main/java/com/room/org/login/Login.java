package com.room.org.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/****
 *  Workaround for JLayeredPane having null Layout(). Because
 *  it is null you have to manually setPreferredSize or 
 *  setBounds manually for sizing/placing JComponents.
 * 
 *  You can add a ComponentListener to the JLayeredPane, and
 *  attach it to the component you want to resize. Then on
 *  componentResized(ComponentEvent e) you can resize/ replace
 *  JComponent(s) to the desired Bounds.
 * 
 *  Layouts like FlowLayout treat the component like one layer.
 *  So the JLayeredPane has no layouts and stays that way. 
 * 
 * 
 * **/
public class Login  extends JLayeredPane implements ComponentListener{
	private Background background;
	private LoginPanel loginPanel;
	public Login() {
		
		this.setPreferredSize(new Dimension(400,400));
		//.setPreferredSize(new Dimension(400,400));
		this.addComponentListener(this);
		this.setVisible(true);
		this.setBackground(Color.orange);
		background = new Background();
		background.addComponentListener(this);
		
		background.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		background.setBounds(0, 0, this.getWidth(), this.getHeight());
		
		//background.setBounds(new Rectangle(new Point(0,0), background.getPreferredSize()));
		this.add(background, JLayeredPane.MODAL_LAYER);
		

		loginPanel = new LoginPanel();
		loginPanel.addComponentListener(this);
		loginPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		loginPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(loginPanel, JLayeredPane.POPUP_LAYER);
		//.setSize(100,200);
		
		
	}
	@Override
	public void componentResized(ComponentEvent e) {
		
		Insets insets = this.getInsets();
		int w = this.getWidth();// - insets.left - insets.right;
		int h = this.getHeight();// - insets.top - insets.bottom;
		
		background.setPreferredSize(new Dimension(w, h));
		background.setSize(w, h);
		background.setBounds(0, 0 , w , h);
		
		loginPanel.setPreferredSize(new Dimension(w, h));
		loginPanel.setSize(w, h);
		loginPanel.setBounds(0, 0, w, h);
	//	oval.setBounds(20,20,100,200);
		
	//	this.revalidate(); <- breaks it for some reason
		//this.revalidate();
		//this.repaint();
		this.revalidate();
		this.repaint();
		//this.add(background, JLayeredPane.DEFAULT_LAYER);
		//this.revalidate();
	//	background.setSize(w, h);
	//	this.repaint();
		System.out.println(this.getX() + " " + this.getY() + " " +this.getHeight() + " " +this.getWidth());
		System.out.println(loginPanel.getX() + " " + loginPanel.getY() + " " +loginPanel.getHeight() + " " +loginPanel.getWidth());
		System.out.println(background.getX() + " " + background.getY() + " " +background.getHeight() + " " +background.getWidth());

		
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