package com.JS.AlgorithmSimulator.Button;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;

public class Button extends JButton implements MouseListener{

	private final int BUTTON_WIDTH = 350;
	private final int BUTTON_HEIGHT = 50;
	
	private final String FONT_NAME = "Calibiri";
	private final int FONT_SIZE = 40;
	
	public Button(String text) {
		super(text);
		setForeground(Color.BLACK);
		setBackground(new Color(0, 255, 255));
		setBorderPainted(true);
		setFocusPainted(false);
		setContentAreaFilled(true);
		setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
		setText(text);
		add(Box.createRigidArea(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT)));
		setAlignmentX(Component.CENTER_ALIGNMENT);
		
		addMouseListener(this);
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
		setBackground(Color.orange);
	}

	public void mouseExited(MouseEvent arg0) {
		setBackground(new Color(0, 255, 255));
	}

	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {
		setBackground(Color.ORANGE);
	}
}
