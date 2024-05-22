package Fitness;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import fitness_2.Person2;

import java.awt.event.*;

public class Calculation implements MouseListener {
	
	void CalculationPanel(int n) {
		JFrame frame;
		JPanel panel;
		JPanel panel1;
		JPanel panel2;
		JPanel panel3;
		JPanel panel4;
		JButton calBtn;
		JTextField nameText, timeText, satisText, dissatisText, orderText, totalText;
		frame = new JFrame("Scheduling");
		panel = new JPanel();
		panel1 = new JPanel(new GridLayout(4,1));
		panel2 = new JPanel(new GridLayout(4,1));
		panel3 = new JPanel();
		panel4 = new JPanel(new GridLayout(2,1));

		JLabel nameLabel = new JLabel("Name",JLabel.CENTER);
		JLabel timeLabel = new JLabel("Waiting time",JLabel.CENTER);
		JLabel satisLabel = new JLabel("Satisfaction",JLabel.CENTER);
		JLabel dissatisLabel = new JLabel("Dissatisfaction",JLabel.CENTER);
		panel1.add(nameLabel);
		panel1.add(timeLabel);
		panel1.add(satisLabel);
		panel1.add(dissatisLabel);

		nameText = new JTextField(20);
		nameText.addMouseListener(this);
		timeText = new JTextField(2);
		timeText.addMouseListener(this);
		satisText = new JTextField(4);
		satisText.addMouseListener(this);
		dissatisText = new JTextField(4);
		dissatisText.addMouseListener(this);
		
		

		panel2.add(nameText);
		panel2.add(timeText);
		panel2.add(satisText);
		panel2.add(dissatisText);
		
		
		frame.add(panel,BorderLayout.NORTH);
		frame.add(panel1,BorderLayout.WEST);
		frame.add(panel2, BorderLayout.EAST);
//		orderText = new JTextField(20);
//		orderText.addMouseListener(this);
//		totalText = new JTextField(10);
//		totalText.addMouseListener(this);
//		panel4.add(orderText);
//		panel4.add(totalText);
		calBtn = new JButton("Scheduling"); 
		panel3.add(calBtn,BorderLayout.SOUTH);
		calBtn.addMouseListener(this);
		
		frame.add(panel3, BorderLayout.SOUTH);
		try {
			calBtn.addActionListener(new ActionListener() {
	    		@Override
	    		public void actionPerformed(ActionEvent e) {
	    		}
	    	});
	    	
	    	calBtn.addMouseListener(new MouseAdapter() {
	    		
	    		public void mouseClicked(MouseEvent e) {
	    			String sName = nameText.getText();
    				String sTime = timeText.getText();
    				String sSatis = satisText.getText();
    				String sDissatis = dissatisText.getText();
    				String[] nameArr = sName.split(" ");
    				String[] timeArr = sTime.split(" ");
    				String[] satisArr = sSatis.split(" ");
    				String[] dissatisArr = sDissatis.split(" ");
    				//Person2 p[] = new Person2[n];
	    			for(int i = 0;i < n;i++) {
	    				if(checkStr(timeArr[i])&&checkStr(satisArr[i]) && checkStr(dissatisArr[i])) {
	    					p[i].setName(nameArr[i]);
							system.out.println(p[i].getName());
	    					p[i].waitingTime = Integer.parseInt(timeArr[i]);
	    					p[i].satisfaction = Integer.parseInt(satisArr[i]);
	    					p[i].dissatisfaction = Integer.parseInt(dissatisArr[i]);
	    					p[i].index = i;
	    				}
	    				
	    			}
	    			for (int i = 0; i < n - 1; i++) {
	    	            for (int j = 0; j < n - i - 1; j++) {
	    	                if ((double)p[j].dissatisfaction / ((double)p[j].waitingTime + 1) < (double)p[j + 1].dissatisfaction / ((double)p[j + 1].waitingTime + 1)) {
	    	                    Person temp = new Person();
	    	                    temp = p[j + 1];
	    	                    p[j + 1] = p[j];
	    	                    p[j] = temp;
	    	                }
	    	                else if ((double)p[j].dissatisfaction / (double)p[j].waitingTime == (double)p[j + 1].dissatisfaction / (double)p[j + 1].waitingTime) {
	    	                    if (p[j].dissatisfaction > p[j + 1].dissatisfaction * p[j + 1].waitingTime)
	    	                        continue;
	    	                    else
	    	                    {
	    	                        Person temp = new Person();
	    	                        temp = p[j + 1];
	    	                        p[j + 1] = p[j];
	    	                        p[j] = temp;
	    	                    }
	    	                }
	    	                else
	    	                    continue;
	    	            }
	    	        }
	    			
	    	        int tot_satisfaction = 0;
	    	        int[] order = {0,};
	    	        for(int i = 0;i < n;i++) {
	    	        	order[i] = p[i].index;
	    	        	
	    	        }
	    	        String orderResult = Arrays.toString(order);
	    	        //orderText.setText(orderResult);
	    	        JLabel orderLabel ;//= new JLabel("Order of use: " + orderResult);
	    			JLabel totalLabel;// = new JLabel("Total satisfaction: ");
	    	        orderLabel = new JLabel("Order of use: " + orderResult);
	    	        
	    	       
	    	        for (int i = 0; i < n; i++) {
	    	            
	    	            if (i < p[i].waitingTime) {
	    	                tot_satisfaction += p[i].satisfaction;
	    	            }
	    	            else
	    	                tot_satisfaction += p[i].satisfaction - ((i - p[i].waitingTime) * p[i].dissatisfaction);
	    	        }
	    	        String totalResult = Integer.toString(tot_satisfaction);
	    	        //totalText.setText(totalResult);
	    	        panel4.add(orderLabel);
	    	        totalLabel = new JLabel("Total satisfaction: " + totalResult);
	    			panel4.add(totalLabel);
	    	    }
	    		
	    	});	
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		frame.add(panel4, BorderLayout.CENTER);

		frame.setBounds(450,250,350,200);
		frame.setResizable(false);
		frame.setVisible(true);
		

				
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	boolean checkStr(String s){
    	boolean result = false;
    	for(int i = 0 ;i < s.length();i++) {
    		if(!Character.isDigit(s.charAt(i))) {
    			result = false;
    		}else
    			result = true;
    	}
    	return result;
    }


}
