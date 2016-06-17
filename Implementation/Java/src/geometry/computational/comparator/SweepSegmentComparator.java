package geometry.computational.comparator;

import geometry.computational.Library;
import geometry.computational.Point;
import geometry.computational.Segment;

import java.util.Comparator;

/**
 * Exercise 9
 */
public class SweepSegmentComparator implements Comparator<Segment> {
	int sweepX;

	public SweepSegmentComparator() {
		sweepX = -Library.CMAX;
	}

	public SweepSegmentComparator(int x) {
		sweepX = x;
	}

	public void setX(int x) {
		this.sweepX = x;
	}

	/** Assuming no segment is a point */
	public int compare(Segment s1, Segment s2) {
		if (s1.equals(s2))
			return 0;
		Point a = s1.getP1();
		Point b = s1.getP2();
		Point c = s2.getP2();
		Point d = s2.getP2();
		int d1 = Library.angleLeft(a, b, c);
		int d2 = Library.angleLeft(a, b, d);
		if ((d1 < 0 && d2 < 0))
			return 1;
		else if ((d1 > 0 && d2 > 0))
			return -1;

		return sweepX;
	}

}
