package Fitness;

import java.awt.event.*;
import javax.swing.*;

import fitness_2.Calculation_2;
import fitness_2.fitness_2;

public class Fitness extends JFrame {
	
	Calculation_2 cal;
	public Fitness() {
		JPanel panel = new JPanel();
		JLabel numLabel = new JLabel("Enter the number of member");
		JTextField numText = new JTextField(4);
		JButton statBtn = new JButton("Submit");
		
		panel.add(numLabel);
		panel.add(numText);
		panel.add(statBtn);
		
		
		
		statBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {}
		});
		
		statBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				cal = new Calculation_2();
				String num = numText.getText().trim();
				if(checkStr(num)) {
					int n = Integer.parseInt(num);
					cal.CalculationPanel(n);
				}
			}
		});
		add(panel);
		setVisible(true);
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
	public static void main(String[] args) {
		new fitness_2();
	}

}
