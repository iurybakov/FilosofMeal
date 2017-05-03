package back;

import front.ForkVisible;

public class Fork {
	private volatile boolean station = false;	
	private final ForkVisible forkVisible;	
	public int idFork;
	
	public Fork(ForkVisible forkVisible, int id) {
		idFork = id;
		this.forkVisible = forkVisible;
	}
	
	public boolean isReady() {
		return station;
	}
	
	public synchronized void setStation(boolean station) {
		this.station = station;
	}
	
	public void takeFork(ForkVisible.Position pos) {
		forkVisible.takeFork(pos);
	}
	
	public void putFork() {
		forkVisible.putFork();
	}
}