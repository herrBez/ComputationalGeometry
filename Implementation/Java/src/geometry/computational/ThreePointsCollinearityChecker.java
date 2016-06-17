package geometry.computational;

import java.util.*;
import geometry.computational.*;
import geometry.computational.comparator.PolarAngleComparatorPoint;

/**
 * Implementation of exercise 5
 * 
 */
public class ThreePointsCollinearityChecker {
	private PolarAngleComparatorPoint pacp;
	private Point[] set;

	public ThreePointsCollinearityChecker(Point[] p) {
		pacp = new PolarAngleComparatorPoint();
		setSet(p);
	}

	/* Performing a deep copy.. */
	public void setSet(Point[] p) {
		set = new Point[p.length];
		for (int i = 0; i < p.length; i++) {
			set[i] = p[i];
		}
	}

	/**
	 * Real Implementation of exercise 5:
	 */
	public boolean check() {
		int n = set.length;
		if (n < 3)
			return false;
		Point[] copySet = new Point[n];
		for (int i = 0; i < n; i++) {
			copySet[i] = set[i];
		}
		for (int i = 0; i < n - 1; i++) {
			pacp.setOrigin(copySet[i]);
			Arrays.sort(set, pacp);
			for (int j = 1; j < n - 2; j++) {
				int d = Library.angleLeft(set[0], set[j], set[j + 1]);
				if (d == 0) {
					// System.out.println("The Points " + set[0] + "," + set[j]
					// + "," + set[j+1] + " are collinear");
					return true;
				}
			}
		}
		return false;
	}

}
