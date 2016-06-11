package geometry.computational;

import java.util.List;

/**
 * 
 */
public class Point {
	public final int x;
	public final int y;
	
	public Point(int _x, int _y){
		x = _x;
		y = _y;
	}

	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}

	@Override
	public boolean equals(Object obj){
		Point p = (Point) obj;
		return this.x == p.x && this.y == p.y;
	}
	
	

	public boolean segmentIntersectRightHalfLine(Segment s) {
        Point horizon = new Point(Library.CMAX, y);
        Segment s1 = new Segment(this, horizon);
        return Library.segments_intersect(s, s1);
	}

    public boolean isInside(Polygon polygon) {
        int intersections = 0;
        List<Segment> segments = polygon.getList();
        List<Point> vs = polygon.getVertices();
        Point[] vertices = (Point[]) vs.toArray();
        for (Segment s : segments)
            if(this.isInside(s))
                return true;
        for (int i = 0; i < vertices.length; i++) {
            Point curr = vertices[i];
            Point pred = vertices[(i-1)%vertices.length];
            Point foll = vertices[(i+1)%vertices.length];
            if((curr.getY() - pred.getY()) * (foll.getY() - curr.getY()) > 0)
                intersections++;
            if (curr.getY() == foll.getY() && foll.getY() == y)
                intersections++;
        }
        for (Segment s : segments) {
            if (segmentIntersectRightHalfLine(s))
                intersections++;
        }
        return (intersections%2 == 1);
    }

    public boolean isInside(Segment segment) {
        Point p1 = segment.getP1();
        Point p2 = segment.getP2();
        if(Library.angleLeft(this, p1, p2) != 0)
            return false;
        if((x - p1.getX()) * (x - p2.getX()) > 0)
            return false;
        if((y - p1.getY()) * (y - p2.getY()) > 0) // TODO: is it necessary?
            return false;
        return true;
    }
}
