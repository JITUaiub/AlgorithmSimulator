package com.JS.AlgorithmSimulator.OthersMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.JS.AlgorithmSimulator.Button.Button;
import com.JS.AlgorithmSimulator.MainMenu.MainMenu;
import com.JS.AlgorithmSimulator.Searching.LinearSearch;

public class CatagoriesMenu extends JPanel {
	/// Main JList Items
    private final String[] LIST_DATA = {"Searching", "Sorting"};
    
    ///Secondary JList Items
    private final String[] LIST_SECONDARY_DATA_SORTING = {"Bubble Sort", "Selection Sort"};
    private final String[] LIST_SECONDARY_DATA_SEARCHING = {"Linear Search", "Binary Search"};
    
    
    private final int BORDER_THICKNESS_BORDERLAYOUT = 5;
    private final Font LIST_FONT = new Font("Calibiri", Font.BOLD, 25);
    private final Font LABEL_FONT = new Font("courier", Font.BOLD, 30);
    private final int LIST_VISIBLE_ROW_COUNT = 10;
    private final String TITLE_TEXT = "\"Catagories\"";
    private final String ERROR_TITLE = "ERROR !!!";
    private final String ERROR_LOG = "Please select both options from the list.";
    private final String OPEN_BUTTON = "Open Simulator";
    private final String BACK_BUTTON = "Back";
    
    private final Color LIST_BG = Color.WHITE;
    

    // JList field created with constant array data
    private JList<String> jList = new JList<>(LIST_DATA); 
    private JList<String> secondJList = new JList<>();
    
    ///JPanel Object
    private JPanel mainPanel;
    private JPanel listPanel = new JPanel();
    
    ///Buttons
    private Button btnBack;
    private Button btnOpenInBrowser;
    
    ///Labels
    private JLabel lblCatagories;

    public CatagoriesMenu(final JPanel mainPanel) {
    	this.mainPanel = mainPanel;
    	listPanel.setBackground(Color.WHITE);
    	setBackground(Color.WHITE);
    	setVisible(true);
    	
        initialize_All();
    }

	private void initialize_All() {
		
		jList.setFont(LIST_FONT);
        jList.setPrototypeCellValue("ABCDEFGHIJKLMNOP ABCDE");
        jList.setVisibleRowCount(LIST_VISIBLE_ROW_COUNT);
        jList.setBackground(LIST_BG);
        
        jList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				///Add Main JList Here
				if(jList.getSelectedValue().equals("Searching")){
					secondJList.setListData(LIST_SECONDARY_DATA_SEARCHING);
				}
				else if (jList.getSelectedValue().equals("Sorting")) {
					secondJList.setListData(LIST_SECONDARY_DATA_SORTING);
				}
			}
		});
        
        secondJList.setFont(LIST_FONT);
        secondJList.setPrototypeCellValue("ABCDEFGHIJKLMNOP ABCDE");
        secondJList.setVisibleRowCount(LIST_VISIBLE_ROW_COUNT);
        secondJList.setBackground(LIST_BG);
        
        

        lblCatagories = new JLabel(TITLE_TEXT, SwingConstants.CENTER);
        lblCatagories.setFont(LABEL_FONT);

        btnBack = new Button(BACK_BUTTON);
        btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				removeAll();
				new MainMenu(mainPanel);
			}
		});
        
        btnOpenInBrowser = new Button(OPEN_BUTTON);
        btnOpenInBrowser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (jList.isSelectionEmpty() | secondJList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, ERROR_LOG, ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					///Add Simulator Actions
					if(secondJList.getSelectedValue().equals("Linear Search")){
						setVisible(false);
						removeAll();
						
						mainPanel.add(new LinearSearch(mainPanel));
					}
						
				}
			}
		});

        setBorder(BorderFactory.createEmptyBorder(BORDER_THICKNESS_BORDERLAYOUT, BORDER_THICKNESS_BORDERLAYOUT, BORDER_THICKNESS_BORDERLAYOUT, BORDER_THICKNESS_BORDERLAYOUT));
        setLayout(new BorderLayout(BORDER_THICKNESS_BORDERLAYOUT, BORDER_THICKNESS_BORDERLAYOUT));
        add(lblCatagories, BorderLayout.PAGE_START);
        add(new JScrollPane(jList), BorderLayout.WEST);
        
        listPanel.setLayout(new BorderLayout(BORDER_THICKNESS_BORDERLAYOUT, BORDER_THICKNESS_BORDERLAYOUT));
        add(listPanel, BorderLayout.CENTER);
        listPanel.add(new JScrollPane(secondJList), BorderLayout.CENTER);
        listPanel.add(btnOpenInBrowser, BorderLayout.PAGE_END);
        add(btnBack, BorderLayout.PAGE_END);
	}

}
