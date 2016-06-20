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
		setX(x);
	}

	public void setX(int x) {
		this.sweepX = x;
	}

	/** Assuming no segment is a point */
	public int compare(Segment s1, Segment s2) {
	
		if(s1.equals(s2))
			return 0;
		Point p1 = s1.getLeft();
		Point p2 = s1.getRight();
		Point p3 = s2.getLeft();
		Point p4 = s2.getRight();
		
		int x1 = p1.getX();
		int y1 = p1.getY();
		int x3 = p3.getX();
		int y3 = p3.getY();
		
		if(x1 == x3) {
			return y1 - y3;
		}
		if(x1 > x3){
			int d = Library.angleLeft(p3, p4, p1);
			return d;
		} else {
			int d = Library.angleLeft(p1, p2, p3);
			return d;
		}
	}

}
