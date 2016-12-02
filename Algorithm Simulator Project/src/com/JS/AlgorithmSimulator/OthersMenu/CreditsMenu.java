package com.JS.AlgorithmSimulator.OthersMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import com.JS.AlgorithmSimulator.Button.Button;
import com.JS.AlgorithmSimulator.MainMenu.MainMenu;

public class CreditsMenu extends JPanel{
	
	///Constants
	private final Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);
	
	private final Font LABEL_FONT = new Font("courier", Font.BOLD, 30);
	private final Font NAME_FONT = new Font("Calibiri", Font.BOLD, 20);
	private final Color BACKGROUND_COLOR = Color.WHITE;
	private final Color BORDER_COLOR = Color.BLACK;
	private final String DEVELOPER_NAME_1 = "MD. NASHID KAMAL";
	private final String DEVELOPER_NAME_2 = "MEHEDI HASAN SHUVO";
	private final String BACK_BUTTON_TEXT = "Back";
	private final String CREDITS_STRING = "\"Developers\"";
	
	private final String DEVELOPER2_MAIL_USERNAME = "hasanshuvom884@gmail.com";
	private final String DEVELOPER1_MAIL_USERNAME = "jitu.cse_aiub@outlook.com";
	private final String DEVELOPER2_LINKEDIN_USERNAME = "Mehedi Hasan Shuvo";
	private final String DEVELOPER1_LINKEDIN_USERNAME = "MdNashidKamal";
	private final String DEVELOPER2_STACKOVERFLOW_USERNAME = "RPM Shuvo ";
	private final String DEVELOPER1_STACKOVERFLOW_USERNAME = "Md. Nashid Kamal";
	private final String DEVELOPER2_GITHUB_USERNAME = "RPMShuvo";
	private final String DEVELOPER1_GITHUB_USERNAME = "JituAIUB";
	
	private final String DEVELOPER2_MAIL_ID = "hasanshuvom884@gmail.com";
	private final String DEVELOPER1_MAIL_ID = "jitu.cse_aiub@outlook.com";
	private final String DEVELOPER2_LINKEDIN_ID = "https://www.linkedin.com/in/rpmshuvo";
	private final String DEVELOPER1_LINKEDIN_ID = "https://www.linkedin.com/in/mdnashidkamal";
	private final String DEVELOPER2_STACKOVERFLOW_ID = "http://stackoverflow.com/users/7182997/rpm-shuvo?tab=profile";
	private final String DEVELOPER1_STACKOVERFLOW_ID = "http://stackoverflow.com/users/4926566/md-nashid-kamal?tab=profile";
	private final String DEVELOPER2_GITHUB_ID = "https://github.com/rpmshuvo";
	private final String DEVELOPER1_GITHUB_ID = "https://github.com/jituaiub";
	
	private final int BORDER_THICKNESS_BORDERLAYOUT = 5;
	private final int BORDER_THICKNESS_BOXLAYOUT = 50;
	private final int BORDER_SIZE = 3;
	private final int BUTTON_INTEND_X = 0;
	private final int BUTTON_INTEND_Y = 30;
	
	private final float SPILIT_PANE_RESIZE_WEIGHT = 0.5f;
	
	private JPanel mainPanel;
	private JPanel rightPanel = new JPanel();
	private JPanel leftPanel = new JPanel();
	private JPanel developer2Info;
	private JPanel developer1Info;
	
	private JLabel creditsLabel;
	private JLabel developerNameLabel1;
	private JLabel developerNameLabel2;
	private JLabel developer1Email;
	private JLabel developer1LinkedIn;
	private JLabel developer1StackOverFlow;
	private JLabel developer1GitHub;
	private JLabel developer2Email;
	private JLabel developer2LinkedIn;
	private JLabel developer2StackOverFlow;
	private JLabel developer2GitHub;
	
	private Button btnBack;
	
	private JSplitPane splitPane;
	
	private BufferedImage mailIcon;
	private BufferedImage linkedInIcon;
	private BufferedImage stackOverFlowIcon;
	private BufferedImage gitHubIcon;
	
	public CreditsMenu(JPanel mainPanel) {
		this.mainPanel = mainPanel;
		rightPanel.setBackground(BACKGROUND_COLOR);
		leftPanel.setBackground(BACKGROUND_COLOR);
		
		setBackground(BACKGROUND_COLOR);
		
		load_Icon_Images();
		initialize_All();
	}

	private void load_Icon_Images() {
		
		try {
			mailIcon = ImageIO.read(new File("res/mailIcon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			linkedInIcon = ImageIO.read(new File("res/linkedInIcon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			stackOverFlowIcon = ImageIO.read(new File("res/stackOverFlowIcon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			gitHubIcon = ImageIO.read(new File("res/gitHubIcon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initialize_All() {
		developerNameLabel1 = new JLabel(DEVELOPER_NAME_1, SwingConstants.CENTER);
		developerNameLabel1.setFont(NAME_FONT);
		developerNameLabel2 = new JLabel(DEVELOPER_NAME_2, SwingConstants.CENTER);
		developerNameLabel2.setFont(NAME_FONT);
		
		creditsLabel = new JLabel(CREDITS_STRING, SwingConstants.CENTER);
		creditsLabel.setFont(LABEL_FONT);
		
		btnBack = new Button(BACK_BUTTON_TEXT);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				removeAll();
				new MainMenu(mainPanel);
			}
		});
		
		setBorder(BorderFactory.createEmptyBorder(BORDER_THICKNESS_BORDERLAYOUT, BORDER_THICKNESS_BORDERLAYOUT, BORDER_THICKNESS_BORDERLAYOUT, BORDER_THICKNESS_BORDERLAYOUT));
		setLayout(new BorderLayout(BORDER_THICKNESS_BORDERLAYOUT, BORDER_THICKNESS_BORDERLAYOUT));
		
		rightPanel.setLayout(new BorderLayout());
		rightPanel.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, BORDER_SIZE));
		rightPanel.add(developerNameLabel2, BorderLayout.PAGE_START);
		
		initialize_Labels();
		
		developer2Info = new JPanel();
		developer2Info.setLayout(new BoxLayout(developer2Info, BoxLayout.Y_AXIS));
		developer2Info.setBorder(BorderFactory.createEmptyBorder(BORDER_THICKNESS_BOXLAYOUT, BORDER_THICKNESS_BOXLAYOUT, BORDER_THICKNESS_BOXLAYOUT, BORDER_THICKNESS_BOXLAYOUT));
		developer2Info.setBackground(BACKGROUND_COLOR);
		rightPanel.add(developer2Info, BorderLayout.CENTER);
		developer2Info.add(developer2Email);
		developer2Info.add(Box.createRigidArea(new Dimension(BUTTON_INTEND_X, BUTTON_INTEND_Y)));
		developer2Info.add(developer2LinkedIn);
		developer2Info.add(Box.createRigidArea(new Dimension(BUTTON_INTEND_X, BUTTON_INTEND_Y)));
		developer2Info.add(developer2StackOverFlow);
		developer2Info.add(Box.createRigidArea(new Dimension(BUTTON_INTEND_X, BUTTON_INTEND_Y)));
		developer2Info.add(developer2GitHub);
		
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, BORDER_SIZE));
		leftPanel.add(developerNameLabel1, BorderLayout.PAGE_START);
		
		developer1Info = new JPanel();
		developer1Info.setLayout(new BoxLayout(developer1Info, BoxLayout.Y_AXIS));
		developer1Info.setBorder(BorderFactory.createEmptyBorder(BORDER_THICKNESS_BOXLAYOUT, BORDER_THICKNESS_BOXLAYOUT, BORDER_THICKNESS_BOXLAYOUT, BORDER_THICKNESS_BOXLAYOUT));
		developer1Info.setBackground(BACKGROUND_COLOR);
		leftPanel.add(developer1Info, BorderLayout.CENTER);
		developer1Info.add(developer1Email);
		developer1Info.add(Box.createRigidArea(new Dimension(BUTTON_INTEND_X, BUTTON_INTEND_Y)));
		developer1Info.add(developer1LinkedIn);
		developer1Info.add(Box.createRigidArea(new Dimension(BUTTON_INTEND_X, BUTTON_INTEND_Y)));
		developer1Info.add(developer1StackOverFlow);
		developer1Info.add(Box.createRigidArea(new Dimension(BUTTON_INTEND_X, BUTTON_INTEND_Y)));
		developer1Info.add(developer1GitHub);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		splitPane.setResizeWeight(SPILIT_PANE_RESIZE_WEIGHT);
		splitPane.setEnabled(false);
		
		add(splitPane, BorderLayout.CENTER);
		add(creditsLabel, BorderLayout.PAGE_START);
		add(btnBack, BorderLayout.PAGE_END);
		
	}

	private void initialize_Labels() {
		developer1Email = new JLabel(DEVELOPER1_MAIL_USERNAME, new ImageIcon(mailIcon), SwingConstants.LEFT);
		developer1Email.setCursor(HAND_CURSOR);
		sendMail(developer1Email, DEVELOPER1_MAIL_ID);
		developer1LinkedIn = new JLabel(DEVELOPER1_LINKEDIN_USERNAME, new ImageIcon(linkedInIcon), SwingConstants.LEFT);
		developer1LinkedIn.setCursor(HAND_CURSOR);
		goWebsite(developer1LinkedIn, DEVELOPER1_LINKEDIN_ID);
		developer1StackOverFlow = new JLabel(DEVELOPER1_STACKOVERFLOW_USERNAME, new ImageIcon(stackOverFlowIcon), SwingConstants.LEFT);
		developer1StackOverFlow.setCursor(HAND_CURSOR);
		goWebsite(developer1StackOverFlow, DEVELOPER1_STACKOVERFLOW_ID);
		developer1GitHub = new JLabel(DEVELOPER1_GITHUB_USERNAME, new ImageIcon(gitHubIcon), SwingConstants.LEFT);
		developer1GitHub.setCursor(HAND_CURSOR);
		goWebsite(developer1GitHub, DEVELOPER1_GITHUB_ID);
		
		
		developer2Email = new JLabel(DEVELOPER2_MAIL_USERNAME, new ImageIcon(mailIcon), SwingConstants.LEFT);
		developer2Email.setCursor(HAND_CURSOR);
		sendMail(developer2Email, DEVELOPER2_MAIL_ID);	
		developer2LinkedIn = new JLabel(DEVELOPER2_LINKEDIN_USERNAME, new ImageIcon(linkedInIcon), SwingConstants.LEFT);
		developer2LinkedIn.setCursor(HAND_CURSOR);
		goWebsite(developer2LinkedIn, DEVELOPER2_LINKEDIN_ID);
		developer2StackOverFlow = new JLabel(DEVELOPER2_STACKOVERFLOW_USERNAME, new ImageIcon(stackOverFlowIcon), SwingConstants.LEFT);
		developer2StackOverFlow.setCursor(HAND_CURSOR);
		goWebsite(developer2StackOverFlow, DEVELOPER2_STACKOVERFLOW_ID);
		developer2GitHub = new JLabel(DEVELOPER2_GITHUB_USERNAME, new ImageIcon(gitHubIcon), SwingConstants.LEFT);
		developer2GitHub.setCursor(HAND_CURSOR);
		goWebsite(developer2GitHub, DEVELOPER2_GITHUB_ID);
		
	}
	
	private void goWebsite(JLabel website, final String url) {
        website.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (URISyntaxException | IOException ex) {
                    //It looks like there's a problem
                }
            }
        });
    }
	
	private void sendMail(JLabel contact, final String mailID) {
        contact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().mail(new URI("mailto:" + mailID));
                } catch (URISyntaxException | IOException ex) {
                    //It looks like there's a problem
                }
            }
        });
	}
}
