package back;

import front.FilosofVisible;
import front.ForkVisible;

public class Filosof implements Runnable {
	private Fork leftFork;
	private Fork rightFork;
	public int countEating = 0;
	private int idFilosof;
	private final FilosofVisible filosofVisible;
	
	public Filosof(FilosofVisible filosofVisible, int IdFilosof, final Fork left, final Fork right) {
		leftFork = left;
		rightFork = right;
		this.idFilosof = IdFilosof;
		this.filosofVisible = filosofVisible;
	}
	
	public Fork getLeftFork() {
		return leftFork;
	}
	
	public Fork getRightFork() {
		return rightFork;
	}
	
	public void startEat() {		
		try {			
			synchronized(leftFork) {
				leftFork.wait(idFilosof == 1 || idFilosof == 3 ? 2000 : 0);				
			}
		} catch (InterruptedException e) {e.printStackTrace();}
	}	
	
	@Override
	public void run() {
		int delay = 400;
		startEat();
		while(true) {			
			try {					
				Thread.sleep(delay);
			
				synchronized (leftFork) {
					leftFork.takeFork(ForkVisible.Position.left);
					filosofVisible.readyFilosof();
					Thread.sleep(delay);
					synchronized(rightFork) {
						rightFork.takeFork(ForkVisible.Position.right);					
						filosofVisible.eatingFilosof(idFilosof, ++countEating);
						Thread.sleep(delay);
						rightFork.notify();
					}
					
					rightFork.putFork();					
					filosofVisible.thinkFilosof();
					Thread.sleep(delay);
					leftFork.putFork();
					filosofVisible.thinkFilosof();
					leftFork.wait();
					
				}
			} catch (InterruptedException e) {e.printStackTrace();}
		}		
	}
}
