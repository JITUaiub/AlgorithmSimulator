package com.JS.AlgorithmSimulator.Custom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class CustomJOptionPane {
	
	private final JFrame FRAME = new JFrame();
    private JOptionPane optionPane = new JOptionPane();
    private JDialog dialog;
    
    private String title;
    private String messageText;
    private String buttonText;
    
    public CustomJOptionPane(String title, String message, String buttonText) {
    	
    	this.setTitle(title);
    	this.setMessage(messageText);
    	this.setButtonText(buttonText);
    	
    	optionPane.setMessage(message);
    	optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
    
    	JButton btnOk = new JButton(buttonText);
    	btnOk.setFocusPainted(false);
    	btnOk.addActionListener(new ActionListener() {
    		@Override
			public void actionPerformed(ActionEvent arg0) {
			FRAME.dispose();
    		}	
    	});
    
    optionPane.setOptions(new Object[] { btnOk });
    dialog = optionPane.createDialog(FRAME, title);
    dialog.setVisible(true);
    
   }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return messageText;
	}

	public void setMessage(String messageText) {
		this.messageText = messageText;
	}

	public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}
}
