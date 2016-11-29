package com.JS.AlgorithmSimulator.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.JS.AlgorithmSimulator.MainMenu.MainMenu;

public class AlgorithmSimulatorMain extends JFrame {

	
	private final String APPLICATION_TITLE = "Algorithm Simulator";
	
	private final Color BACKGROUND_COLOR = Color.WHITE;
	
	private final int MINIMUM_WINDOW_WIDTH = 730;
	private final int MINUMUM_WINDOW_HEIGHT = 600;
	
	private JPanel mainPanel;
	
	///Constructors
	public AlgorithmSimulatorMain(){
		setResizable(false);
		setTitle(APPLICATION_TITLE);
		setMinimumSize(new Dimension(MINIMUM_WINDOW_WIDTH, MINUMUM_WINDOW_HEIGHT));
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initialize_All();
	}
	
	/// Initialize method to initialize all components to JFrame
	private void initialize_All() {
		mainPanel = new JPanel();
		mainPanel.setBackground(BACKGROUND_COLOR);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		
		new MainMenu(mainPanel);
	}
	
	
	@Override
	public void setVisible(boolean arg){
		super.setVisible(arg);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					AlgorithmSimulatorMain window = new AlgorithmSimulatorMain();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
