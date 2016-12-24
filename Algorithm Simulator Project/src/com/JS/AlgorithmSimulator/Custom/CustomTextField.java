package com.JS.AlgorithmSimulator.Custom;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class CustomTextField extends JTextField implements KeyListener, FocusListener{
	private static final long serialVersionUID = 1L;
	private String hint = null;
	private boolean showingHint;
	
	public CustomTextField(String hint) {
		super(hint);
	    this.hint = hint;
	    this.showingHint = true;
	    super.addFocusListener(this);
		this.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent event) {
		char c = event.getKeyChar();
		
		if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c== KeyEvent.VK_DELETE)) {
			event.consume();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(this.getText().isEmpty()) {
	    super.setText("");
	    showingHint = false;
		}
	}
	@Override
	public void focusLost(FocusEvent e) {
	    if(this.getText().isEmpty()) {
	      super.setText(hint);
	      showingHint = true;
	    }
	}

	@Override
	public String getText() {
	    return showingHint ? "" : super.getText();
	}
}
