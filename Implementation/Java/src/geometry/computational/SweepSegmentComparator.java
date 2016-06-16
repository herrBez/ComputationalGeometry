package geometry.computational;

import java.util.Comparator;

/**
 * Exercise 9
 */
public class SweepSegmentComparator implements Comparator<Segment>{
	
	public SweepSegmentComparator(){}
	
	public int compare(Segment s, Segment t){
		Point p1 = s.getP1(); Point p2 = s.getP2();
		Point p3 = t.getP1(); Point p4 = s.getP2();
		if(p1.getX() == p3.getX()){
			return p1.getY() - p3.getY();
		}
		if(p1.getX() > p3.getX()){
			int d = Library.angleLeft(p3, p4, p1);
			return d;
		} else {
			int d = Library.angleLeft(p1, p2, p3);
			return -d;
		}
	}
	
}
