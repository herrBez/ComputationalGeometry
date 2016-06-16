package geometry.computational.convexhull;

import geometry.computational.CircularList;
import geometry.computational.LeftToRightComparator;
import geometry.computational.Library;
import geometry.computational.Point;
import geometry.computational.Polygon;
import geometry.computational.Segment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A good explanation of the algorithm
 * http://www.cs.wustl.edu/~pless/506/l3.html
 * 
 * TODO: find the correct implementation to find the lower/Upper tangent
 */
public class DivideEtImperaConvexHullGenerator implements ConvexHullGenerator {
	private LeftToRightComparator ltrc;

	public DivideEtImperaConvexHullGenerator() {
		ltrc = new LeftToRightComparator();
	}

	public Polygon generateConvexHull(Polygon polygon) {
		Point[] p = (Point[]) polygon.getVertices().toArray(
				new Point[polygon.getList().size()]);

		Arrays.sort(p, new LeftToRightComparator());
		List<Point> lp = generateConvexHullRec(new CircularList<Point>(
				Arrays.asList(p)));
		System.out.println("Merge" + lp);

		Point[] help = new Point[lp.size()];
		for (int i = 0; i < lp.size(); i++) {
			help[i] = lp.get(i);
		}

		return new Polygon(help);

	}

	private CircularList<Point> generateConvexHullRec(CircularList<Point> lp) {
		int n = lp.size();
		if (n < 3)
			return lp;
		if (n == 3) {
			/* In order to grant the counterclockwise order */
			if (Library.angleLeft(lp.get(0), lp.get(1), lp.get(2)) < 0)
				Collections.swap(lp, 1, 2);
			return lp;
		}
		int mid = (int) Math.floor(n / 2);
		CircularList<Point> leftList = new CircularList<Point>(lp.subList(0,
				mid));
		CircularList<Point> rightList = new CircularList<Point>(lp.subList(mid,
				n));

		CircularList<Point> leftConvexHull = generateConvexHullRec(leftList);
		CircularList<Point> rightConvexHull = generateConvexHullRec(rightList);
		return merge(leftConvexHull, rightConvexHull);
	}

	private CircularList<Point> merge(CircularList<Point> HA, CircularList<Point> HB){
		Segment tLower = LowerTangent(HA, HB);
		Segment tUpper = UpperTangent(HA, HB);
		
		
		tLower.sortExtremity();
		tUpper.sortExtremity();
		int a = HA.indexOf(tLower.getP1());
		int b = HB.indexOf(tLower.getP2());
		int A = HA.indexOf(tUpper.getP1());
		int B = HB.indexOf(tUpper.getP2());
		
		CircularList<Point> result = new CircularList<Point>();
		int i = (A+1)%HA.size();
		int j = b;
		/* N.B. Point A and a of leftList and B and b of rightList belongs to the merged convexHull */
		while(!HA.get(i).equals(HA.getNext(a))){
			result.add(HA.get(i));
			i = (i + 1) % HA.size();
		}
		
		while(!HB.get(j).equals(HB.getNext(B))){
			result.add(HB.get(j));
			j = (j + 1) % HB.size();
		}
		
		result.add(HA.get(A));
	
		return result;
	}

	/**
	 * PseudoCode (1) Let a be the rightmost point of HA . (2) Let b be the
	 * leftmost point of HB . (3) While ab is not a lower tangent for HA and HB
	 * do (a) While ab is not a lower tangent to HA do a = a - 1 (move a
	 * clockwise). (b) While ab is not a lower tangent to HB do b = b + 1 (move
	 * b counterclockwise). (4) Return ab.
	 */
	public Segment LowerTangent(CircularList<Point> HA, CircularList<Point> HB) {
		int a = getRightMostIndex(HA.toArray(new Point[HA.size()]));
		int b = getLeftMostIndex(HB.toArray(new Point[HB.size()]));
		while (!(
		/* Is Tangent for HA ? */
		((Library.angleLeft(HB.get(b), HA.getPrec(a), HA.get(a)) > 0) && (Library
				.angleLeft(HB.get(b), HA.get(a), HA.getNext(a)) < 0)) &&
		/* Is Tangent for HB ? */
		((Library.angleLeft(HA.get(a), HB.getPrec(b), HB.get(b)) < 0) && (Library
				.angleLeft(HA.get(a), HB.get(b), HB.getNext(b)) > 0)))) {

			while (!((Library.angleLeft(HB.get(b), HA.getPrec(a), HA.get(a)) > 0) && (Library
					.angleLeft(HB.get(b), HA.get(a), HA.getNext(a)) < 0))) {
				a = (a - 1 + HA.size()) % HA.size();
			}

			while (!((Library.angleLeft(HA.get(a), HB.getPrec(b), HB.get(b)) < 0) && (Library
					.angleLeft(HA.get(a), HB.get(b), HB.getNext(b)) > 0))) {
				b = (b + 1 + HB.size()) % HB.size();
			}
		}
		return new Segment(HA.get(a), HB.get(b));
	}

	public Segment UpperTangent(CircularList<Point> HA, CircularList<Point> HB) {

		int A = getRightMostIndex(HA.toArray(new Point[HA.size()]));
		int B = getLeftMostIndex(HB.toArray(new Point[HB.size()]));
		while (!(
		/* Is Tangent for HA ? */
		((Library.angleLeft(HB.get(B), HA.getPrec(A), HA.get(A)) > 0) && (Library
				.angleLeft(HB.get(B), HA.get(A), HA.getNext(A)) < 0)) &&
		/* Is Tangent for HB ? */
		((Library.angleLeft(HA.get(A), HB.getPrec(B), HB.get(B)) < 0) && (Library
				.angleLeft(HA.get(A), HB.get(B), HB.getNext(B)) > 0)))) {

			while (!((Library.angleLeft(HB.get(B), HA.getPrec(A), HA.get(A)) > 0) && (Library
					.angleLeft(HB.get(B), HA.get(A), HA.getNext(A)) < 0))) {
				A = (A + 1 + HA.size()) % HA.size();
			}

			while (!((Library.angleLeft(HA.get(A), HB.getPrec(B), HB.get(B)) < 0) && (Library
					.angleLeft(HA.get(A), HB.get(B), HB.getNext(B)) > 0))) {
				B = (B - 1 + HB.size()) % HB.size();
			}
		}
		return new Segment(HA.get(A), HB.get(B));
	}

	

	/**
	 * O(n) find the rightmost point of CH i-1.
	 */
	private int getRightMostIndex(Point[] array) {
		int index = 0;
		Point max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (ltrc.compare(max, array[i]) < 0) {
				max = array[i];
				index = i;
			}
		}
		return index;
	}

	private int getLeftMostIndex(Point[] array) {
		int index = 0;
		Point max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (ltrc.compare(max, array[i]) > 0) {
				max = array[i];
				index = i;
			}
		}
		return index;
	}
}
