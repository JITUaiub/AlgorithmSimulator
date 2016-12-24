package com.JS.AlgorithmSimulator.Sorting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.JS.AlgorithmSimulator.Custom.CustomJOptionPane;

public class BubbleSortSimulation extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private final Font DRAW_FONT = new Font("calibiri", Font.BOLD, 25);
	
	private int [] array;
	private String [] arrayString;
	private final int BOX_SIZE = 100;
	
	private final Color CHECKING_COLOR = Color.RED;
	private final Color CURRENT_COLOR = Color.YELLOW;
	private final Color FINISHED_COLOR = Color.GREEN;
	
	private int nodeCountAsc = -1;
	private int nodeCountDsc = -1;
	private int time = 1;
	
	private String swapElement1 = "";
	private String swapElement2 = "";
	
	private Thread thread;
	
	private boolean threadFlag = false;
	private boolean swapFlag = false;
	
	private String order = "";
	
	    public BubbleSortSimulation(int inputSize){
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
	    	
	    	if(nodeCountAsc == -1 || nodeCountAsc == 4 || nodeCountAsc == 8 || nodeCountAsc == 11 ||nodeCountAsc == 13){
	    		g.setColor(CURRENT_COLOR);
	    	}
	    	if(nodeCountAsc == 0 || nodeCountAsc == 5 || nodeCountAsc == 9 || nodeCountAsc == 12){
	    		g.setColor(CHECKING_COLOR);
	    	}else if (nodeCountAsc == 1 || nodeCountAsc == 6 || nodeCountAsc == 10) {
	    		g.setColor(CURRENT_COLOR);
			}else if (nodeCountAsc == 2 || nodeCountAsc == 7) {
				g.setColor(CURRENT_COLOR);
			}else if (nodeCountAsc == 3) {
				g.setColor(CURRENT_COLOR);
			}
	    	
	    	if(nodeCountAsc >= 14){
	    		g.setColor(FINISHED_COLOR);
	    	}
	    	
	    	g.fillRect(1*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[0], (1*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(nodeCountAsc == -1 || nodeCountAsc == 4 || nodeCountAsc == 8 || nodeCountAsc == 11){
	    		g.setColor(CURRENT_COLOR);
	    	}
	    	if(nodeCountAsc == 0 || nodeCountAsc == 5 || nodeCountAsc == 9 || nodeCountAsc == 12){
	    		g.setColor(CHECKING_COLOR);
	    	}else if (nodeCountAsc == 1 || nodeCountAsc == 6 || nodeCountAsc == 10) {
	    		g.setColor(CHECKING_COLOR);
			}else if (nodeCountAsc == 2 || nodeCountAsc == 7) {
				g.setColor(CURRENT_COLOR);
			}else if (nodeCountAsc == 3) {
				g.setColor(CURRENT_COLOR);
			}
	    	
	    	if(nodeCountAsc >= 13){
	    		g.setColor(FINISHED_COLOR);
	    	}
			
	    	g.fillRect(2*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[1], (2*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(nodeCountAsc == -1 || nodeCountAsc == 4 || nodeCountAsc == 8){
	    		g.setColor(CURRENT_COLOR);
	    	}
	    	if(nodeCountAsc == 0 || nodeCountAsc == 5 || nodeCountAsc == 9){
	    		g.setColor(CURRENT_COLOR);
	    	}else if (nodeCountAsc == 1 || nodeCountAsc == 6 || nodeCountAsc == 10) {
	    		g.setColor(CHECKING_COLOR);
			}else if (nodeCountAsc == 2 || nodeCountAsc == 7) {
				g.setColor(CHECKING_COLOR);
			}else if (nodeCountAsc == 3) {
				g.setColor(CURRENT_COLOR);
			}
	    	
	    	if(nodeCountAsc >= 11){
	    		g.setColor(FINISHED_COLOR);
	    	}
			
	    	g.fillRect(3*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[2], (3*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(nodeCountAsc == -1 || nodeCountAsc == 4){
	    		g.setColor(CURRENT_COLOR);
	    	}
	    	if(nodeCountAsc == 0 || nodeCountAsc == 5){
	    		g.setColor(CURRENT_COLOR);
	    	}else if (nodeCountAsc == 1 || nodeCountAsc == 6) {
	    		g.setColor(CURRENT_COLOR);
			}else if (nodeCountAsc == 2 || nodeCountAsc == 7) {
				g.setColor(CHECKING_COLOR);
			}else if (nodeCountAsc == 3) {
				g.setColor(CHECKING_COLOR);
			}
			
	    	if(nodeCountAsc >= 8){
	    		g.setColor(FINISHED_COLOR);
	    	}
	    	
	    	g.fillRect(4*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[3], (4*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if(nodeCountAsc == -1){
	    		g.setColor(CURRENT_COLOR);
	    	}
	    	if(nodeCountAsc == 0){
	    		g.setColor(CURRENT_COLOR);
	    	}else if (nodeCountAsc == 1) {
	    		g.setColor(CURRENT_COLOR);
			}else if (nodeCountAsc == 2) {
				g.setColor(CURRENT_COLOR);
			}else if (nodeCountAsc == 3) {
				g.setColor(CHECKING_COLOR);
			}
	    	
	    	if(nodeCountAsc >= 4){
	    		g.setColor(FINISHED_COLOR);
	    	}
	    	
	    	g.fillRect(5*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[4], (5*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	g.drawString("Swapped: " + (!swapFlag ? "" : (swapElement1 + " and " + swapElement2)) , (3*getWidth()/5-220), (getHeight()/2)+110);
	    	
	    	g.dispose();
	    }
	    
	    public void update() {	
	    	if (order.equals("Asc")) {
				if (nodeCountAsc == 0 || nodeCountAsc == 5 || nodeCountAsc == 9 || nodeCountAsc == 12) {
					if (array[1] > array[2]) {
						swapFlag = true;
						swapInt(array, 1, 2);
						swapString(arrayString, 0, 1);
					}else {
						swapFlag = false;
					}
				}else if (nodeCountAsc == 1 || nodeCountAsc == 6 || nodeCountAsc == 10) {
					if (array[2] > array[3]) {
						swapFlag = true;
						swapInt(array, 2, 3);
						swapString(arrayString, 1, 2);
					}else {
						swapFlag = false;
					}
				}else if (nodeCountAsc == 2 || nodeCountAsc == 7) {
					if (array[3] > array[4]) {
						swapFlag = true;
						swapInt(array, 3, 4);
						swapString(arrayString, 2, 3);
					}else {
						swapFlag = false;
					}
				}else if (nodeCountAsc == 3) {
					if (array[4] > array[5]) {
						swapFlag = true;
						swapInt(array, 4, 5);
						swapString(arrayString, 3, 4);
					}else {
						swapFlag = false;
					}
				}
				if (nodeCountAsc == 4 || nodeCountAsc ==8 || nodeCountAsc == 11 || nodeCountAsc == 13) {
					swapFlag = false;
				}
			}else if (order.equals("Dsc")) {
				if (nodeCountAsc == 0 || nodeCountAsc == 4 || nodeCountAsc == 7 || nodeCountAsc == 9) {
					if (array[1] < array[2]) {
						swapFlag = true;
						swapInt(array, 1, 2);
						swapString(arrayString, 0, 1);
					}else {
						swapFlag = false;
					}
				}else if (nodeCountAsc == 1 || nodeCountAsc == 5 || nodeCountAsc == 8) {
					if (array[2] < array[3]) {
						swapFlag = true;
						swapInt(array, 2, 3);
						swapString(arrayString, 1, 2);
					}else {
						swapFlag = false;
					}
				}else if (nodeCountAsc == 2 || nodeCountAsc == 6) {
					if (array[3] < array[4]) {
						swapFlag = true;
						swapInt(array, 3, 4);
						swapString(arrayString, 2, 3);
					}else {
						swapFlag = false;
					}
				}else if (nodeCountAsc == 3) {
					if (array[4] < array[5]) {
						swapFlag = true;
						swapInt(array, 4, 5);
						swapString(arrayString, 3, 4);
					}else {
						swapFlag = false;
					}
				}
				if (nodeCountDsc == 4 || nodeCountDsc ==8 || nodeCountDsc == 11 || nodeCountDsc == 13) {
					swapFlag = false;
				}
			}
	    	
	    	if(nodeCountAsc == 15 || nodeCountDsc == 15){
	    		new CustomJOptionPane("COMPLETED !!!", ("Sorted in " + (order.equals("Asc") ? "Ascending" : "Descending") + " order."), "Done");
	    		stop();
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
	            
	            nodeCountAsc++;
	            nodeCountDsc++;
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
	    	nodeCountAsc = -1;
	    	nodeCountDsc = -1;
	    	threadFlag = false;
	    	try {
	    		thread.join();
	    	} catch (InterruptedException e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    public void setArrayValue(int input1, int input2, int input3, int input4, int input5){   	
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
	    }
	    
	    public boolean getThreadState(){
	    	return threadFlag;
	    }
	    
	    public void setOrder(String order) {
			this.order = order;
		}
	    
	    private void swapInt(int [] arr, int index1, int index2){
	    	int temp = arr[index1];
	    	arr[index1] = arr[index2];
	    	arr[index2] = temp;
	    }
	    
	    private void swapString(String [] arr, int index1, int index2){
	    	String temp = arr[index1];
	    	arr[index1] = arr[index2];
	    	arr[index2] = temp;

			swapElement1 = arrayString[index1];
			swapElement2 = arrayString[index2];
	    }

		public void setTime(int time) {
			this.time = time;
		}
	    
	    
}
