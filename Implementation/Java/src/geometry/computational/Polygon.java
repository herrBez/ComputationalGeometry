package geometry.computational;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nate on 11/06/16.
 */
public class Polygon {
	private List<Segment> list;

	public Polygon(List<Segment> _list) {
		list = _list;
	}

	public Polygon(Point... p) {
		int n = p.length;
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Segment(p[i], p[(i + 1) % n]));
		}
	}

	// TODO Add exception
	// Please insert a even number of coordinates
	public Polygon(int... coordinates) {

		int n = coordinates.length / 2;
		Point[] p = new Point[n];
		int j = 0;
		for (int i = 0; i < 2 * n; i += 2) {
			p[j++] = new Point(coordinates[i], coordinates[i + 1]);
		}

		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Segment(p[i], p[(i + 1) % n]));
		}
	}

	public List<Segment> getList() {
		return list;
	}

	public List<Point> getVertices() {
		List<Point> vertices = new ArrayList<>();
		for (Segment s : list)
			vertices.add(s.getP1());
		return vertices;
	}

	/**
	 * Solution of exercise 6
	 */
	public boolean isConvex() {
		Point[] vertices = new Point[list.size()];
		for (int i = 0; i < list.size(); i++)
			vertices[i] = list.get(i).getP1();
		for (int i = 2; i < list.size(); i++) {
			boolean neverTurnsRight = Library.turnLeft(vertices[i - 2],
					vertices[i - 1], vertices[i]) >= 0;
			boolean neverClosesOnItself = Library.angleLeft(vertices[0],
					vertices[i - 1], vertices[i]) >= 0;
			boolean neverGoesOverTheFirstEdge = Library.angleLeft(vertices[0],
					vertices[1], vertices[i]) >= 0;
			if (!neverTurnsRight || !neverClosesOnItself
					|| !neverGoesOverTheFirstEdge)
				return false;
		}
		return true;
	}

}
