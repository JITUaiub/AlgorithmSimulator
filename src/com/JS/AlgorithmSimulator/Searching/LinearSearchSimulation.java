package com.JS.AlgorithmSimulator.Searching;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.JS.AlgorithmSimulator.Custom.CustomJOptionPane;

public class LinearSearchSimulation extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	private int searchVal = 0;
	private final Font DRAW_FONT = new Font("calibiri", Font.BOLD, 25);
	
	///Variables For Draw
	private int [] array;
	private String [] arrayString;
	private final int BOX_SIZE = 100;
	
	private final Color CURRENT_COLOR = Color.YELLOW;
	private final Color ACTIVE_COLOR = Color.RED;
	
	private int node = 0;
	private int count = 0;
	private int searchCount = 0;
	private int time = 1;
	
	private Thread thread;
	private boolean threadFlag = false;
	private boolean searchFlag = false;
	
	    public LinearSearchSimulation(int inputSize){
	    	array = new int [inputSize+1];
	    	arrayString = new String [inputSize];
	    	
	    	for(int i=0; i<array.length; i++){
	    		array[i] = 0;
	    	}
	    	
	    	for (int i = 0; i < arrayString.length; i++) {
				arrayString[i] = "0";
			}
	    	
	    	setBackground(Color.WHITE);
	    	
	    }
	    
	    
	    @Override
	    public void paintComponent(Graphics g) {
	    	super.paintComponent(g);

	    	g.setFont(DRAW_FONT);
	    	
	    	if(node == 1)
	    		g.setColor(ACTIVE_COLOR);
	    	else {
				g.setColor(CURRENT_COLOR);
			}
	    	g.fillRect(1*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[0], (1*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(node == 2)
	    		g.setColor(ACTIVE_COLOR);
	    	else {
				g.setColor(CURRENT_COLOR);
			}
	    	g.fillRect(2*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[1], (2*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(node == 3)
	    		g.setColor(ACTIVE_COLOR);
	    	else {
				g.setColor(CURRENT_COLOR);
			}
	    	g.fillRect(3*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[2], (3*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(node == 4)
	    		g.setColor(ACTIVE_COLOR);
	    	else {
				g.setColor(CURRENT_COLOR);
			}
	    	g.fillRect(4*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[3], (4*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(node == 5)
	    		g.setColor(ACTIVE_COLOR);
	    	else {
				g.setColor(CURRENT_COLOR);
			}
	    	g.fillRect(5*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[4], (5*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	
	    	g.drawString("Search Value: " + searchVal, (3*getWidth()/5-220), (getHeight()/2)+110);
	    	
	    	g.dispose();
	    }
	    
	    public void update() {	
	    	
	    	if(count == 6){
				if (searchFlag) {
					new CustomJOptionPane("COMPLETED !!!", "Searching Completed.", "Done");
				}
	    		
				if (!searchFlag) {
					new CustomJOptionPane("Not Found!!!", "Value Not Found.", "Ok");
					new CustomJOptionPane("COMPLETED !!!", "Searching Completed.", "Done");
				}
				stop();
	    	}
	    	
	    	if (array[node] == searchVal) {
	    		searchCount++;
	    		searchFlag = true;
	    		new CustomJOptionPane("Found!!!", ("Value Found.\n" + searchCount + " times."), "Ok");
	    	}
	    	
	    }
	    
  
	    @Override
	    public void run() {
	        while (threadFlag) {

	        	repaint();
	            update();

	            try {
	                Thread.sleep(time*1000);
	            } catch (InterruptedException e) {
	                System.out.println("interrupted");
	            }
	            node++;
	            count++;
	        }
	    }
	    
	    public void start() {
	    	if (threadFlag) {
	    		return;
	    	}
	    	
	    	threadFlag = true;
	    	thread = new Thread(this);
	    	thread.start();
	    }
	    
	    public void stop() {
	    	if (!threadFlag) {
	    		return;
	    	}
	    	node = 0;
	    	count = 0;
	    	searchCount = 0;
	    	threadFlag = false;
	    	searchFlag = false;
	    	try {
	    		thread.join();
	    	} catch (InterruptedException e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    public void setArrayValue(int input1, int input2, int input3, int input4, int input5, int searchVal){   	
	    	array[0] = -1;
	    	array[1] = input1;
	    	array[2] = input2;
	    	array[3] = input3;
	    	array[4] = input4;
	    	array[5] = input5;
	    	
	    	arrayString[0] = String.valueOf(input1);
	    	arrayString[1] = String.valueOf(input2);
	    	arrayString[2] = String.valueOf(input3);
	    	arrayString[3] = String.valueOf(input4);
	    	arrayString[4] = String.valueOf(input5);
	    	
	    	this.searchVal = searchVal;
	    }
	    
	    public boolean getThreadState(){
	    	return threadFlag;
	    }
	    
	    public void setTime(int time) {
			this.time = time;
		}
	    
}
