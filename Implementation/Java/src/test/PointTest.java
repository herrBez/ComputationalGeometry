package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import geometry.computational.Point;
import geometry.computational.Segment;

/**
 * Created by nate on 11/06/16.
 */
public class PointTest {

    private static int xcoord = 1;
    private static int ycoord = 21;

    @org.junit.Test
    public void getX() throws Exception {
        Point p = new Point(xcoord, ycoord);
        int x = p.getX();
        assertEquals("X coordinates should be equal", xcoord, x);
    }

    @org.junit.Test
    public void getY() throws Exception {
        Point p = new Point(xcoord, ycoord);
        int y = p.getY();
        assertEquals("Y coordinates should be equal", ycoord, y);
    }

    /**
     * TODO: Trovare un nome migliore
     */
    @org.junit.Test
    public void es7() throws Exception {
        Point p = new Point(xcoord, ycoord);
        Point p1 = new Point(1,100);
        Point p2 = new Point(1,1000);
        Segment sDoesNotIntersect = new Segment(p1,p2);
        assertFalse("Should not intersect", p.segmentIntersectRightHalfLine(sDoesNotIntersect));

        Point p3 = new Point(0,0);
        Point p4 = new Point(70,100);
        Segment sDoesIntersect = new Segment(p3,p4);
        assertTrue("Should intersect", p.segmentIntersectRightHalfLine(sDoesIntersect));
    }

    @org.junit.Test
    public void isInside() throws Exception {
        Point p = new Point(xcoord, ycoord);
        Point origin = new Point(0,0);

        Point p1 = new Point(2,0);
        Segment sDoesNotContainP = new Segment(origin, p1);
        assertFalse("Segment should not contain P", p.isInside(sDoesNotContainP));

        Point p2 = new Point(2,42);
        Segment sContainsP = new Segment(origin, p2);
        assertTrue("Segment should contain P", p.isInside(sContainsP));
    }

}