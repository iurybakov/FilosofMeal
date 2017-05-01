package back;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

import front.FilosofVisible;

public class RoundTable extends JPanel {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7333043668412738647L;
	private final LinkedList<Filosof> listFilosofs = new LinkedList<Filosof>();
	private FilosofVisible[] arrFilosofVisible;
	public RoundTable() {
		short countFilosof = 5;
		FilosofVisible[] arrFilosofVisible = {
				new FilosofVisible(this, 300, 50, 80, 80), 
				new FilosofVisible(this, 420, 150, 80, 80), 
				new FilosofVisible(this, 380, 290, 80, 80),
				new FilosofVisible(this, 220, 290, 80, 80),
				new FilosofVisible(this, 180, 150, 80, 80)
				
//				new FilosofVisible(this, 180, 150, 80, 80), 
//				new FilosofVisible(this, 420, 150, 80, 80), 
//				new FilosofVisible(this, 220, 290, 80, 80), 
//				new FilosofVisible(this, 380, 290, 80, 80)
		};
		this.arrFilosofVisible = arrFilosofVisible;
		listFilosofs.add(new Filosof(arrFilosofVisible[0], 1));
		
		for(int i = 2; i < countFilosof; i++)			
			listFilosofs.add(new Filosof(arrFilosofVisible[i - 1], i, listFilosofs.getLast().getRightFork(), new Fork(i+1)));
		
		listFilosofs.add(new Filosof(arrFilosofVisible[4], countFilosof, listFilosofs.getLast().getRightFork(), listFilosofs.getFirst().getLeftFork()));
		ArrayList<Thread> threadFilosofs = new ArrayList<Thread>();
		for (Filosof f : listFilosofs) {
			Thread tmpThread = new Thread(f);
			tmpThread.start();
			threadFilosofs.add(tmpThread);
			
		}
	
		
		
		
//		try {
//			Thread.sleep(1000000);
//		} catch (InterruptedException e) {}
//		
//		for (Thread t : threadFilosofs) {
//			System.out.println("interupt-------------------------------------------");
//			t.interrupt();
//		}
	}
	
	
	
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		
		Graphics2D g2d = (Graphics2D)g;
		for (FilosofVisible f : arrFilosofVisible) {
			g2d.setPaint(f.getPaint());
			g2d.fill(f);
		}
	}



}
