package com.JS.AlgorithmSimulator.Sorting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.JS.AlgorithmSimulator.Custom.CustomJOptionPane;

public class SelectionSortSimulation extends JPanel implements Runnable {
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
	private int minimumValue = 0;
	
	private String swapElement1 = "";
	private String swapElement2 = "";
	
	private Thread thread;
	
	private boolean threadFlag = false;
	private boolean swapFlag = false;
	
	private String order = "Asc";
	
	    public SelectionSortSimulation(int inputSize){
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
	    	
	    	if (nodeCountAsc == 0) {
	    		g.setColor(CHECKING_COLOR);
			}else {
				g.setColor(CURRENT_COLOR);
			}
	    	
	    	if (nodeCountAsc == 5 || nodeCountAsc == 6) {
	    		g.setColor(CURRENT_COLOR);
			}
	    	
	    	if (nodeCountAsc >= 7) {
				g.setColor(FINISHED_COLOR);
			}
	    	
	    	g.fillRect(1*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[0], (1*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if (nodeCountAsc == 1 || nodeCountAsc == 8) {
	    		g.setColor(CHECKING_COLOR);
			}else {
				g.setColor(CURRENT_COLOR);
			}
	    	
	    	if (nodeCountAsc == 12 || nodeCountAsc == 13) {
	    		g.setColor(CURRENT_COLOR);
			}

	    	if (nodeCountAsc >= 14) {
				g.setColor(FINISHED_COLOR);
			}
			
	    	g.fillRect(2*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[1], (2*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if (nodeCountAsc == 2 || nodeCountAsc == 9 || nodeCountAsc == 15) {
	    		g.setColor(CHECKING_COLOR);
			}else {
				g.setColor(CURRENT_COLOR);
			}
	    	
	    	if (nodeCountAsc == 18 || nodeCountAsc == 19) {
	    		g.setColor(CURRENT_COLOR);
			}

	    	if (nodeCountAsc >= 20) {
				g.setColor(FINISHED_COLOR);
			}
			
	    	g.fillRect(3*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[2], (3*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if (nodeCountAsc == 3 || nodeCountAsc == 10 || nodeCountAsc == 16 || nodeCountAsc == 20) {
	    		g.setColor(CHECKING_COLOR);
			}else {
				g.setColor(CURRENT_COLOR);
			}
	    	
	    	if (nodeCountAsc == 22 || nodeCountAsc == 23) {
	    		g.setColor(CURRENT_COLOR);
			}

	    	if (nodeCountAsc >= 24) {
				g.setColor(FINISHED_COLOR);
			}
	    	
	    	g.fillRect(4*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[3], (4*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	if (nodeCountAsc == 4 || nodeCountAsc == 11 || nodeCountAsc == 17 || nodeCountAsc == 21) {
	    		g.setColor(CHECKING_COLOR);
			}else {
				g.setColor(CURRENT_COLOR);
			}
	    	
	    	if (nodeCountAsc == 25) {
				g.setColor(CURRENT_COLOR);
			}
	    	
	    	if (nodeCountAsc >= 26) {
				g.setColor(FINISHED_COLOR);
			}
	    	
	    	g.fillRect(5*getWidth()/5 -150, getHeight()/2 - 50, BOX_SIZE, BOX_SIZE);
	    	g.setColor(Color.BLACK);
	    	g.drawString(arrayString[4], (5*getWidth()/5-110), (getHeight()/2)+10);
	    	
	    	g.drawString("Swapped: " + (!swapFlag ? "" : (swapElement1 + " and " + swapElement2)) , (3*getWidth()/5), (getHeight()/2)+110);
	    	g.drawString((order.equals("Asc") ? "Minimum Value: " : "Maximum Value: ") + minimumValue, (3*getWidth()/5-420), (getHeight()/2)+110);
	    	
	    	g.dispose();
	    }
	    
	    public void update() {	
	    	if (nodeCountAsc == 27 ||nodeCountDsc == 27) {
	    		new CustomJOptionPane("COMPLETED !!!", ("Sorted in " + (order.equals("Asc") ? "Ascending" : "Descending") + " order."), "Done");
	    		stop();
			}

	    	if (order.equals("Asc")) {
	    		if (nodeCountAsc == 0) {
					if (array[1] < minimumValue) {
						minimumValue = array[1];
					}
				}else if (nodeCountAsc == 1 || nodeCountAsc == 8) {
					if (array[2] < minimumValue) {
						minimumValue = array[2];
					}
				}else if (nodeCountAsc == 2 || nodeCountAsc == 9 || nodeCountAsc == 15) {
					if (array[3] < minimumValue) {
						minimumValue = array[3];
					}
				}else if (nodeCountAsc == 3 || nodeCountAsc == 10 || nodeCountAsc == 16 || nodeCountAsc == 20) {
					if (array[4] < minimumValue) {
						minimumValue = array[4];
					}
				}else if (nodeCountAsc == 4 || nodeCountAsc == 11 || nodeCountAsc == 17 || nodeCountAsc == 21) {
					if (array[5] < minimumValue) {
						minimumValue = array[5];
					}
				}
			}else if (order.equals("Dsc")) {
				if (nodeCountAsc == 0) {
					if (array[1] > minimumValue) {
						minimumValue = array[1];
					}
				}else if (nodeCountAsc == 1 || nodeCountAsc == 8) {
					if (array[2] > minimumValue) {
						minimumValue = array[2];
					}
				}else if (nodeCountAsc == 2 || nodeCountAsc == 9 || nodeCountAsc == 15) {
					if (array[3] > minimumValue) {
						minimumValue = array[3];
					}
				}else if (nodeCountAsc == 3 || nodeCountAsc == 10 || nodeCountAsc == 16 || nodeCountAsc == 20) {
					if (array[4] > minimumValue) {
						minimumValue = array[4];
					}
				}else if (nodeCountAsc == 4 || nodeCountAsc == 11 || nodeCountAsc == 17 || nodeCountAsc == 21) {
					if (array[5] > minimumValue) {
						minimumValue = array[5];
					}
				}
			}
	    	
	    	if (nodeCountAsc == 6 || nodeCountDsc == 6) {
				for (int i = 1; i < array.length; i++) {
					if (array[i] == minimumValue) {
						swapFlag = true;
						swapInt(array, 1, i);
						swapString(arrayString, 0, i-1);
						
						minimumValue = array[2];
						return ;
					}
				}
			}else if (nodeCountAsc == 13 || nodeCountDsc == 13) {
				for (int i = 2; i < array.length; i++) {
					if (array[i] == minimumValue) {
						swapFlag = true;
						swapInt(array, 2, i);
						swapString(arrayString, 1, i-1);
						
						minimumValue = array[3];
						return ;
					}
				}
			}else if (nodeCountAsc == 19 || nodeCountDsc == 19) {
				for (int i = 3; i < array.length; i++) {
					if (array[i] == minimumValue) {
						swapFlag = true;
						swapInt(array, 3, i);
						swapString(arrayString, 2, i-1);
						
						minimumValue = array[4];
						return ;
					}
				}
			}else if (nodeCountAsc == 23 || nodeCountDsc == 23) {
				for (int i = 4; i < array.length; i++) {
					if (array[i] == minimumValue) {
						swapFlag = true;
						swapInt(array, 4, i);
						swapString(arrayString, 3, i-1);
						
						minimumValue = array[5];
						return ;
					}
				}
			}else {
				swapFlag = false;
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
	    	minimumValue = array[1];
	    	threadFlag = false;
	    	swapFlag = false;
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
	    	
	    	minimumValue = array[1];
	    	
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
