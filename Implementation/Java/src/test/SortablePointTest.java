package test;

import geometry.computational.Point;
import geometry.computational.SortablePoint;

import static org.junit.Assert.*;

/**
 */
public class SortablePointTest {

    private int xOrig = 0;
    private int yOrig = 0;
    private Point origin = new Point(xOrig, yOrig);

    @org.junit.Test
    public void aboveAndBelowOrigin() throws Exception {
        SortablePoint p = SortablePoint.createSortablePoint(2, 2, origin);
        SortablePoint q = SortablePoint.createSortablePoint(-2, -2, origin);
        assertTrue("p < q", p.compareTo(q) < 0);
        SortablePoint a = SortablePoint.createSortablePoint(123, -2, origin);
        SortablePoint b = SortablePoint.createSortablePoint(1254, 225, origin);
        assertTrue("a > b", a.compareTo(b) > 0);
    }

    @org.junit.Test
    public void atOriginLevel() throws Exception {
        SortablePoint p = SortablePoint.createSortablePoint(xOrig + 2, yOrig, origin);
        SortablePoint q = SortablePoint.createSortablePoint(xOrig - 2,yOrig, origin);
        assertTrue("p < q", p.compareTo(q) < 0);
        SortablePoint c = SortablePoint.createSortablePoint(xOrig - 123, yOrig, origin);
        SortablePoint d = SortablePoint.createSortablePoint(xOrig + 1254, yOrig, origin);
        assertTrue("c > d", c.compareTo(d) > 0);
        SortablePoint e = SortablePoint.createSortablePoint(xOrig + 1, yOrig, origin);
        SortablePoint f = SortablePoint.createSortablePoint(xOrig + 10, yOrig, origin);
        assertTrue("e < f", e.compareTo(f) < 0);
        SortablePoint g = SortablePoint.createSortablePoint(xOrig + 20, yOrig, origin);
        SortablePoint h = SortablePoint.createSortablePoint(xOrig + 4, yOrig, origin);
        assertTrue("g > h", g.compareTo(h) > 0);
    }

    @org.junit.Test
    public void equalityTest() throws Exception {
        SortablePoint a = SortablePoint.createSortablePoint(xOrig + 1, yOrig + 1, origin);
        SortablePoint b = SortablePoint.createSortablePoint(xOrig + 1, yOrig + 1, origin);
        assertTrue("a = b", a.compareTo(b) == 0);
        // test degenerate case
        SortablePoint c = SortablePoint.createSortablePoint(xOrig, yOrig, origin);
        SortablePoint d = SortablePoint.createSortablePoint(xOrig, yOrig, origin);
        assertTrue("c = d", c.compareTo(d) == 0);
    }

    @org.junit.Test
    public void pointsInTheSameHalfplane() throws Exception {
        SortablePoint p = SortablePoint.createSortablePoint(xOrig + 2, xOrig + 1, origin);
        SortablePoint q = SortablePoint.createSortablePoint(xOrig - 3, xOrig + 5, origin);
        assertTrue("p < q", p.compareTo(q) < 0);
        SortablePoint a = SortablePoint.createSortablePoint(xOrig - 7, xOrig + 20, origin);
        SortablePoint b = SortablePoint.createSortablePoint(xOrig + 13, xOrig + 7, origin);
        assertTrue("a > b", a.compareTo(b) > 0);
    }
}