package test;

import static org.junit.Assert.assertTrue;

import geometry.computational.Circle;
import geometry.computational.Point;

import org.junit.Test;


public class ACircleTest {
	@Test
	public void aTest(){
		Circle c0 = new Circle(new Point(0,0), 4);
		Circle c1 = new Circle(new Point(0,0), 2);
		Circle c2 = new Circle(new Point(8,0), 4);
		assertTrue(c0.isConcentric(c1));
		assertTrue(!c0.isExtern(c1));
		assertTrue(c0.isTangent(c2));
	}
	
	@Test
	public void TestingIntersection(){
		Circle c0 = new Circle(new Point(0,0), 4);
		Circle c1 = new Circle(new Point(1,1), 5);
		Circle c2 = new Circle(new Point(8,0), 4);

		//assertTrue(c0.intersectCircle(c2));
		assertTrue(c0.intersectCircle(c1));
	}
}
