package back;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import front.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import front.FilosofVisible;
import front.ForkVisible;

public class RoundTable extends JPanel {	

	private static final long serialVersionUID = 7333043668412738647L;
	private final LinkedList<Filosof> listFilosofs = new LinkedList<Filosof>();
	private FilosofVisible[] arrFilosofVisible = new FilosofVisible[5];
	private JLabel[] arrCountEating = new JLabel[5];
	private ForkVisible[] arrForkVisible = new ForkVisible[5];
	public RoundTable() {
		short countFilosof = 5;
		
		int j = 0;
		for (int i = 0; i < 5; i++) {
			this.add(arrCountEating[i] = new JLabel("0"));
			double x1 = -120 * Math.sin(2 * Math.PI / 5 * (i + 1)) + 300;
			double y1 = -120 * Math.cos(2 * Math.PI / 5 * (i + 1)) + 200;
			arrFilosofVisible[i] = new FilosofVisible(this, x1, y1, 80, 80);
			x1 = 100 * Math.sin(2 * Math.PI / 5 * (i + 1)) + 340;
			y1 = 100 * Math.cos(2 * Math.PI / 5 * (i + 1)) + 240;
			double x2 = 60 * Math.sin(2 * Math.PI / 5 * (i + 1)) + 340;
			double y2 = 60 * Math.cos(2 * Math.PI / 5 * (i + 1)) + 240;
			arrForkVisible[i] = new ForkVisible(x1, y1, x2, y2);			
			
			x1 = 100 * Math.sin(2 * Math.PI / 20 * (j + 3)) + 340;
			y1 = 100 * Math.cos(2 * Math.PI / 20 * (j + 3)) + 240;
			x2 = 60 * Math.sin(2 * Math.PI / 20 * (j + 3)) + 340;
			y2 = 60 * Math.cos(2 * Math.PI / 20 * (j + 3)) + 240;	
			arrForkVisible[i].setRightTakePoint(new Point(x1, y1), new Point(x2, y2));
			
			x1 = 100 * Math.sin(2 * Math.PI / 20 * (j + 5)) + 340;
			y1 = 100 * Math.cos(2 * Math.PI / 20 * (j + 5)) + 240;
			x2 = 60 * Math.sin(2 * Math.PI / 20 * (j + 5)) + 340;
			y2 = 60 * Math.cos(2 * Math.PI / 20 * ((j + 5) > 20 ? 1 : (j + 5))) + 240;	
			arrForkVisible[i].setLeftTakePoint(new Point(x1, y1), new Point(x2, y2));
			j += 4;
			
		}
		listFilosofs.add(new Filosof(arrFilosofVisible[0], 1, new Fork(arrForkVisible[2], 1), new Fork(arrForkVisible[3], 2)));
		int arrIndex[] = { 4, 0, 1 };
		for(int i = 2; i < countFilosof; i++)			
			listFilosofs.add(new Filosof(arrFilosofVisible[i - 1], i, listFilosofs.getLast().getRightFork(), new Fork(arrForkVisible[arrIndex[i - 2]], i + 1)));
		
		listFilosofs.add(new Filosof(arrFilosofVisible[4], countFilosof, listFilosofs.getLast().getRightFork(), listFilosofs.getFirst().getLeftFork()));
		ArrayList<Thread> threadFilosofs = new ArrayList<Thread>();
		for (Filosof f : listFilosofs) {
			Thread tmpThread = new Thread(f);
			tmpThread.start();
			threadFilosofs.add(tmpThread);			
		}
	}	
	
	public void setEatingCount(int idFilosof, int countEating) {
		arrCountEating[idFilosof - 1].setText("_" + countEating + "_");
	}	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		for (int i = 0; i < 5; i++) {
			g2d.setPaint(Color.BLACK);
			g2d.draw(arrForkVisible[i]);
			g2d.setPaint(arrFilosofVisible[i].getPaint());
			g2d.fill(arrFilosofVisible[i]);			
		}
	}
}
