package geometry.computational;

/**
 * 
 */
public class Circle {
	private int r;
	private Point c;
	
	public Circle(Point _c, int _r){
		c = _c;
		r = _r;
	}
	public Circle(int x0, int y0, int r){
		this(new Point(x0, y0), r);
	}
	
	public Point getCenter(){
		return c;
	}
	public int getRay(){
		return r;
	}
}
