package arcjava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectionPanel extends JPanel {
	
	SelectionPanel() {
		
		this.setSize(500, 400);
		this.setLayout(new GridLayout(7, 1));
		
		JLabel selectionLabel = new JLabel("Select Item");
		
		// TODO: swap out Strings for dual-String type (may have to hard code it)
		String[] existingNames = {"F0006", "F0016WORLD", "F0101", "F01012", "F0311A"};
		JComboBox selectionList = new JComboBox();
		selectionList.setBackground(Color.white);
		selectionList.addItem("");
		selectionList.addItem("Create New Item");
		for (int i = 0; i < existingNames.length; i++) {
			selectionList.addItem(existingNames[i]);
		}
		
		JButton selectionButton = new JButton("Select Item");
		
		JLabel nameLabel = new JLabel("Name:");
		JTextField selectedName = new JTextField("");
		selectedName.setBackground(Color.white);
		selectedName.setEditable(false);
		JLabel descLabel = new JLabel("Description:");
		JTextField selectedDesc = new JTextField("");
		selectedDesc.setBackground(Color.white);
		selectedDesc.setEditable(false);

		
		// TODO: add button functionality
		ActionListener sButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}		
		};
		
		
		// TODO: add ComboBox functionality (is this even necessary?)
		ActionListener sComboListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}		
		};
		
		selectionList.addActionListener(sComboListener);

		
		
		this.add(selectionLabel);
		this.add(selectionList);
		this.add(selectionButton);
		this.add(nameLabel);
		this.add(selectedName);
		this.add(descLabel);
		this.add(selectedDesc);
				
	}
	
}