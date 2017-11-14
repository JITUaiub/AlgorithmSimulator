package com.JS.AlgorithmSimulator.Custom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;

public class Button extends JButton{
	private static final long serialVersionUID = 1L;
	
	private final int BUTTON_WIDTH = 350;
	private final int BUTTON_HEIGHT = 50;
	
	private final Color BUTTON_BACKGROUND = new Color(0, 255, 255);
	
	private final Font BUTTON_FONT = new Font("Calibiri", Font.PLAIN, 30);
	
	public Button(String text) {
		super(text);
		setForeground(Color.BLACK);
		setBackground(BUTTON_BACKGROUND);
		setBorderPainted(true);
		setFocusPainted(false);
		setContentAreaFilled(true);
		setFont(BUTTON_FONT);
		setText(text);
		add(Box.createRigidArea(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT)));
		setAlignmentX(Component.CENTER_ALIGNMENT);
	}
}
