package back;

public class Fork {
	private volatile boolean station = false;
	
	
	public int idFork;
	
	public Fork(int id) {
		idFork = id;
	}
	
	public boolean isReady() {
		return station;
	}
	
	public synchronized void setStation(boolean station) {
		this.station = station;
	}
}
