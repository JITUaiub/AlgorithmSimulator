package com.JS.AlgorithmSimulator.MainMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.JS.AlgorithmSimulator.Button.Button;
import com.JS.AlgorithmSimulator.OthersMenu.CatagoriesMenu;
import com.JS.AlgorithmSimulator.OthersMenu.CreditsMenu;
import com.JS.AlgorithmSimulator.OthersMenu.ExternalsLinksMenu;

public class MainMenu extends JPanel{
	
	///Button Space
	private final int BUTTON_SPACE_X = 0;
	private final int BUTTON_SPACE_Y = 10;
	private final Color BACKGROUND_COLOR = Color.WHITE;
	
	private Button btnCategory = new Button("Category");
	private Button btnExternalLinks = new Button("External Links");
	private Button btnCredits = new Button("Credits");
	private Button btnExit = new Button("Exit");
	
	private JLabel lblApplicationIcon;
	
	private BufferedImage applicationImage;
	
	private JPanel mainPanel;
	private JPanel buttonPanel;
	
	private CreditsMenu creditMenu;
	private ExternalsLinksMenu externalsLinks;
	private CatagoriesMenu catagoriesMenu;
	
	public MainMenu(JPanel mainPanel) {
		this.mainPanel = mainPanel;
		buttonPanel = new JPanel();
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(BACKGROUND_COLOR);
		mainPanel.setVisible(true);
		
		try {
			applicationImage = ImageIO.read(new File("res/projectLogo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lblApplicationIcon = new JLabel(new ImageIcon(applicationImage));
		lblApplicationIcon.setVisible(true);
		mainPanel.add(lblApplicationIcon, BorderLayout.NORTH);
		
		buttonPanel.setVisible(true);
		
		initialize_All();
	}
	
	private void initialize_All() {
		
		buttonPanel.setBackground(BACKGROUND_COLOR);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.add(Box.createRigidArea(new Dimension(BUTTON_SPACE_X, BUTTON_SPACE_Y)));
		
		///Category Button
		buttonPanel.add(btnCategory);	
		btnCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				catagoriesMenu = new CatagoriesMenu(mainPanel);
				
				buttonPanel.setVisible(false);
				lblApplicationIcon.setVisible(false);
				
				mainPanel.add(catagoriesMenu);
			}
		});
		buttonPanel.add(Box.createRigidArea(new Dimension(BUTTON_SPACE_X, BUTTON_SPACE_Y)));
		
		///External Links Button		
		buttonPanel.add(btnExternalLinks);
		btnExternalLinks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				externalsLinks = new ExternalsLinksMenu(mainPanel);
				
				buttonPanel.setVisible(false);
				lblApplicationIcon.setVisible(false);
				
				mainPanel.add(externalsLinks);
			}
		});
		buttonPanel.add(Box.createRigidArea(new Dimension(BUTTON_SPACE_X, BUTTON_SPACE_Y)));
		
		///Credits Button
		buttonPanel.add(btnCredits);
		btnCredits.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditMenu = new CreditsMenu(mainPanel);
				
				buttonPanel.setVisible(false);
				lblApplicationIcon.setVisible(false);
				
				mainPanel.add(creditMenu);
				
			}
		});
		buttonPanel.add(Box.createRigidArea(new Dimension(BUTTON_SPACE_X, BUTTON_SPACE_Y)));
		
		///Exit Button
		buttonPanel.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
	}

}
