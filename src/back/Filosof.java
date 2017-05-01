package back;

import front.FilosofVisible;

public class Filosof implements Runnable{
	private Fork leftFork;
	private Fork rightFork;
	public int countEating = 0;
	private int idFilosof;
	private static volatile int ready = 5;
	private final FilosofVisible filosofVisible;
	public Filosof(FilosofVisible filosofVisible, int idFilosof) {
		leftFork = new Fork(1);
		rightFork = new Fork(2);
		this.idFilosof = idFilosof;
		this.filosofVisible = filosofVisible;
		System.out.println("Create filosof " + this.idFilosof + "; Leftfork = " + leftFork.idFork + ", RightFork = " + rightFork.idFork);
	}
	
	public Filosof(FilosofVisible filosofVisible, int IdFilosof, final Fork left, final Fork right) {
		leftFork = left;
		rightFork = right;
		this.idFilosof = IdFilosof;
		this.filosofVisible = filosofVisible;
		System.out.println("Create filosof " + this.idFilosof + "; Leftfork = " + leftFork.idFork + ", RightFork = " + rightFork.idFork);
	}
	
	public Fork getLeftFork() {
		return leftFork;
	}
	
	public Fork getRightFork() {
		return rightFork;
	}
	
	public void startEat() {
		if (idFilosof == 1 || idFilosof == 3) {
			System.out.println("Statr wait" + idFilosof);
			while (ready > 2);
			System.out.println("Statr resume" + idFilosof);
			synchronized(leftFork) {
				synchronized(rightFork) {
					--ready;
					while (ready > 0);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {}
				}
			}
		}
		else {	
			System.out.println("Statr " + idFilosof);
			try {
				synchronized(leftFork) {
				--ready;
				System.out.println("Thread " + idFilosof + " sleep");
				leftFork.wait();
				}
			} catch (InterruptedException e) {}
		}
	}
	
	
	
	
	@Override
	public void run() {
		System.out.println("run " + idFilosof);
		startEat();
		Thread currentThread = Thread.currentThread();
		while(true) {
			System.out.println("while " + idFilosof);
			try {
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("Filosof " + idFilosof + ", eating count " + countEating);
					return;
				}
					
				Thread.sleep(500);
			
			synchronized (leftFork) {
				System.out.println("leftFork synch " + idFilosof);
				synchronized(rightFork) {
					
					
					System.out.println("rightFork synch " + idFilosof);
					filosofVisible.eatingFilosof();
					++countEating;
					Thread.sleep(500);
					rightFork.notify();
				}
				
				
				
				
					
					
					System.out.println("wait in leftFork synch " + idFilosof);
					filosofVisible.thinkFilosof();
					leftFork.wait();
				
			}
			} catch (InterruptedException e) {}
		}
		
	}
}
