package geometry.computational;

import java.util.*;
import geometry.computational.*;
/**
 * Comparator that implements the exercise 4 
 * 
 * 
 */
public class LeftToRightComparator implements Comparator<Point> {
	
	@Override
	public int compare(Point p, Point q){
		if(p.equals(q))
			return 0;
		int xp = p.getX(); int yp = p.getY();
		int xq = q.getX(); int yq = q.getY();
		if(xp < xq) {
			return -1;
		}
		else if(xp > xq) {
			return 1;
		} 
		else {//p and q have the same x coordinate, sorting using y
			if(yp < yq)
				return -1;
			else //they cannot be equal because of the first test
				return 1;
		}
		
	}
	
}
