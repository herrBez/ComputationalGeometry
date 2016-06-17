package geometry.computational.convexhull;

import geometry.computational.Point;
import geometry.computational.Polygon;
import geometry.computational.Segment;
import geometry.computational.SortablePoint;

import java.util.ArrayList;

/**
 */
public class JarvisConvexHullGenerator implements ConvexHullGenerator {

	public Polygon generateConvexHull(Polygon polygon) {
		Point[] vertices = (Point[]) polygon.getVertices().toArray();
		Point bottomLeftCorner = polygon.getVertices().get(0);
		for (Point p : vertices)
			if (p.getY() <= bottomLeftCorner.getY()
					&& p.getX() < bottomLeftCorner.getX())
				bottomLeftCorner = p;
		Point topRightCorner = polygon.getVertices().get(0);
		for (Point p : vertices)
			if (p.getY() >= topRightCorner.getY()
					&& p.getX() > topRightCorner.getX())
				topRightCorner = p;
		ArrayList<Point> hullPoints = new ArrayList<Point>();
		Point current = bottomLeftCorner;
		hullPoints.add(current);
		while (current != topRightCorner) {
			current = minPolarRight(vertices, current);
			hullPoints.add(current);
		}
		current = minPolarLeft(vertices, current);
		while (current != bottomLeftCorner) {
			hullPoints.add(current);
			current = minPolarLeft(vertices, current);
		}
		ArrayList<Segment> hullSegments = new ArrayList<Segment>();
		for (int i = 0; i < hullPoints.size(); i++)
			hullSegments.add(new Segment(hullPoints.get(i), hullPoints
					.get((i + 1) % hullPoints.size())));
		return new Polygon(hullSegments);
	}

	private Point minPolarRight(Point[] points, Point origin) {
		Point first = points[0];
		SortablePoint min = SortablePoint.createSortablePoint(first.getX(),
				first.getY(), origin);
		for (int i = 0; i < points.length; i++) {
			SortablePoint current = SortablePoint.createSortablePoint(
					points[i], origin);
			if (current.compareTo(min) < 0)
				min = current;
		}
		return min;
	}

	private Point minPolarLeft(Point[] points, Point origin) {
		Point first = points[0];
		SortablePoint min = SortablePoint.createSortablePoint(first.getX(),
				first.getY(), origin);
		for (int i = 0; i < points.length; i++) {
			SortablePoint current = SortablePoint.createSortablePoint(
					points[i], origin);
			if ((current.getY() - origin.getY()) * (origin.getY() - min.getY()) > 0
					&& current.getY() < min.getY())
				min = current;
			else if (current.getY() == min.getY()
					&& current.getX() <= origin.getX()
					&& origin.getX() <= min.getX())
				min = current;
			else if (current.compareTo(min) < 0)
				min = current;
		}
		return min;
	}
}
