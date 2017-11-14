package com.JS.AlgorithmSimulator.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import com.JS.AlgorithmSimulator.MainMenu.MainMenu;

/*
 * Used Substance Look and Feel
 * substance Version - 4.3.jar
 * jped-If-substance Version - 2.0.jar
 */

public class AlgorithmSimulatorMain extends JFrame {
	private static final long serialVersionUID = 1L;

	private final String APPLICATION_TITLE = "Algorithm Simulator";
	
	private final Color BACKGROUND_COLOR = Color.WHITE;
	
	private final int MINIMUM_WINDOW_WIDTH = 1000;
	private final int MINUMUM_WINDOW_HEIGHT = 700;
	
	private JPanel mainPanel;
	
  public AlgorithmSimulatorMain() {
    super("Algorithm Simulator");
    
    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/projectIcon.png")));
    this.setTitle(APPLICATION_TITLE);
	this.setMinimumSize(new Dimension(MINIMUM_WINDOW_WIDTH, MINUMUM_WINDOW_HEIGHT));
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	initialize_All();
  }

  private void initialize_All() {
	  mainPanel = new JPanel();
	  mainPanel.setBackground(BACKGROUND_COLOR);
	  getContentPane().add(mainPanel);
	  mainPanel.setLayout(new BorderLayout());
		
	  new MainMenu(mainPanel);
}

public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(new SubstanceLookAndFeel());
    JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
    
    SwingUtilities.invokeLater(new Runnable() {
    	
    public void run() {
        new AlgorithmSimulatorMain().setVisible(true);
      }
    
    });
  }
}
