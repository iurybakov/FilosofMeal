package front;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;



public class ForkVisible extends Line2D {

	private double x1;
	private double x2;
	private double y1;
	private double y2;
	private Point p1;
	private Point p2;
	
	private Point leftTakePoint1;
	private Point leftTakePoint2;
	private Point rightTakePoint1;
	private Point rightTakePoint2;
	
	public enum Position { left, right }
	
	
	
	
	public ForkVisible(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		p1 = new Point(this.x1, this.y1);
		p2 = new Point(this.x2, this.y2);
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
	
	public void setLeftTakePoint(Point p1, Point p2) {
		leftTakePoint1 = p1;
		leftTakePoint2 = p2;
	}
	
	public void setRightTakePoint(Point p1, Point p2) {
		rightTakePoint1 = p1;
		rightTakePoint2 = p2;
	}
	
	public void takeFork(Position pos) {
		Point p1, p2;
		if (pos == Position.left) {
			p1 = leftTakePoint1;
			p2 = leftTakePoint2;
		}
		else {
			p1 = rightTakePoint1;
			p2 = rightTakePoint2;
		}
		this.x1 = p1.getX();
		this.x2 = p2.getX();
		this.y1 = p1.getY();
		this.y2 = p2.getY();
	}
	
	public void putFork() {
		this.x1 = p1.getX();
		this.x2 = p2.getX();
		this.y1 = p1.getY();
		this.y2 = p2.getY();
	}

}
