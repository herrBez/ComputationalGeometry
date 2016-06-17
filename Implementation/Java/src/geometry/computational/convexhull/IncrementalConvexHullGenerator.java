package geometry.computational.convexhull;

import geometry.computational.Library;
import geometry.computational.Point;
import geometry.computational.Polygon;
import geometry.computational.comparator.LeftToRightComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class IncrementalConvexHullGenerator implements ConvexHullGenerator {
	public Polygon generateConvexHull(Polygon polygon) {
		Point[] p = (Point[]) polygon.getVertices().toArray(
				new Point[polygon.getList().size()]);
		int n = p.length;

		Arrays.sort(p, new LeftToRightComparator());
		List<Point> CH = new ArrayList<Point>(); // Creating an empty Convex
													// Hull
		CH.add(p[0]);
		/* In order to have a clockwise sorted list */
		if (Library.angleLeft(p[0], p[1], p[2]) > 0) {
			CH.add(p[2]);
			CH.add(p[1]);
		} else {
			CH.add(p[1]);
			CH.add(p[2]);
		}
		System.out.println("After" + CH.toString());

		for (int i = 3; i < n; i++) {
			int j = getRightMostIndex(CH);
			int upperIndex = j;
			int CHSize = CH.size();
			List<Point> toRemoveRefferingToU = new ArrayList<Point>();
			List<Point> toRemoveRefferingToV = new ArrayList<Point>();
			/* Finding the uppest tangent */
			while ((CH.get(upperIndex).getY() < CH.get(
					(upperIndex + 1) % CHSize).getY() || (CH.get(upperIndex)
					.getY() < CH.get((upperIndex - 1 + CHSize) % CHSize).getY()))
					&& Library.angleLeft(p[i], CH.get(upperIndex),
							CH.get((upperIndex - 1 + CHSize) % CHSize)) < 0) {
				if (upperIndex != j) {
					toRemoveRefferingToU.add(CH.get(upperIndex));
				}
				upperIndex = ((upperIndex - 1 + CHSize) % CHSize);
			}
			int lowerIndex = j;
			/* Finding the lowest tangent */
			while ((CH.get(lowerIndex).getY() > CH.get(
					(lowerIndex + 1) % CHSize).getY() || (CH.get(lowerIndex)
					.getY() > CH.get((lowerIndex - 1 + CHSize) % CHSize).getY()))
					&& Library.angleLeft(p[i], CH.get(lowerIndex),
							CH.get((lowerIndex + 1) % CHSize)) > 0) {

				if (lowerIndex != upperIndex) {
					toRemoveRefferingToV.add(CH.get(lowerIndex));

				}
				lowerIndex = ((lowerIndex + 1) % CHSize);
			}

			CH.add((upperIndex + 1) % (CHSize + 1), p[i]);
			for (Point z : toRemoveRefferingToU) {
				CH.remove(z);
			}
			for (Point z : toRemoveRefferingToV) {
				CH.remove(z);
			}
			System.out.println("It " + i + ":" + CH.toString());

		}
		System.out.println("After" + CH.toString());
		return polygon;
	}

	/**
	 * O(n) find the rightmost point of CH i-1.
	 */
	private int getRightMostIndex(List<Point> CH) {
		LeftToRightComparator ltrc = new LeftToRightComparator();
		int index = 0;
		Point max = CH.get(0);
		for (int i = 1; i < CH.size(); i++) {
			if (ltrc.compare(max, CH.get(i)) < 0) {
				max = CH.get(i);
				index = i;
			}
		}
		return index;
	}

}
