package com.room.org.login;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

public class LinkButton extends JButton{
	
	public LinkButton(String text) {
		this.setText(text);
//		label.setFont(new Font("Arial", Font.ITALIC,20)); //set font of text
		
	//	this.setFont(new Font("Arial", Font.PLAIN, 12));
		
			
		Font underlineFont = returnUnderlineFont();
		this.setFont(underlineFont);
		
		
		//attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		//System.out.println(attributes);
		/****
		 * Prints out
		 * map of {family="Futura", weight=1.0*, width=1.0*, posture=0.0*, size=12.0*, transform=null*, superscript=0*, tracking=0.0*[btx=null, ctx=null]}

		 * 
		 * 
		 * *********/
		//attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON );
		this.setHorizontalAlignment(LEFT);
		this.setBorderPainted(false);
		this.setOpaque(false);
		this.setFocusable(false);
	}
	/***********
	 *  The Font class doesn't have a constant for turning on/off
	 *  underlining.
	 *  But the TextAttribute has an attribute you can turn on
	 *  for underlining. So what you can do is create a Map
	 *  containing TextAttribute and the integer value to use.
	 *  Then specify the font attributes. Then create a 
	 *  new Font().derviceFont(Map<TextAttribute, Integer>).
	 * 
	 * 
	 * *****************/
	private Font returnUnderlineFont(){
		Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
		fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		Font font = new Font("Futura", Font.PLAIN, 12).deriveFont(fontAttributes);
		return font;
		
	}

}
