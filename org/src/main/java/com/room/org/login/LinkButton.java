package com.room.org.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

public class LinkButton extends JButton implements ActionListener{
	
	public LinkButton(String text) {
		
		this.setText(text);
		
		Font underlineFont = returnUnderlineFont();
		this.setFont(underlineFont);
		
		setUpLinkButton();
		
		this.addActionListener(e -> {
			System.out.println("clicked signup");
		});
		System.out.println("Created LinkButton");
	}
	/**
	 *  The Font class doesn't have a constant for turning on/off
	 *  underlining.
	 *  But the TextAttribute has an attribute you can turn on
	 *  for underlining. So what you can do is create a Map
	 *  containing TextAttribute and the integer value to use.
	 *  Then specify the font attributes. Then create a 
	 *  new Font().derviceFont(Map<TextAttribute, Integer>).
	 * 
	 * 
	 * */
	private Font returnUnderlineFont(){
		Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
		fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		Font font = new Font("Futura", Font.PLAIN, 14).deriveFont(fontAttributes);
		return font;
		
	}
	private void setUpLinkButton() {
		this.setContentAreaFilled(false);
		this.setHorizontalAlignment(LEFT);
		this.setBorderPainted(false);
		this.setOpaque(false);
		this.setFocusable(false);
		this.setForeground(Color.blue);
	}

}
