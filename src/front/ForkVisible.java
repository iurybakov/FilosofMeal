package front;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ForkVisible extends Line2D {

	private double x1;
	private double x2;
	private double y1;
	private double y2;
	Point p1;
	Point p2;
	
	public ForkVisible() {
		
	}
	
	@Override
	public Rectangle2D getBounds2D() {
		return null;
	}

	@Override
	public Point2D getP1() {
		return p1;
	}

	@Override
	public Point2D getP2() {
		return p2;
	}

	@Override
	public double getX1() {
		return x1;
	}

	@Override
	public double getX2() {
		return x2;
	}

	@Override
	public double getY1() {
		return y1;
	}

	@Override
	public double getY2() {
		return y2;
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public void takeFork() {
		
	}
	
	public void putFork() {
		
	}

}
