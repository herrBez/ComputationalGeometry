package geometry.computational.convexhull;

import geometry.computational.*;

import java.util.*;
import java.lang.Math;

/**
 * A good explanation of the algorithm
 * http://www.cs.wustl.edu/~pless/506/l3.html
 * 
 * TODO: find the correct implementation to find the lower/Upper tangent
 */
public class DivideEtImperaConvexHullGenerator implements ConvexHullGenerator {
	private LeftToRightComparator ltrc;
	
	public DivideEtImperaConvexHullGenerator(){
		ltrc = new LeftToRightComparator();
	}
	
	@Override
    public Polygon generateConvexHull(Polygon polygon) {
		Point[] p = (Point[]) polygon.getVertices().toArray(new Point[polygon.getList().size()]);

		Arrays.sort(p, new LeftToRightComparator());	
		List<Point> lp = generateConvexHullRec(new CircularList<Point>(Arrays.asList(p)));
		System.out.println("Merge" + lp);

		Point[] help = new Point[lp.size()];
		for(int i = 0; i < lp.size(); i++){
			help[i] = lp.get(i);
		}
		
		return new Polygon(help);
		
	}
	
	
	private CircularList<Point> generateConvexHullRec(CircularList<Point> lp){
		int n = lp.size();
		if(n < 3)
			return lp;
		if(n == 3) {
			/* In order to grant the counterclockwise order */
			if(Library.angleLeft(lp.get(0), lp.get(1), lp.get(2)) < 0) 
				Collections.swap(lp, 1, 2);
			return lp;
		}
		int mid = (int)Math.floor(n/2);
		CircularList<Point> leftList = new CircularList<Point>(lp.subList(0, mid));
		CircularList<Point> rightList = new CircularList<Point>(lp.subList(mid, n));
		
		CircularList<Point> leftConvexHull = generateConvexHullRec(leftList);
		CircularList<Point> rightConvexHull = generateConvexHullRec(rightList); 
		return merge(leftConvexHull, rightConvexHull);
	}
	
	
	
	private CircularList<Point> merge(CircularList<Point> leftList, CircularList<Point> rightList){
		
		System.out.println("[Merge] Merging " + leftList + " with " + rightList); 
		
		int R = getRightMostIndex(leftList.toArray(new Point[leftList.size()]));
		int L = getLeftMostIndex(rightList.toArray(new Point[rightList.size()]));
		
		int r = R;
		int l = L;
		
		System.out.println("[Merge ] Starting R=r=" + leftList.get(r) + " L=l=" + rightList.get(l));
		
		/* Finding lower tangent */
		int nLeftList = leftList.size();
		int nRightList = rightList.size();
		
		if(nLeftList > 1 || nRightList > 1){
			while((Library.angleLeft(rightList.get(l), leftList.get(r), leftList.getPrec(r)) > 0) &&
					(leftList.get(r).getY() > leftList.getNext(r).getY() ||
					leftList.get(r).getY() > leftList.getPrec(r).getY()) 
					||
					(Library.angleLeft(leftList.get(r), rightList.get(l), rightList.getNext(l)) > 0) &&
					(rightList.get(l).getY() > rightList.getNext(l).getY() ||
					rightList.get(l).getY() > leftList.getPrec(l).getY())){
					
					
					
				while((Library.angleLeft(rightList.get(l), leftList.get(r), leftList.getPrec(r)) > 0) &&
					(leftList.get(r).getY() > leftList.getNext(r).getY() ||
					leftList.get(r).getY() > leftList.getPrec(r).getY())) {
							r = (r - 1 + nLeftList) % nLeftList;
				}
				while((Library.angleLeft(leftList.get(r), rightList.get(l), rightList.getNext(l)) > 0) &&
					(rightList.get(l).getY() > rightList.getNext(l).getY() ||
					rightList.get(l).getY() > leftList.getPrec(l).getY())) {			
						l = (l + 1) % nRightList;
				}
			}
		}
		
		//}
		/* Finding upper tangent */
		
		if(nLeftList > 1 || nRightList > 1){
		
			while((Library.angleLeft(leftList.get(R), rightList.get(L), rightList.getPrec(L)) > 0 &&
						(rightList.get(L).getY() < rightList.getNext(L).getY() ||
						rightList.get(L).getY() < rightList.getPrec(L).getY())) 
						||
				(Library.angleLeft(rightList.get(L), leftList.get(R), leftList.getNext(R)) < 0 &&
						(leftList.get(R).getY() < leftList.getNext(R).getY() ||
						leftList.get(R).getY() < leftList.getPrec(R).getY()))){
					
				
				while((Library.angleLeft(leftList.get(R), rightList.get(L), rightList.getPrec(L)) > 0) &&
						(rightList.get(L).getY() < rightList.getNext(L).getY() ||
						rightList.get(L).getY() < rightList.getPrec(L).getY())) {
						
						L = (L - 1 + nRightList) % nRightList;
					
				}
				while((Library.angleLeft(rightList.get(L), leftList.get(R), leftList.getNext(R)) > 0) &&
						(leftList.get(R).getY() < leftList.getNext(R).getY() ||
						leftList.get(R).getY() < leftList.getPrec(R).getY())) {
						
						R = (R + 1) % nLeftList;
					
				}
			}
		}
		
		System.out.println("[Merge] Upper Left " + leftList.get(R) + " Upper Right " + rightList.get(L));
		System.out.println("[Merge] Lower Left " + leftList.get(r) + " Lower Right " + rightList.get(l));

		
		CircularList<Point> result = new CircularList<>();
		int i = (R+1)%nLeftList;
		int j = l;
		/* N.B. Point R and r of leftList and L and l of rightList belongs to the merged convexHull */
		while(!leftList.get(i).equals(leftList.getNext(r))){
			result.add(leftList.get(i));
			i = (i + 1) % nLeftList;
		}
		
		while(!rightList.get(j).equals(rightList.getNext(L))){
			result.add(rightList.get(j));
			j = (j + 1) % nRightList;
		}
		
		result.add(leftList.get(R));
	
		return result;
	}
	
	
	private String ArrayToString(Point [] p){
		return Arrays.asList(p).toString();
	}
	
	
	
	
	private static Point getPrec(int i, Point [] a){
		return a[(i - 1 + a.length) % a.length];
	}
	private static Point getNext(int i, Point [] a){
		return a[(i + 1) % a.length];
	}
	
	/**
	 * O(n) find the rightmost point of CH i-1.
	 */
	private int getRightMostIndex(Point [] array){
		int index = 0;
		Point max = array[0];
		for(int i = 1; i < array.length; i++){
			if(ltrc.compare(max, array[i]) < 0){
				max = array[i];
				index = i; 
			}
		}
		return index;
	}
	private int getLeftMostIndex(Point [] array){
		int index = 0;
		Point max = array[0];
		for(int i = 1; i < array.length; i++){
			if(ltrc.compare(max, array[i]) > 0){
				max = array[i];
				index = i; 
			}
		}
		return index;
	}
}
