package geometry.computational.comparator;

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
	public PolarAngleComparatorPoint(){
		o = new Point(0,0);
	}
	public void setOrigin(Point _o){
		o = _o;
	}
	/**
	 * @Return Negative Integer if p < q
	 * 		   0 if p == q
	 * 		   Positive Integer if p > q
	 */
	public int compare(Point p, Point q){
		if(p.equals(q))
			return 0;
		int xp = p.getX(); int yp = p.getY();
		int xo = o.getX(); int yo = o.getY();
		int xq = q.getX(); int yq = q.getY();
		if((yp - yo)*(yo - yq) > 0){
			if(yp > yq) {
				return -1;
			} else {
				return 1;
			}
		}
		int d = Library.angleLeft(o, p, q);
		if(d > 0){
			return -1;
		} else if(d < 0){
			return 1;
		}
		/* They are collinear */
		/* In order to check p----o----q or q-----o-----p */
		if((xp - xo)*(xo - xq) > 0) { // They lies on different parts
			if(xp > xq) {
				return -1;
			}
			else {
				return 1;
			}
		}
		int dxp = (xp - xo); int dyp = (yp - yo);
		int dxq = (xq - xo); int dyq = (yq - yo);
		int lp = dxp * dxp + dyp * dyp;
		int lq = dxq * dxq + dyq * dyq;
		return lp - lq; //
	}
	
	
	@Override
	public boolean equals(Object obj) {
		PolarAngleComparatorPoint pacp = (PolarAngleComparatorPoint)obj;
		return o.equals(pacp.o);
	}
}
