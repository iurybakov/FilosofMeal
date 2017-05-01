package front;

import java.awt.geom.Point2D;

public class Point extends Point2D{
	
	private double x;
	private double y;
	
	public Point(final double x, final double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double getX() {		
		return x;
	}

	@Override
	public double getY() {	
		return y;
	}

	@Override
	public void setLocation(final double x, final double y) {
		this.x = x;
		this.y = y;
	}

}
