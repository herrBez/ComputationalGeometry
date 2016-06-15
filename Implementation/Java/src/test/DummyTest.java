package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import geometry.computational.*;
import geometry.computational.convexhull.*;
import java.util.*;


public class DummyTest {
	@Test
	public void aTest(){
		//IncrementalConvexHullGenerator ichc = new IncrementalConvexHullGenerator();
		//ichc.generateConvexHull(new Polygon(0,0,-4,1,-6,5, -2,9, 2, 5, 6,5, 11,5,15,1));
	}
	
	@Test
	public void MergeHullTest(){
		DivideEtImperaConvexHullGenerator deichc = new DivideEtImperaConvexHullGenerator();
		//deichc.generateConvexHull(new Polygon(0,0,-2,3,0,6, 3, 0, 5,3,3,6));
		//deichc.generateConvexHull(new Polygon(0,0,-4,1,-6,5, -2,9, 2, 5, 6,5, 11,5,15,1));

	}
	@Test
	public void findLowerTangentTest(){
		DivideEtImperaConvexHullGenerator deichc = new DivideEtImperaConvexHullGenerator();
		CircularList<Point> HA = new CircularList<Point>(new Polygon(-3,1,0,0,2,3,1,6,-2,4).getVertices());
		CircularList<Point> HB = new CircularList<Point>(new Polygon(4,0,8,1,8,5,4,5).getVertices());
		Segment ab = deichc.LowerTangent(HA, HB);
		Segment AB = deichc.UpperTangent(HA, HB);
		System.out.println(ab);
		System.out.println(AB);
	}
}
