package test;

import static org.junit.Assert.assertFalse;
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
		assertTrue(c0.intersectCircle(c1));
	}
	
	@Test
	public void tangentIntersection(){
		Circle c0 = new Circle(new Point(0,0), 4);
		Circle c1 = new Circle(new Point(8,0), 4);
		assertTrue(c0.intersectCircle(c1));
		assertTrue(c1.intersectCircle(c0));
	}
	
	@Test
	public void testConcentric(){
		Circle c0 = new Circle(new Point(0,0), 4);
		Circle c1 = new Circle(new Point(0,0), 100);
		assertFalse(c0.intersectCircle(c1));
		assertTrue(c0.intersectCircle(c0));
	}
	
	@Test
	public void externTest(){
		Circle c0 = new Circle(new Point(0,0), 10);
		Circle c1 = new Circle(new Point(100,0), 1);
		assertFalse(c0.intersectCircle(c1));
	}
	
	@Test
	public void internTest(){
		Circle c0 = new Circle(new Point(0,0), 100);
		Circle c1 = new Circle(new Point(10,10), 1);
		Circle c2 = new Circle(new Point(99,0), 100);
		assertFalse(c0.intersectCircle(c1));
		assertTrue(c0.intersectCircle(c2));
	}
}
