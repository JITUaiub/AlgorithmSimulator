package com.JS.AlgorithmSimulator.Searching;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LinearSearchSimulation extends JPanel implements Runnable{
	
	private final int DELAY = 50;
	private int searchVal = 0;
	
	///Variables For Draw
	private int [] array;
	private String [] arrayString;
	private final int BOX_SIZE = 100;
	
	private final Color CURRENT_COLOR = Color.YELLOW;
	private final Color ACTIVE_COLOR = Color.RED;
	
	private int node = 0;
	private int count = 0;
	private Thread thread;
	private boolean threadFlag = false;
	
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
	    
	    
	///Work here for Graphics
	    @Override
	    public void paintComponent(Graphics g) {
	    	super.paintComponent(g);
	    	/// Start Draw
	    	g.setFont(new Font("calibiri", Font.BOLD, 30));
	    	
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
	    	
	    	/// End Draw
	    	g.dispose();
	    }
	    
	///Work here for Update Graphics
	    public void update() {	
	    	
	    	/// Start Updating
	    	if (array[node] == searchVal) {
				JOptionPane.showMessageDialog(null, "Value Found", "Found!!!" , JOptionPane.INFORMATION_MESSAGE);
				stop();
	    	}else {
				if(count == 5){
					JOptionPane.showMessageDialog(null, "Value Not Found", "Not Found!!!" , JOptionPane.INFORMATION_MESSAGE);
					stop();
				}
			}
	    	System.out.println(node);
	    	///Stop updating
	    }
	    
  
	    @Override
	    public void run() {
	        ///long beforeTime, timeDiff, sleep;

	        ///beforeTime = System.currentTimeMillis();

	        while (threadFlag) {

	        	repaint();
	            update();

	           /// timeDiff = System.currentTimeMillis() - beforeTime;
	           /// sleep = DELAY - timeDiff;

	           /// if (sleep < 0)
	            ///    sleep = 2;
	            try {
	                Thread.sleep(3000);
	            } catch (InterruptedException e) {
	                System.out.println("interrupted");
	            }
	            node++;
	            count++;
	            ///beforeTime = System.currentTimeMillis();
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
	    	threadFlag = false;
	    	try {
	    		thread.join();
	    	} catch (InterruptedException e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    public void show() {
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}
		}
	    
	    public void setArrayValue(int input1, int input2, int input3, int input4, int input5, int searchVal){   	
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
	    
}
