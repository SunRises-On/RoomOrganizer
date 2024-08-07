package com.room.org;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.room.org.login.Background;
import com.room.org.login.Login;

public class MyFrame extends JFrame implements ActionListener, ComponentListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton enterButton;
	private JLabel headerLabel;
	private GridBagConstraints c;
	private GridBagConstraints c2;
	// Layout manager: Object that determines side and position
	// of your component
	// 
	MyFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(400,400);
		this.addComponentListener(this);
	//	this.setLayout(new BorderLayout());
		 
		JPanel mainPanel = new JPanel( new GridBagLayout()); // 
		mainPanel.setBackground(Color.yellow);
		
		c = new GridBagConstraints();
		
		setUpGridBagLayoutOne(c);
		
		/***************************************************
		********** Main Panel **************************
		*****************************************************/
		//Create a new JPanel class and add it to BorderLayout Center
		JPanel centerPanel = new JPanel();
		c2 = new GridBagConstraints();
		setUpCenterPanel(centerPanel);
		setUpGridBagLayoutOne(c2);
		
		//set up components to Center Panel
		setUpLabel("Room Database");
		setUpButton("Enter");
		
		addComponentsToCenterPanel( centerPanel, c2);
		addSubPanelsToMainPanel(mainPanel, centerPanel);
		
		
		/****************************************************
		****************************************************/
		this.setBackground(Color.black);
		//this.add(panel, BorderLayout.CENTER);
		this.add(mainPanel);
		//this.pack();
		
		
	}
	public void setUpCenterPanel(JPanel centerPanel) {
	//	centerPanel.setBackground(Color.cyan);
		centerPanel.setLayout(new GridBagLayout());
		//centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
	}
	public void setUpLabel(String text) {
		headerLabel = new JLabel();
		headerLabel.setText(text);
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//headerLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//headerLabel.setBackground(Color.decode("#ffffc4"));
		headerLabel.setOpaque(true);
	}
	public void setUpButton(String text) {
		enterButton = new JButton();
		enterButton.setText(text);
		enterButton.setForeground(Color.white); //change text color
		//enterButton.setFont(new Font("Arial", Font.PLAIN, 20));
		enterButton.setFocusable(false);
		enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		//enterButton.setBackground(Color.ORANGE);
		enterButton.setBackground(new Color(92, 184, 92));
		enterButton.addActionListener(this);
		//enterButton.setBackground(Color.decode("#00cd00"));
		
		
	}
	/***************************
	 *   0 1 2 3 4
	 * 0 h h h h h
	 * 1 h h h h h
	 * 2 - - - - -
	 * 3 - b b b -
	 * 4 - - - - -
	 * ************************/
	/**
	 *  TODO : I
	 * 
	 * **/
	public void addComponentsToCenterPanel(JPanel centerPanel, GridBagConstraints c2) {
		
		c2.weightx = 1; // 
		c2.weighty = .4; // 4/10
		c2.gridx = 0;
		c2.gridy = 0;
		c2.gridwidth = 5;
		c2.gridheight = 2;	
		centerPanel.add(headerLabel,c2);
		//Create an invisible Component Always a specific size
		//Box.createRigidArea(new Dimension(50,50))
		
		// space one above the button
		c2.weightx = .2; //  
		c2.weighty = .2; // 2/10
		c2.gridx = 0;
		c2.gridy = 2;
		c2.gridwidth = 5;
		c2.gridheight = 1;
		centerPanel.add(Box.createRigidArea(new Dimension(10,10)), c2);
		c2.weightx = .3; //  6/10
		c2.weighty = .1; // 2/10
		c2.gridx = 1;
		c2.gridy = 3;
		c2.gridwidth = 3;
		c2.gridheight = 1;
		centerPanel.add(enterButton,c2);
		//space two under the button
		c2.weightx = .2; // 2/10
		c2.weighty = .2; // 2/10  
		c2.gridx = 0;
		c2.gridy = 4;
		c2.gridwidth = 5;
		c2.gridheight = 1;
		centerPanel.add(Box.createRigidArea(new Dimension(10,10)), c2);
		//space three to the left side
		c2.weightx = .2; // 2/10
		c2.weighty = .2; // 2/10
		c2.gridx = 0;
		c2.gridy = 3;
		c2.gridwidth = 1;
		c2.gridheight = 1;
		centerPanel.add(Box.createRigidArea(new Dimension(10,10)), c2);
		//space four to the right side
		c2.weightx = .2; // 2/10
		c2.weighty = .2; // 2/10
		c2.gridx = 4;
		c2.gridy = 3;
		c2.gridwidth = 1;
		c2.gridheight = 1;
		centerPanel.add(Box.createRigidArea(new Dimension(10,10)), c2);
		
		
	}
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
	 *****************************************************************************/
	/* There's also the anchor function, is used to indicate where the object
	 * should start.
	 * 
	 * Anchor positioning
	 * FIRST_LINE_START....PAGE_START.... FIRST_LINE_END
	 * LINE_START......................CENTER..............LINE_END
	 * LAST_LINE_START........PAGE_END.......LAST_LINE_END
	 * */
	/*****************
	 *    0 1 2 3 4  *
	 *  0 t t t t t  * 
	 *  1 l h h h r  *
	 *  2 l h h h r  *
	 *  3 b b b b b  *
	 * ***************/
	public void setUpGridBagLayoutOne(GridBagConstraints c) {
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
	}
	public void setUpGridBagLayoutTwo(GridBagConstraints c2){
		c2.anchor = GridBagConstraints.CENTER;
		
	}
	public void addSubPanelsToMainPanel(JPanel mainPanel, JPanel centerPanel) {
		// GridBagConstraints for Main Panel
		c.weightx = .5; // 6/10 = .6    l h h h r
		c.weighty = .5; // 1/2
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 3;
		c.gridheight = 2;
		//add centerPanel to mainPanel it lies center of the container
		mainPanel.add(centerPanel, c);
		//add top panel to mainPanel it lies at the top of the container
		JPanel top = new JPanel();
		//top.setBackground(Color.black);
		c.weightx = 1;
		c.weighty = .25; // 1/4 
		c.gridx = 0;
		c.gridy= 0;
		c.gridwidth = 5;
		c.gridheight = 1;
		mainPanel.add(top,c);
		//add bottom panel to mainPanel it lies at the bottom of the container
		JPanel bottom = new JPanel();
		c.weightx = 1;
		c.weighty = .25; // 1/4
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 5;
		c.gridheight = 1;
		//bottom.setBackground(Color.green);
		mainPanel.add(bottom,c);
		//add left panel to mainPanel it lies at the left side of the container
		JPanel left = new JPanel();
		c.weightx = .2 ;// 2/10 = .2    l h h h r
		c.weighty = .5; // 2/4
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 2;
		//left.setBackground(Color.pink);
		mainPanel.add(left, c);
		// add right panel to mainPanel it lies at the right side of the container
		JPanel right = new JPanel();
		c.weightx = .2 ; //2/10 = .2   l h h h r
		c.weighty = .5 ; // 2/4
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 2;
		//right.setBackground(Color.magenta);
		mainPanel.add(right, c);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource() == enterButton) {
			System.out.println("hello");
		}
		if( e.getSource()==enterButton) {
			//
			System.out.println("clicked");
			//Log log = new Log();
			//login.setParentJFrame(this.);
			
			//this.setContentPane(log);
			
			Login login = new Login();
			this.setLayout(new FlowLayout());
			this.setContentPane(login);
			
			this.revalidate();
		}
		
	}
/**
 *  When frame is resized
 * 
 * 
 * 
 * */
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		int width = this.getWidth();
		headerLabel.setFont(new Font("Arial", Font.PLAIN, width/15));
		enterButton.setFont(new Font("Arial", Font.PLAIN, width/25));
		this.getContentPane().revalidate();
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
