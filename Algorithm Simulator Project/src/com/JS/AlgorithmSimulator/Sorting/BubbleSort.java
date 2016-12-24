package com.JS.AlgorithmSimulator.Sorting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.JS.AlgorithmSimulator.Custom.Button;
import com.JS.AlgorithmSimulator.Custom.CustomTextField;
import com.JS.AlgorithmSimulator.OthersMenu.CatagoriesMenu;
import com.JS.AlgorithmSimulator.Custom.CustomJOptionPane;

public class BubbleSort extends JPanel {
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
	private JPanel sortingTypePanel;
	
	private JLabel lblTitle;
	private JLabel lblOrder;
	private JLabel lblTime;
	
	private Button btnBack;
	private Button btnStartSimulation;
	private Button btnStopSimulation;
	
	private CustomTextField txtInput1;
	private CustomTextField txtInput2;
	private CustomTextField txtInput3;
	private CustomTextField txtInput4;
	private CustomTextField txtInput5;
	private CustomTextField txtTime;
	
	private JRadioButton btnAscending;
	private JRadioButton btnDescending;
	private ButtonGroup radioButtonGroup;
	
	private BubbleSortSimulation bubbleSortSimulation;
	
	public BubbleSort(JPanel mainPanel) {
		this.mainPanel = mainPanel;	
		setBackground(BACKGROUND_COLOR);
		setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
		setLayout(new BorderLayout(BORDER_SIZE, BORDER_SIZE));
		
		bubbleSortSimulation = new BubbleSortSimulation(5);
		
		btnAscending = new JRadioButton("Ascending");
		btnAscending.setBackground(BACKGROUND_COLOR);
		btnAscending.setFocusPainted(false);
		btnAscending.setSelected(false);
		btnAscending.setSelected(true);
		
		btnDescending = new JRadioButton("Descending");
		btnDescending.setBackground(BACKGROUND_COLOR);
		btnDescending.setFocusPainted(false);
		btnDescending.setSelected(false);
		
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(btnAscending);
		radioButtonGroup.add(btnDescending);
		
		initialize_All();
	}

	private void initialize_All() {
		
		///Top Menu Label
		lblTitle = new JLabel("\"Bubble Sort\"", SwingConstants.CENTER);
		lblTitle.setFont(LABEL_FONT);
		lblOrder = new JLabel("Order: ", SwingConstants.CENTER);
		lblOrder.setFont(LABEL_FONT);
		
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
		
		sortingTypePanel = new JPanel();
		sortingTypePanel.setBackground(BACKGROUND_COLOR);
		sortingTypePanel.setLayout(new BoxLayout(sortingTypePanel, BoxLayout.Y_AXIS));
		sortingTypePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, BORDER_SIZE - 5));
		
		
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
		
		/// Input Panel - Buttons
		btnStartSimulation = new Button("Start");
		btnStopSimulation = new Button("Stop");
		
		///Draw Panel
		drawPanel = new JPanel();
		drawPanel.setLayout(new BorderLayout(BORDER_SIZE, BORDER_SIZE));
		drawPanel.setBackground(BACKGROUND_COLOR);
		drawPanel.setBorder(BorderFactory.createLineBorder(BACKGROUND_BORDER_COLOR, BORDER_SIZE));
		
		lblTime = new JLabel("Time (s):");
		lblTime.setFont(LABEL_FONT);
		
		txtTime = new CustomTextField("Iteration time");
		txtTime.setHorizontalAlignment(JTextField.CENTER);
		txtTime.setFont(INPUT_FONT);
		
		/// Input Panel - Button Listeners
		btnStartSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				{
					if (txtInput1.getText().equals("") || txtInput2.getText().equals("") || txtInput3.getText().equals("") || txtInput4.getText().equals("") || txtInput5.getText().equals("") || txtTime.getText().equals("")) {
						new CustomJOptionPane("Error !!!", "Please Enter all Inputs", "OK");
					}else {
						if(Integer.valueOf(txtTime.getText()) ==0){
							new CustomJOptionPane("Error !!!", "Minimum time should be 1 (one) second.", "OK");
						}else {
							if (!bubbleSortSimulation.getThreadState()) {
								bubbleSortSimulation.setTime(Integer.valueOf(txtTime.getText()));
								if (btnAscending.isSelected()) {
									bubbleSortSimulation.setOrder("Asc");
								}else {
									bubbleSortSimulation.setOrder("Dsc");
								}
								bubbleSortSimulation.setArrayValue(Integer.valueOf(txtInput1.getText()), Integer.valueOf(txtInput2.getText()), Integer.valueOf(txtInput3.getText()), Integer.valueOf(txtInput4.getText()), Integer.valueOf(txtInput5.getText()));
							}
							
							bubbleSortSimulation.start();
						}
					}
				}
			}
		});
		
		btnStopSimulation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bubbleSortSimulation.stop();
			}
		});
		
		/// Main Panel - Buttons Listeners
		btnBack = new Button("Back");
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bubbleSortSimulation.stop();
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
		
		/// Adding Button to text fields
		inputPanelBtn.add(btnStartSimulation);
		inputPanelBtn.add(btnStopSimulation);
		
		/// Adding Text Components
		sortingTypePanel.add(lblOrder);
		sortingTypePanel.add(btnAscending);
		sortingTypePanel.add(btnDescending);
		sortingTypePanel.add(lblTime);
		sortingTypePanel.add(txtTime);
		
		inputPanel.add(sortingTypePanel, BorderLayout.WEST);
		inputPanel.add(inputPanelTxt, BorderLayout.CENTER);
		inputPanel.add(inputPanelBtn, BorderLayout.EAST);

		drawPanel.add(bubbleSortSimulation, BorderLayout.CENTER); 
		
		/// Adding All visual to Center
		centerPanel.add(inputPanel, BorderLayout.PAGE_START);
		centerPanel.add(drawPanel, BorderLayout.CENTER);
		
		/// Adding all to main Screen
		add(lblTitle, BorderLayout.PAGE_START);
		add(centerPanel, BorderLayout.CENTER);
		add(btnBack, BorderLayout.PAGE_END);
	}
}
