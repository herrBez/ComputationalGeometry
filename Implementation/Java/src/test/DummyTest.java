package test;

import static org.junit.Assert.assertTrue;
import geometry.computational.CircularList;
import geometry.computational.Point;
import geometry.computational.Polygon;
import geometry.computational.Segment;
import geometry.computational.convexhull.DivideEtImperaConvexHullGenerator;

import org.junit.Test;


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
		/*DivideEtImperaConvexHullGenerator deichc = new DivideEtImperaConvexHullGenerator();
		CircularList<Point> HA = new CircularList<Point>(new Polygon(-3,1,0,0,2,3,1,6,-2,4).getVertices());
		CircularList<Point> HB = new CircularList<Point>(new Polygon(4,0,8,1,8,5,4,5).getVertices());
		Segment ab = deichc.LowerTangent(HA, HB);
		Segment AB = deichc.UpperTangent(HA, HB);
		assertTrue(ab.equals(new Segment(0,0,4,0)));
		assertTrue(AB.equals(new Segment(1,6,8,5)));*/
	}
}
