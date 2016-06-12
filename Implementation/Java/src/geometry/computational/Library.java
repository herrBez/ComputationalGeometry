package geometry.computational;



public class Library{

    public final static int CMAX = 10000; // sample value
	/**
	 *
     */
	public static int angleLeft(Point p0, Point p1, Point p2){
		int d = (p1.getX() - p0.getX()) * (p2.getY() - p0.getY()) - (p2.getX() - p0.getX()) * (p1.getY() - p0.getY());
		return d;
	}
	
	public static int turnLeft(Point p0, Point p1, Point p2){
		return angleLeft(p0, p1, p2);
	}
	
	public static boolean segments_intersect(Point p1, Point p2, Point p3, Point p4){
		int d1 = angleLeft(p3, p4, p1);
		int d2 = angleLeft(p3, p4, p2);
		int d3 = angleLeft(p1, p2, p3);
		int d4 = angleLeft(p1, p2, p4);
		if(d1 == 0 && d2 == 0 && d3 == 0 && d4 == 0){
			boolean a = p3.isInside(new Segment(p1,p2));
			boolean b = p4.isInside(new Segment(p1,p2));
			boolean c = p1.isInside(new Segment(p3,p4));
			return a || b || c;
		} else {
			boolean a = (d1 <= 0 && d2 >= 0) || (d1 >= 0 && d2 <= 0);
			boolean b = (d3 <= 0 && d4 >= 0) || (d3 >= 0 && d4 <= 0);
			return a && b;
		}
	}

    public static boolean segments_intersect(Segment s1, Segment s2){
        return segments_intersect(s1.getP1(), s1.getP2(), s2.getP1(), s2.getP2());
    }

}
