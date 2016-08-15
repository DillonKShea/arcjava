package arcjava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import arcjava.DBConnection;

public class SelectionPanel extends JPanel {
	
	SelectionPanel() {
		
		this.setSize(500, 400);
		this.setLayout(new GridLayout(7, 1));
		
		JLabel selectionLabel = new JLabel("Select Item");
		
		// TODO: swap out Strings for dual-String type (may have to hard code it)		
		DBConnection.connect();
		ResultSet rSet = DBConnection.getResultSet();
		int querySize = DBConnection.getRSSize();
		String[] existingNames = new String[querySize];
		for (int i = 0; i < querySize; i++) {
			try {
				rSet.next();
				existingNames[i] = rSet.getString(1);
			} catch (SQLException e) {
				System.out.println("ComboBox population error: " + e);
				break;
			}	
		}
		try {
			rSet.beforeFirst();
		}
		catch (SQLException e) {
			System.out.println("Error: " + e);
		}
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
//				DBConnection.connect();
			}		
		};
		
		ActionListener sComboListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectionList.getSelectedItem() == "Create New Item") {
					selectedName.setText("");
					selectedName.setEditable(true);
					selectedDesc.setText("");
					selectedDesc.setEditable(true);
				}
				else {
					selectedName.setEditable(false);
					selectedName.setText((selectionList.getSelectedItem()).toString());
					selectedDesc.setEditable(false);
				}
			}		
		};
		
		selectionButton.addActionListener(sButtonListener);
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