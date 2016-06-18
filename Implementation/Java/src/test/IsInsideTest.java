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
    public void isInsideTriangle() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(0,0,6,0));
        segments.add(new Segment(6,0,3,6));
        segments.add(new Segment(3,6,0,0));
        Polygon polygon = new Polygon(segments);
        Point inside = new Point(2,2);
        Point outsideL = new Point(-1,2); // left
        Point outsideLB = new Point(-1,-1); // left and below
        Point outsideLT = new Point(0,6); // left and top
        Point outsideR = new Point(110,2); // right
        assertTrue(inside.isInside(polygon));
        assertFalse(outsideL.isInside(polygon));
        assertFalse(outsideLB.isInside(polygon));
        assertFalse(outsideLT.isInside(polygon));
        assertFalse(outsideR.isInside(polygon));
    }

    @Test
    public void isInsideSquare() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(0,0,5,0));
        segments.add(new Segment(5,0,5,5));
        segments.add(new Segment(5,5,0,5));
        segments.add(new Segment(0,5,0,0));
        Polygon polygon = new Polygon(segments);
        Point inside = new Point(2,2);
        Point outsideL = new Point(-1,2); // left
        Point outsideLB = new Point(-1,-1); // left and below
        Point outsideR = new Point(110,2); // right
        assertTrue(inside.isInside(polygon));
        assertFalse(outsideL.isInside(polygon));
        assertFalse(outsideLB.isInside(polygon));
        assertFalse(outsideR.isInside(polygon));
    }

    /**
     * Fig. A
     * o •===• o •
     *   |    \ /|
     * o |  P--•-|----------
     *   | i     |
     * o •=======•
     */
    @Test
    public void isInsideFigA() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(0,0,10,0));
        segments.add(new Segment(10,0,10,10));
        segments.add(new Segment(10,10,8,5));
        segments.add(new Segment(8,5,6,10));
        segments.add(new Segment(6,10,0,10));
        segments.add(new Segment(0,10,0,0));
        Polygon polygon = new Polygon(segments);
        Point inside = new Point(2,2); // inside
        Point insideEdgeCase = new Point(2,5); // inside with edge case
        Point outsideL = new Point(-1,2); // left
        Point outsideLB = new Point(-1,0); // left and below
        Point outsideLBet = new Point(8,10); // left and between
        Point outsideLT = new Point(-1,10); // left and top
        Point outsideR = new Point(110,2); // right
        Point outsideEdgeCase = new Point(-1,5); // left and edge case
        assertTrue(inside + " should be inside",
                inside.isInside(polygon));
        assertTrue(insideEdgeCase + " should be inside",
                insideEdgeCase.isInside(polygon));
        assertFalse(outsideL + " should not be inside",
                outsideL.isInside(polygon));
        assertFalse(outsideLB + " should not be inside",
                outsideLB.isInside(polygon));
        assertFalse(outsideLBet + " should not be inside",
                outsideLBet.isInside(polygon));
        assertFalse(outsideLT + " should not be inside",
                outsideLT.isInside(polygon));
        assertFalse(outsideR + " should not be inside",
                outsideR.isInside(polygon));
        assertFalse(outsideEdgeCase + " should not be inside",
                outsideEdgeCase.isInside(polygon));
    }
}
