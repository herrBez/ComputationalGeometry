package geometry.computational.convexhull;

import geometry.computational.Library;
import geometry.computational.Point;
import geometry.computational.Polygon;
import geometry.computational.Segment;
import geometry.computational.comparator.PolarAngleComparatorPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Stack;

/**
 */
public class GrahamConvexHullGenerator implements ConvexHullGenerator {

	private Stack<Point> stack = new Stack<Point>();
	private PolarAngleComparatorPoint pacp = new PolarAngleComparatorPoint();

	public Polygon generateConvexHull(Polygon polygon) {
        Point[] vertices = (Point[]) polygon.getVertices().toArray();
        Point bottomLeftCorner = polygon.getVertices().get(0);
        for(Point p : vertices)
            if(p.getY() <= bottomLeftCorner.getY() &&
                    p.getX() < bottomLeftCorner.getX())
                bottomLeftCorner = p;
        pacp.setOrigin(bottomLeftCorner);
        Arrays.sort(vertices, pacp);
        stack.push(bottomLeftCorner);
        for(int i = 0; i < vertices.length; i++) {
            Point top = stack.peek();
            Point nextToTop = peekNextToTop();
            stack.push(top);
            while(nextToTop != null &&
                    Library.turnLeft(nextToTop, top, vertices[i]) <= 0) {
                stack.pop();
                top = nextToTop;
                nextToTop = peekNextToTop();
            }
            stack.push(vertices[i]);
        }
        Point[] hullVertices = new Point[stack.size()];
        //TODO
        //Is not used.. Is it coorect ListIterator<Point> iterator = stack.listIterator();
        for(int i = 0; i < stack.size(); i++)
            hullVertices[i] = stack.pop();
        ArrayList<Segment> hullSegments = new ArrayList<Segment>();
        for(int i = 0; i < hullVertices.length; i++)
            hullSegments.add(new Segment(hullVertices[i],
                    hullVertices[(i+1)%hullVertices.length]));
        Polygon convexHull = new Polygon(hullSegments);
        return convexHull;
    }

	private Point peekNextToTop() {
		Point top = stack.pop();
		Point point = null;
		try {
			point = stack.peek();
		} finally {
			stack.push(top);
			return point;
		}
	}
}
