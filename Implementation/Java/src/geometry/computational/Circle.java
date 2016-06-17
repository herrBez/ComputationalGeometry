package geometry.computational;

/**
 * 
 */
public class Circle {
	private final int r;
	private final Point c;

	public Circle(Point center, int radius) {
		c = center;
		r = radius;
	}

	public Circle(int x0, int y0, int r) {
		this(new Point(x0, y0), r);
	}

	public Point getCenter() {
		return c;
	}

	public int getRadius() {
		return r;
	}
}
