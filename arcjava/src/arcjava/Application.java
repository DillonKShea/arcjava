package arcjava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import arcjava.SelectionPanel;

public class Application {
	
	private static void ProgramStart() {
		JFrame frame1 = new JFrame("AS400 Interfacing");
		frame1.setSize(500, 400);
		frame1.setResizable(false);
		frame1.add(new SelectionPanel(), BorderLayout.LINE_START);
		frame1.setVisible(true);
	}
	
	public static void main(String[] args) {
		ProgramStart();
	}
	
}