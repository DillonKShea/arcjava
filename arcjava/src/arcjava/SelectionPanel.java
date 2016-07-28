package arcjava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectionPanel extends JPanel {

	// This is the JPanel which handles the initial screen of the program, where the user selects whether to create a new item or select
	// an existing item to use as a base.  This panel is composed of two subpanels - leftPanel and rightPanel.  leftPanel is
	// always visible and controls which panel is shown on rightPanel via a pair of radio buttons which activate their corresponding panel.	
	
	public SelectionPanel() {
		
		JPanel leftPanel = new JPanel();
		
		leftPanel.setSize(300, 400);
		leftPanel.setLayout(new GridLayout(3, 1));
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		ButtonGroup neGroup = new ButtonGroup();
		JRadioButton newRad = new JRadioButton("New");
		neGroup.add(newRad);
		JRadioButton existingRad = new JRadioButton("Existing");
		neGroup.add(existingRad);
		JLabel neTitle = new JLabel("Create a New Item or Select an Existing Item");
		
		leftPanel.add(neTitle);
		leftPanel.add(newRad);
		leftPanel.add(existingRad);
		
		leftPanel.setVisible(true);	
		
		NewPanel newPanel = new NewPanel(); // COGNITIVE DISSONANCE, HO!
		newPanel.setVisible(false);
		
		ExistingPanel existingPanel = new ExistingPanel();
		existingPanel.setVisible(false);
		
		ActionListener newListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPanel.setVisible(true);
				existingPanel.setVisible(false);
			}		
		};
		
		ActionListener existingListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPanel.setVisible(false);
				existingPanel.setVisible(true);
			}		
		};
		
		newRad.addActionListener(newListener);
		existingRad.addActionListener(existingListener);
		
		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(newPanel);
		this.add(existingPanel);
		
		this.setVisible(true);
	}
	
}

final class NewPanel extends JPanel {
	
	NewPanel() {
		
		this.setSize(500, 400);
		this.setLayout(new GridLayout(5, 1));
		
		JLabel userLabel = new JLabel("Name");
		JTextField userLine = new JTextField("Name, max 10 characters", 20);
		
		JLabel descLabel = new JLabel("Description");
		JTextField descLine = new JTextField("Description, max 50 characters",20);
		
		JButton newButton = new JButton("Create Item");
		
		// TODO: add functionality for the button
		ActionListener nButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}		
		};
		
		newButton.addActionListener(nButtonListener);
		
		this.add(userLabel);
		this.add(userLine);
		this.add(descLabel);
		this.add(descLine);
		this.add(newButton);
		
	}
	
}

final class ExistingPanel extends JPanel {
	
	ExistingPanel() {
		
		this.setSize(500, 400);
		this.setLayout(new GridLayout(5, 1));
		
		JLabel existingLabel = new JLabel("Select Item");
		
		// TODO: swap out Strings for dual-String type (may have to hard code it)
		String[] itemNames = {"F0006", "F0016WORLD", "F0101", "F01012", "F0311A"};
		JComboBox existingList = new JComboBox(itemNames);
		existingList.setBackground(Color.white);
		
		// TODO: add ComboBox functionality (is this even necessary?)
		ActionListener eComboListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}		
		};
		
		existingList.addActionListener(eComboListener);
		
		JButton existingButton = new JButton("Select Item");
		
		// TODO: add button functionality
		ActionListener eButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}		
		};
		
		JLabel selectedName = new JLabel("");
		JLabel selectedDesc = new JLabel("");
		
		this.add(existingLabel);
		this.add(existingList);
		this.add(existingButton);
		this.add(selectedName);
		this.add(selectedDesc);
				
	}	
}