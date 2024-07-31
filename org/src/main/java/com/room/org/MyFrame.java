package com.room.org;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {
	private JButton enterButton;
	private JLabel headerLabel;
	GridBagConstraints c;
	// Layout manager: Object that determines side and position
	// of your component
	// 
	MyFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(400,400);
	//	this.setLayout(new BorderLayout());
		 
		JPanel panel = new JPanel( new GridBagLayout()); // 
		panel.setBackground(Color.yellow);
		
		c = new GridBagConstraints();
		
		/* Think of the frame like Excel
		 * gridx, works as the Row variable
		 * gridy, works as the Column variable
		 * gridx corresponds to 1,2,3
		 * gridy corresponds to A, B, C
		 * GridBagConstraints, you need it not only for gridx/gridy, but also for
		 * gridwidth and gridheight
		 * gridwidth & gridheight tells Java how many rows or columns the object occupies
		 * 
		 * */
		/*******************************************
		 *    0 1 2 3 4 5
		 *  0 t t t t t
		 *  1 l h h h r
		 *  2 l h h h r
		 *  3 b b b b b
		 * 
		 * *******/
		c.anchor = GridBagConstraints.CENTER;
		/***************
		 * If the space w/in a Pane is greater than the preferredDimension
		 * of the components contained w/in, the weightx and weighty is used to
		 * distribute the extra space to the individual components
		 * weightx is horizontal spacing
		 * weighty is vertical spacing
		 * You can use any number for weightx and weighty, but it is easier to read
		 * to use 0.0 - 1.0 like a percentage
		 * buttonA has weightx = .2
		 * buttonB has weighty = .8
		 * Button A will get 20% of the extra horizontal space
		 * Button B will get 80% of the extra horizontal space
		 * 
		 */
		c.weightx = 1;
		c.weighty = 1;
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 3;
		c.gridheight = 2;
		/* There's also the anchor function, is used to indicate where the object
		 * should start.
		 * 
		 * Anchor positioning
		 * FIRST_LINE_START....PAGE_START.... FIRST_LINE_END
		 * LINE_START......................CENTER..............LINE_END
		 * LAST_LINE_START........PAGE_END.......LAST_LINE_END
		 * */
		/***************************************************
		********** Center Panel **************************
		*****************************************************/
		//Create a new JPanel class and add it to BorderLayout Center
		JPanel panelCenter = new JPanel();
		setUpPanelCenter(panelCenter);
		
		setUpLabel("Room Database", panelCenter);
		
		
		setUpButton("Enter", panelCenter);
		
		addComponentsToPanelCenter( panelCenter);
		
		//add panelCenter to panel
		//it lies center of the container
		panel.add(panelCenter, c);
		
		JPanel top = new JPanel();
	//	top.setBackground(Color.black);
		c.gridx = 0;
		c.gridy= 0;
		c.gridwidth = 5;
		c.gridheight = 1;
		panel.add(top,c);
		
		JPanel bottom = new JPanel();
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 5;
		c.gridheight = 1;
	//	bottom.setBackground(Color.green);
		panel.add(bottom,c);
		
		JPanel left = new JPanel();
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 2;
	//	left.setBackground(Color.pink);
		panel.add(left, c);
		
		JPanel right = new JPanel();
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 2;
	//	right.setBackground(Color.magenta);
		panel.add(right, c);
		/****************************************************
		****************************************************/
	//	this.setBackground(Color.black);
		//this.add(panel, BorderLayout.CENTER);
		this.add(panel);
		//this.pack();
		
		
	}
	public void setUpPanelCenter(JPanel panel) {
	//	panel.setBackground(Color.cyan);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}
	public void setUpLabel(String text, JPanel panel) {
		headerLabel = new JLabel();
		headerLabel.setText(text);
		headerLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	public void setUpButton(String text, JPanel panel) {
		enterButton = new JButton();
		enterButton.setText(text);
		enterButton.setFont(new Font("Arial", Font.PLAIN, 20));
		enterButton.setFocusable(false);
		enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	}
	public void addComponentsToPanelCenter(JPanel panel) {
		panel.add(headerLabel);
		//Create an invisible Component Always a specific size
		panel.add(Box.createRigidArea(new Dimension(50,50)));
		panel.add(enterButton);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
