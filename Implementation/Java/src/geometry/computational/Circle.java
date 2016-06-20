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
	
	public boolean isConcentric(Circle o){
		return c.equals(o.c);
	}
	
	private int square(int val){
		return val*val;
	}
	
	public boolean isTangent(Circle o){
		int d = c.sqrDistanceFrom(o.c);
		int r1 = r;
		int r2 = o.r;
		return d == square(r1+r2);
	}
	public boolean isExtern(Circle o){
		int d = c.sqrDistanceFrom(o.c);
		int r1 = r;
		int r2 = o.r;
		
		return d > square(r1) && d > square(r2);
	}
	
	public boolean intersectCircle(Circle o){
		int r1 = r;
		int r2 = o.r;
		if(isConcentric(o)) {
			System.out.println("Concenctric ");
			return r1 == r2;
		}
		if(isTangent(o)){
			System.out.println("Tangent ");
			return true;
		}
		if(isExtern(o)) {
			System.out.println("Extern ");

			int d = c.sqrDistanceFrom(o.c);
			if(d > square(r1) && d > square(r2))
				return d < square(r1+r2);
			return false;
		} 
		System.out.println("Not concentric nor tangent nor extern ");

		//is intern and not concentric!
		int d = c.sqrDistanceFrom(o.c);
		System.out.println("Square distance = " + d);
		System.out.println("Square of (" + r1 + "+" + r2 + ") is " + square(r1+r2));
		System.out.println("Square of (" + r1 + "-" + r2 + ") is " + square(r1-r2));

		return d < square(r1-r2);
	}

}
