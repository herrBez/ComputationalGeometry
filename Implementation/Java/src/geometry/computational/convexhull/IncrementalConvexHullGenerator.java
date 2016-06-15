package geometry.computational.convexhull;

import geometry.computational.*;

import java.util.*;

/**
 */
public class IncrementalConvexHullGenerator implements ConvexHullGenerator {
	@Override
	public Polygon generateConvexHull(Polygon polygon) {
		Point[] p = (Point[]) polygon.getVertices().toArray(new Point[polygon.getList().size()]);
		int n = p.length;
		
		Arrays.sort(p, new LeftToRightComparator());
		List<Point> CH = new ArrayList<>(); //Creating an empty Convex Hull
		CH.add(p[0]);
		/* In order to have a counter clockwise sorted list */
		if(Library.angleLeft(p[0], p[1], p[2]) > 0){
			CH.add(p[2]);
			CH.add(p[1]);
		} else {
			CH.add(p[1]);
			CH.add(p[2]);
		}
		System.out.println("After" + CH.toString());

		for(int i = 3; i < n; i++){
			int j = getRightMostIndex(CH);
			int u = j;
			int l = CH.size();
			List<Point> toRemoveRefferingToU = new ArrayList<>();
			List<Point> toRemoveRefferingToV = new ArrayList<>(); 
			/* Finding the uppest tangent */
			while((CH.get(u).getY() < CH.get((u+1)%l).getY() || (CH.get(u).getY() < CH.get((u-1+l) %l).getY()))
			 && Library.angleLeft(p[i], CH.get(u), CH.get((u-1+l) % l)) < 0){
				if(u != j){
					toRemoveRefferingToU.add(CH.get(u));
				}
				u = ((u - 1 + l) % l);
			}
			int v = j;
			/* Finding the lowest tangent */
			while((CH.get(v).getY() > CH.get((v+1)%l).getY() || (CH.get(v).getY() > CH.get((v-1+l) %l).getY()))
			 && Library.angleLeft(p[i], CH.get(v), CH.get((v+1)%l)) > 0 ){
				
				if(v != u) {
					toRemoveRefferingToV.add(CH.get(v));

				}
				v = ((v + 1) % l);
			}

			CH.add((u+1)%(l+1), p[i]);

			for(Point z : toRemoveRefferingToU){
				CH.remove(z);
			}
			for(Point z : toRemoveRefferingToV){
				CH.remove(z);
			}
			System.out.println("After" + CH.toString());

		} 
		System.out.println("After" + CH.toString());
		return polygon;
	}
	
	private int getRightMostIndex(List<Point> CH){
		LeftToRightComparator ltrc = new LeftToRightComparator();
		int index = 0;
		Point max = CH.get(0);
		for(int i = 1; i < CH.size(); i++){
			if(ltrc.compare(max, CH.get(i)) < 0){
				max = CH.get(i);
				index = i; 
			}
		}
		return index;
	}
	
	
}

