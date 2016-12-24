package com.JS.AlgorithmSimulator.Searching;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.JS.AlgorithmSimulator.Custom.Button;
import com.JS.AlgorithmSimulator.Custom.CustomJOptionPane;
import com.JS.AlgorithmSimulator.Custom.CustomTextField;
import com.JS.AlgorithmSimulator.OthersMenu.CatagoriesMenu;

public class BinarySearch extends JPanel {
	private static final long serialVersionUID = 1L;
	private final Font LABEL_FONT = new Font("courier", Font.BOLD, 30);
	private final Font INPUT_FONT = new Font("courier", Font.BOLD, 20);
	
	private final Color BACKGROUND_COLOR = Color.WHITE;
	private final Color BACKGROUND_BORDER_COLOR = Color.YELLOW;
	
	private final int BORDER_SIZE = 10;
	
	private JPanel mainPanel;
	private JPanel centerPanel;
	private JPanel inputPanel;
	private JPanel inputPanelTxt;
	private JPanel inputPanelBtn;
	private JPanel drawPanel;
	private JPanel timePanel;
	
	private JLabel lblTitle;
	private JLabel lblTime;
	
	private Button btnBack;
	
	/// Input Panel components
	private Button btnStartSimulation;
	private Button btnStopSimulation;
	
	private CustomTextField txtInput1;
	private CustomTextField txtInput2;
	private CustomTextField txtInput3;
	private CustomTextField txtInput4;
	private CustomTextField txtInput5;
	private CustomTextField txtTime;
	
	private JTextField txtSearch;
	
	/* 
	 * Declare Simulation Object here
	 */
	private BinarySearchSimulation binarySearchSimulation;
	
	public BinarySearch(JPanel mainPanel) {
		this.mainPanel = mainPanel;	
		setBackground(BACKGROUND_COLOR);
		setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
		setLayout(new BorderLayout(BORDER_SIZE, BORDER_SIZE));
		
		/*
		 * Initialize Simulation Object Here
		 */
		binarySearchSimulation = new BinarySearchSimulation(5);
		
		initialize_All();
	}

	private void initialize_All() {
		
		///Top Menu Label
		lblTitle = new JLabel("\"Binary Search\"", SwingConstants.CENTER);
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
		inputPanelTxt.setLayout(new BoxLayout(inputPanelTxt, BoxLayout.Y_AXIS));
		inputPanelTxt.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, BORDER_SIZE - 5));
		
		/// Input Panel - Button Area
		inputPanelBtn = new JPanel();
		inputPanelBtn.setBackground(BACKGROUND_COLOR);
		inputPanelBtn.setLayout(new BoxLayout(inputPanelBtn, BoxLayout.Y_AXIS));
		inputPanelBtn.setBorder(BorderFactory.createEmptyBorder(0, BORDER_SIZE - 5, 0, 0));
		
		/// Input Panel - Text Fields
		txtInput1 = new CustomTextField("Input 1");
		txtInput1.setHorizontalAlignment(JTextField.CENTER);
		txtInput1.setFont(INPUT_FONT);
		txtInput2 = new CustomTextField("Input 2");
		txtInput2.setHorizontalAlignment(JTextField.CENTER);
		txtInput2.setFont(INPUT_FONT);
		txtInput3 = new CustomTextField("Input 3");
		txtInput3.setHorizontalAlignment(JTextField.CENTER);
		txtInput3.setFont(INPUT_FONT);
		txtInput4 = new CustomTextField("Input 4");
		txtInput4.setHorizontalAlignment(JTextField.CENTER);
		txtInput4.setFont(INPUT_FONT);
		txtInput5 = new CustomTextField("Input 5");
		txtInput5.setHorizontalAlignment(JTextField.CENTER);
		txtInput5.setFont(INPUT_FONT);
		txtSearch = new CustomTextField("Search Value");
		txtSearch.setHorizontalAlignment(JTextField.CENTER);
		txtSearch.setFont(INPUT_FONT);
		txtSearch.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		
		/// Input Panel - Buttons
		btnStartSimulation = new Button("Start");
		btnStopSimulation = new Button("Stop");
		
		///Draw Panel
		drawPanel = new JPanel();
		drawPanel.setLayout(new BorderLayout(BORDER_SIZE, BORDER_SIZE));
		drawPanel.setBackground(BACKGROUND_COLOR);
		drawPanel.setBorder(BorderFactory.createLineBorder(BACKGROUND_BORDER_COLOR, BORDER_SIZE));
		
		timePanel = new JPanel();
		timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.Y_AXIS));
		timePanel.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
		timePanel.setBackground(BACKGROUND_COLOR);
		
		lblTime = new JLabel("Time (s): ");
		lblTime.setFont(LABEL_FONT);
		
		txtTime = new CustomTextField("Iteration time");
		txtTime.setFont(INPUT_FONT);
		txtTime.setHorizontalAlignment(JTextField.CENTER);
		
		/// Input Panel - Button Listeners
		btnStartSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				{
					if (txtInput1.getText().equals("") || txtInput2.getText().equals("") || txtInput3.getText().equals("") || txtInput4.getText().equals("") || txtInput5.getText().equals("") || txtSearch.getText().equals("") || txtTime.getText().equals("")) {
						new CustomJOptionPane("ERROR!!!", "Please fill all textbox.", "Ok");
					}else {
						if (Integer.valueOf(txtTime.getText()) == 0){
							new CustomJOptionPane("Error !!!", "Minimum time should be 1 (one) second.", "OK");
						}else {
							binarySearchSimulation.setTime(Integer.valueOf(txtTime.getText()));
							int n1 = Integer.valueOf(txtInput1.getText());
							int n2 = Integer.valueOf(txtInput2.getText());
							int n3 = Integer.valueOf(txtInput3.getText());
							int n4 = Integer.valueOf(txtInput4.getText());
							int n5 = Integer.valueOf(txtInput5.getText());
							
							if((n1>=n2 && n2>=n3 && n3>=n4 && n4>=n5) || (n1<=n2 && n2<=n3 && n3<=n4 && n4<=n5)){
								if(n1>=n2 && n2>=n3 && n3>=n4 && n4>=n5){
									binarySearchSimulation.setOrder("desc");
								}else {
									binarySearchSimulation.setOrder("asc");
								}
								
								if (!binarySearchSimulation.getThreadState()) {
									binarySearchSimulation.setArrayValue(Integer.valueOf(txtInput1.getText()), Integer.valueOf(txtInput2.getText()), Integer.valueOf(txtInput3.getText()), Integer.valueOf(txtInput4.getText()), Integer.valueOf(txtInput5.getText()), Integer.valueOf(txtSearch.getText()));
								}
								
								binarySearchSimulation.start();
							}else{
								new CustomJOptionPane("ERROR!!!", "Please enter values in ascending or descending order.", "Ok");
							}
						}
					}
				}
			}
		});
		
		btnStopSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				binarySearchSimulation.stop();	/// Simulation Stop
			}
		});
		
		/// Main Panel - Buttons Listeners
		btnBack = new Button("Back");
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				binarySearchSimulation.stop();
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
		inputPanelBtn.add(txtSearch);
		
		/// Adding Button to text fields
		inputPanelBtn.add(btnStartSimulation);
		inputPanelBtn.add(btnStopSimulation);
		
		timePanel.add(lblTime);
		timePanel.add(txtTime);
		
		/// Adding Text Components
		inputPanel.add(inputPanelTxt, BorderLayout.CENTER);
		inputPanel.add(inputPanelBtn, BorderLayout.EAST);
		inputPanel.add(timePanel,BorderLayout.WEST);
		
		///  Adding Visual Simulation to Main Screen
		/*
		 * Add Simulation Object Here
		 */
		drawPanel.add(binarySearchSimulation, BorderLayout.CENTER); 
		
		/// Adding All visual to Center
		centerPanel.add(inputPanel, BorderLayout.PAGE_START);
		centerPanel.add(drawPanel, BorderLayout.CENTER);
		
		/// Adding all to main Screen
		add(lblTitle, BorderLayout.PAGE_START);
		add(centerPanel, BorderLayout.CENTER);
		add(btnBack, BorderLayout.PAGE_END);
		
	}
}
