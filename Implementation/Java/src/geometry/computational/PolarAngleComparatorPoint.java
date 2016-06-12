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
		int xp = p.getX(); int yp = p.getY();
		int xo = o.getX(); int yo = o.getY();
		int xq = q.getX(); int yq = q.getY();
		if(d > 0){
			if(yp <= yo && yq >= yo){
				return 1;
			}
			return -1;
		} else if(d == 0){//p and q collinear
				int dxp = (xp - xo); int dyp = (yp - yo);
				int dxq = (xq - xo); int dyq = (yq - yo);

			if((dxp * dxq >= 0) && (dyp * dyq >= 0)){ //They lie on the same part
				/* Checking the length of the vector with respect to O */
				int lp = dxp * dxp + dyp * dyp;
				int lq = dxq * dxq + dyq * dyp;
				if(lp > lq) { // p > q
					return 1;
				}
				else if(lp == lq) { //p == q
					return 0;
				}
				else {
					return -1; // p < q
				}
			} else {
				if(xp >= xq && yp >= yq) { //p lies in the I quadrante
					return -1; // p < q
				}
				else if(xp >= xq && yp <= yq) { //p lies in the IV quadrante
					return 1;
				}
				else if(xp <= xq && yp >= yq){ //p lies in the II qudrante
					return -1; // p > q
				} 
				else {//xp <= xq && yp <= yq p lies in the III quadrante
					return 1;
				}
			} 
		} else { //d < 0
			if(yq <= yo && yp >= yo){
				return -1;
			}
			return 1;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
