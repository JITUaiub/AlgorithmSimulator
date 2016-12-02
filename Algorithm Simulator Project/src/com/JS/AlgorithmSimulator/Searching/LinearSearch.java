package com.JS.AlgorithmSimulator.Searching;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.JS.AlgorithmSimulator.Button.Button;
import com.JS.AlgorithmSimulator.OthersMenu.CatagoriesMenu;

public class LinearSearch extends JPanel{
	
	private final Font LABEL_FONT = new Font("courier", Font.BOLD, 30);
	private final Font INPUT_FONT = new Font("courier", Font.BOLD, 25);
	
	private final Color BACKGROUND_COLOR = Color.WHITE;
	private final Color BACKGROUND_BORDER_COLOR = Color.YELLOW;
	
	private final int BORDER_SIZE = 10;
	
	private JPanel mainPanel;
	private JPanel centerPanel;
	private JPanel inputPanel;
	private JPanel inputPanelTxt;
	private JPanel inputPanelBtn;
	private JPanel drawPanel;
	
	private JLabel lblTitle;
	private Button btnBack;
	
	/// Input Panel components
	private Button btnStartSimulation;
	private Button btnStopSimulation;
	
	private JTextField txtInput1;
	private JTextField txtInput2;
	private JTextField txtInput3;
	private JTextField txtInput4;
	private JTextField txtInput5;
	
	private JTextField txtSearch;
	
	/* 
	 * Declare Simulation Object here
	 */
	private LinearSearchSimulation linearSearchSimulation;
	
	public LinearSearch(JPanel mainPanel) {
		this.mainPanel = mainPanel;	
		setBackground(BACKGROUND_COLOR);
		setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
		setLayout(new BorderLayout(BORDER_SIZE, BORDER_SIZE));
		
		/*
		 * Initialize Simulation Object Here
		 */
		linearSearchSimulation = new LinearSearchSimulation(5);
		
		initialize_All();
	}

	private void initialize_All() {
		
		///Top Menu Label
		lblTitle = new JLabel("\"Linear Search\"", SwingConstants.CENTER);
		lblTitle.setFont(LABEL_FONT);
		
		///Center Panel
		centerPanel = new JPanel();
		centerPanel.setBackground(BACKGROUND_COLOR);
		centerPanel.setLayout(new BorderLayout());
		
		///Input Panel
		inputPanel = new JPanel();
		inputPanel.setBackground(BACKGROUND_COLOR);
		inputPanel.setLayout(new BorderLayout(0, 0));
		
		
		/// Input Panel - Input Area
		inputPanelTxt = new JPanel();
		inputPanelTxt.setBackground(BACKGROUND_COLOR);
		inputPanelTxt.setLayout(new BoxLayout(inputPanelTxt, BoxLayout.X_AXIS));
		inputPanelTxt.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, BORDER_SIZE - 5));
		
		/// Input Panel - Button Area
		inputPanelBtn = new JPanel();
		inputPanelBtn.setBackground(BACKGROUND_COLOR);
		inputPanelBtn.setLayout(new BoxLayout(inputPanelBtn, BoxLayout.X_AXIS));
		inputPanelBtn.setBorder(BorderFactory.createEmptyBorder(0, BORDER_SIZE - 5, 0, 0));
		
		/// Input Panel - Text Fields
		txtInput1 = new JTextField();
		txtInput1.setHorizontalAlignment(JTextField.CENTER);
		txtInput1.setFont(INPUT_FONT);
		txtInput2 = new JTextField();
		txtInput2.setHorizontalAlignment(JTextField.CENTER);
		txtInput2.setFont(INPUT_FONT);
		txtInput3 = new JTextField();
		txtInput3.setHorizontalAlignment(JTextField.CENTER);
		txtInput3.setFont(INPUT_FONT);
		txtInput4 = new JTextField();
		txtInput4.setHorizontalAlignment(JTextField.CENTER);
		txtInput4.setFont(INPUT_FONT);
		txtInput5 = new JTextField();
		txtInput5.setHorizontalAlignment(JTextField.CENTER);
		txtInput5.setFont(INPUT_FONT);
		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(JTextField.CENTER);
		txtSearch.setFont(INPUT_FONT);
		
		/// Input Panel - Buttons
		btnStartSimulation = new Button("Start");
		btnStopSimulation = new Button("Stop");
		
		///Draw Panel
		drawPanel = new JPanel();
		drawPanel.setLayout(new BorderLayout(BORDER_SIZE, BORDER_SIZE));
		drawPanel.setBackground(BACKGROUND_COLOR);
		drawPanel.setBorder(BorderFactory.createLineBorder(BACKGROUND_BORDER_COLOR, BORDER_SIZE));
		
		/// Input Panel - Button Listeners
		btnStartSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				{
					if (txtInput1.getText().equals("") || txtInput2.getText().equals("") || txtInput3.getText().equals("") || txtInput4.getText().equals("") || txtInput5.getText().equals("") || txtSearch.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Enter all Inputs", "ERROR!!!" , JOptionPane.INFORMATION_MESSAGE);
					}else {
						if (!linearSearchSimulation.getThreadState()) {
							linearSearchSimulation.setArrayValue(Integer.valueOf(txtInput1.getText()), Integer.valueOf(txtInput2.getText()), Integer.valueOf(txtInput3.getText()), Integer.valueOf(txtInput4.getText()), Integer.valueOf(txtInput5.getText()), Integer.valueOf(txtSearch.getText()));
						}
						
						linearSearchSimulation.start();
					}
				}
			}
		});
		
		btnStopSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				linearSearchSimulation.show();
				linearSearchSimulation.stop();	/// Simulation Stop
			}
		});
		
		/// Main Panel - Buttons Listeners
		btnBack = new Button("Back");
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				removeAll();
				
				mainPanel.add(new CatagoriesMenu(mainPanel));
			}
		});
		
		/// Adding Text Fields
		inputPanelTxt.add(txtInput1);
		inputPanelTxt.add(txtInput2);
		inputPanelTxt.add(txtInput3);
		inputPanelTxt.add(txtInput4);
		inputPanelTxt.add(txtInput5);
		inputPanelTxt.add(txtSearch);
		
		/// Adding Button to text fields
		inputPanelBtn.add(btnStartSimulation);
		inputPanelBtn.add(btnStopSimulation);
		
		/// Adding Text Components
		inputPanel.add(inputPanelTxt, BorderLayout.CENTER);
		inputPanel.add(inputPanelBtn, BorderLayout.EAST);
		
		///  Adding Visual Simulation to Main Screen
		/*
		 * Add Simulation Object Here
		 */
		drawPanel.add(linearSearchSimulation, BorderLayout.CENTER); 
		
		/// Adding All visual to Center
		centerPanel.add(inputPanel, BorderLayout.PAGE_START);
		centerPanel.add(drawPanel, BorderLayout.CENTER);
		
		/// Adding all to main Screen
		add(lblTitle, BorderLayout.PAGE_START);
		add(centerPanel, BorderLayout.CENTER);
		add(btnBack, BorderLayout.PAGE_END);
		
	}
}
