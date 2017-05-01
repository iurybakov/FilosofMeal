package front;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class FilosofVisible extends Ellipse2D{
	
	private double x;
	private double y;
	private double height;
	private double weight;
	private Color colorFill = Color.BLACK;
	private final JPanel parent;
	
	public FilosofVisible(JPanel parent, double x, double y, double h, double w) {
		this.x = x;
		this.y = y;
		height = h;
		weight = w;
		this.parent = parent;
	}

	@Override
	public Rectangle2D getBounds2D() {
		return null;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public double getWidth() {
		return weight;
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
	public boolean isEmpty() {		
		return height == 0 || weight == 0;
	}

	@Override
	public void setFrame(double x, double y, double w, double h) {
		this.x = x;
		this.y = y;
		height = h;
		weight = w;
	}
	
	public void eatingFilosof() {
		colorFill = Color.BLUE;
		parent.repaint();
	}
	public void thinkFilosof() {
		colorFill = Color.GREEN;
		parent.repaint();
	}
	
	public Color getPaint() {
		return colorFill;
	}
	


}
