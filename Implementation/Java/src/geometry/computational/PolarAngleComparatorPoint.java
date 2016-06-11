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
	/**
	 * @Return Negative Integer if p < q
	 * 		   0 if p == q
	 * 		   Positive Integer if p > q
	 */
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
