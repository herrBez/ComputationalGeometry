package test;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import geometry.computational.Point;
import geometry.computational.Polygon;
import geometry.computational.Segment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void isInsideSquare() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(0,0,5,0));
        segments.add(new Segment(5,0,5,5));
        segments.add(new Segment(5,5,0,5));
        segments.add(new Segment(0,5,0,0));
        Polygon polygon = new Polygon(segments);
        Point p = new Point(2,2);
        assertTrue(p.isInside(polygon));
    }
}
