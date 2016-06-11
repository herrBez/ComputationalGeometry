package geometry.computational;

import java.util.*;
import geometry.computational.*;
/**
 * Comparator that implements the exercise 4 
 * 
 * 
 */
public class PolarAngleComparatorPoint implements Comparator<Point> {
	Point o;
	
	public PolarAngleComparatorPoint(Point _o){
		o = _o;
	}
	@Override
	public int compare(Point p, Point q) {
		int d = Library.angleLeft(o, p, q);
		return d;
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
