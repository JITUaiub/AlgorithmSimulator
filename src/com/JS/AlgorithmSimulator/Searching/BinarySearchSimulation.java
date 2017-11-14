package com.JS.AlgorithmSimulator.Searching;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.JS.AlgorithmSimulator.Custom.CustomJOptionPane;

public class BinarySearchSimulation extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	private int searchVal = 0;
	private final Font DRAW_FONT = new Font("calibiri", Font.BOLD, 25);
	
	private int [] array;
	private String [] arrayString;
	private final int BOX_SIZE = 100;
	
	private final Color INACTIVE_COLOR = Color.WHITE;
	private final Color ACTIVE_COLOR = Color.YELLOW;
	private final Color FOUND_COLOR = Color.RED;
	
	
	private Thread thread;
	private boolean threadFlag = false;
	private boolean searchFlag = false;
	
	private int searchCount = 0;
	private int start = 0;
	private int end = 4;
	private int mid = 2;
	private int time = 1;
	

	private String order = "";
	
	    public BinarySearchSimulation(int inputSize){
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
	    	
	    	if(searchCount == 1){
	    		g.setColor(ACTIVE_COLOR);
	    	}else if (searchCount == 2) {
				if(start == 0){
					g.setColor(ACTIVE_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else if (searchCount == 3) {
				if(searchVal == array[1]){
					g.setColor(ACTIVE_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
					if (order.equals("desc")) {
						if (searchVal > array[1] || (searchVal < array[1] && searchVal > array[2])) {
							g.setColor(ACTIVE_COLOR);
						}
					}else {
						if (searchVal < array[1] || (searchVal > array[1] && searchVal < array[2])) {
							g.setColor(ACTIVE_COLOR);
						}
					}
				}
			}else if (searchCount == 4) {
				if(searchVal == array[1]){
					g.setColor(FOUND_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else {
				g.setColor(ACTIVE_COLOR);
			}
	    	
	    	g.fillRect(1*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[0], (1*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(searchCount == 1){
	    		g.setColor(ACTIVE_COLOR);
	    	}else if (searchCount == 2) {
				if(start == 0){
					g.setColor(ACTIVE_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else if (searchCount == 3) {
				if(searchVal == array[2]){
					g.setColor(ACTIVE_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else if (searchCount == 4) {
				if(searchVal == array[2]){
					g.setColor(FOUND_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else {
				g.setColor(ACTIVE_COLOR);
			}
	    	
	    	g.fillRect(2*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[1], (2*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(searchCount == 1){
	    		g.setColor(ACTIVE_COLOR);
	    	}else if (searchCount == 2) {
				if(start == 0 || start == 2){
					g.setColor(ACTIVE_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else if (searchCount == 3) {
				if(searchVal == array[2]){
					g.setColor(ACTIVE_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
					if (start == 0) {
						if (order.equals("desc")) {
							if (searchVal < array[2]) {
								g.setColor(ACTIVE_COLOR);
							}
						}else {
							if (searchVal > array[2]) {
								g.setColor(ACTIVE_COLOR);
							}
						}
					}else {
						if (order.equals("desc")) {
							if (searchVal > array[4]) {
								g.setColor(ACTIVE_COLOR);
							}
						}else {
							if (searchVal < array[4]) {
								g.setColor(ACTIVE_COLOR);
							}
						}
					}
				}
			}else if (searchCount == 4) {
				if(searchVal == array[3]){
					g.setColor(FOUND_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else {
				g.setColor(ACTIVE_COLOR);
			}
	    	
	    	g.fillRect(3*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[2], (3*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(searchCount == 1){
	    		g.setColor(ACTIVE_COLOR);
	    	}else if (searchCount == 2) {
				if(start == 2){
					g.setColor(ACTIVE_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else if (searchCount == 3) {
				if(searchVal == array[4]){
					g.setColor(ACTIVE_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else if (searchCount == 4) {
				if(searchVal == array[4]){
					g.setColor(FOUND_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else {
				g.setColor(ACTIVE_COLOR);
			}
	    	
	    	g.fillRect(4*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[3], (4*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(searchCount == 1){
	    		g.setColor(ACTIVE_COLOR);
	    	}else if (searchCount == 2) {
				if(start == 2){
					g.setColor(ACTIVE_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else if (searchCount == 3) {
				if(searchVal == array[5]){
					g.setColor(ACTIVE_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
					if (order.equals("desc")) {
						if (searchVal < array[5] || (searchVal < array[4] && searchVal > array[5])) {
							g.setColor(ACTIVE_COLOR);
						}
					}else {
						if (searchVal > array[5] || (searchVal > array[4] && searchVal < array[5])) {
							g.setColor(ACTIVE_COLOR);
						}
					}
				}
			}else if (searchCount == 4) {
				if(searchVal == array[5]){
					g.setColor(FOUND_COLOR);
				}else {
					g.setColor(INACTIVE_COLOR);
				}
			}else {
				g.setColor(ACTIVE_COLOR);
			}
	    	
	    	g.fillRect(5*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[4], (5*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	
	    	
	    	g.drawString("End: " + end, (getWidth()-300), (getHeight()/2)+110);
	    	g.drawString("Mid: " + mid, (getWidth()-600), (getHeight()/2)+110);
	    	g.drawString("Start: " + start, (3*getWidth()/5-430), (getHeight()/2)+110);
	    	
	    	g.drawString("Search Value: " + searchVal, (getWidth()/2-100), (getHeight()/2)+150);
	    	
	    	g.dispose();
	    }
	    
	    public void update() {	
	    	
	    	if(order.equals("desc")){
	    		if(searchCount == 1){
		    		start = 0;
		    		end = 4;
		    		mid = (start + end)/2;
		    	}else if (searchCount == 2) {
					if(searchVal > array[3]){
						end = mid;
						mid = (start + end)/2;
					}else {
						start = mid;
						mid = (start + end)/2;
					}
				}else if (searchCount == 3) {
					if(start == 2){
						if(searchVal < array[4]){
							start = end;
							mid = end;
							if (array[5] == searchVal) {
					    		searchFlag = true;
				    		}
						}else if(searchVal > array[4]) {
							end = start;
							mid = start;
							if (array[3] == searchVal) {
					    		searchFlag = true;
				    		}
						}else {
							start = mid;
							end = mid;
							if (array[4] == searchVal) {
					    		searchFlag = true;
				    		}
						}
					}else if(start == 0){
						if(searchVal < array[2]){
							start = end;
							mid = end;
						}else if(searchVal > array[2]){
							end = start;
							mid = start;
							if (array[1] == searchVal) {
					    		searchFlag = true;
				    		}
						}else {
							start = mid;
							end = mid;
							if (array[2] == searchVal) {
					    		searchFlag = true;
							}
						}
					}
				}
	    	}else {
	    		if(searchCount == 1){
		    		start = 0;
		    		end = 4;
		    		mid = (start + end)/2;
		    	}else if (searchCount == 2) {
					if(searchVal < array[3]){
						end = mid;
						mid = (start + end)/2;
					}else {
						start = mid;
						mid = (start + end)/2;
					}
				}else if (searchCount == 3) {
					if(start == 2){
						if(searchVal > array[4]){
							start = end;
							mid = end;
							if (array[5] == searchVal) {
					    		searchFlag = true;
				    		}
						}else if(searchVal < array[4]) {
							end = start;
							mid = start;
							if (array[3] == searchVal) {
					    		searchFlag = true;
				    		}
						}else {
							start = mid;
							end = mid;
							if (array[4] == searchVal) {
					    		searchFlag = true;
				    		}
						}
					}else if(start == 0){
						if(searchVal > array[2]){
							start = end;
							mid = end;
						}else if(searchVal < array[2]){
							end = start;
							mid = start;
							if (array[1] == searchVal) {
					    		searchFlag = true;
				    		}
						}else {
							start = mid;
							end = mid;
							if (array[2] == searchVal) {
					    		searchFlag = true;
				    		}
						}
					}
				}
			}
	    	
	    	if (start == end && end == mid) {
	    		if(!searchFlag){
	    			if(searchCount == 4){
	    				new CustomJOptionPane("Not Found!!!", "Value Not Found.", "Ok");
	    				new CustomJOptionPane("COMPLETED !!!", "Searching Completed.", "Done");
						stop();
					}
	    		}else {
	    			if(searchCount == 4){
	    				new CustomJOptionPane("Found!!!", "Value Found.", "Ok");
	    				new CustomJOptionPane("COMPLETED !!!", "Searching Completed.", "Done");
	    				stop();
					}
				}
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
	                e.printStackTrace();
	            }
	            searchCount++;
	            
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
	    	start = 0;
	    	end = 4;
	    	mid = (start+end)/2;
	    	searchCount = 0;
	    	searchFlag = false;
	    	threadFlag = false;
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
	    
	    public void setOrder(String order) {
			this.order = order;
		}
	     
	    public void setTime(int time) {
	    	this.time = time;
	    }
	       
}
