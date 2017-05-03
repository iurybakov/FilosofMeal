package front;

import javax.swing.*;
import back.RoundTable;

public class MainWindow {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 500);
		frame.setResizable(false);		
		RoundTable table = new RoundTable();		
		frame.add(table);		
		frame.setVisible(true);	
	}
}
