package front;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;
import back.RoundTable;

public class MainWindow {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 600);
		
		RoundTable table = new RoundTable();
		
		
		frame.add(table);
		
		frame.setVisible(true);
		
	
	}
	


}
