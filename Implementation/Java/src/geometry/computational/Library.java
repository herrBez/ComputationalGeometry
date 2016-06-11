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
		int x1 = p1.getX(); int y1 = p1.getY();
		int x2 = p1.getX(); int y2 = p1.getY();
		int x3 = p1.getX(); int y3 = p1.getY();
		int x4 = p1.getX(); int y4 = p1.getY();
		if(d1 == 0 && d2 == 0 && d3 == 0 && d4 == 0){
			boolean a = (x2 - x3) * (x1 - x3) <= 0 &&  (y2 - y3) * (y1 - y3) <= 0;
			boolean b = (x2 - x4) * (x1 - x4) <= 0 &&  (y2 - y4) * (y1 - y4) <= 0;
			boolean c = (x4 - x1) * (x3 - x1) <= 0 &&  (y4 - y1) * (y3 - y1) <= 0;
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
