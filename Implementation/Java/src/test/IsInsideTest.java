package test;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import geometry.computational.Point;
import geometry.computational.Segment;

import org.junit.Test;

public class IsInsideTest {
	/**
	 * Testing if some points result inside a vertical line
	 */
	@Test
	public void isInsideVerticalLine(){
		Segment s = new Segment(-10,-10,-10,10);
		Point outside = new Point(-11,10);
		Point inside = new Point(-10,0);
		assertTrue(inside.isInside(s));
		assertFalse(outside.isInside(s));
		/* Testing if the extremities are inside */
		assertTrue(s.getP1().isInside(s));
		assertTrue(s.getP2().isInside(s));
	}
	
	/**
	 * Testing if some points result inside an horizontal line 
	 */
	@Test
	public void isInsideHorizontalLine(){
		Segment s = new Segment(-10,0,10,0);
		Point inside = new Point(0,0);
		Point outside = new Point(11,0);
		assertTrue(inside.isInside(s));
		assertFalse(outside.isInside(s));
		assertTrue(s.getP1().isInside(s));
		assertTrue(s.getP2().isInside(s));
	}
	
	/**
	 * Testing if some points result inside a diagonal line
	 */
	@Test
	public void isInsideDiagonalLine(){
		Segment s = new Segment(-10,10,10,-10);
		Point inside = new Point(0,0);
		Point outside = new Point(10,0);
		assertTrue(inside.isInside(s));
		assertFalse(outside.isInside(s));
	}
}
