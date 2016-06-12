package test;

import geometry.computational.Library;
import geometry.computational.Point;
import geometry.computational.Segment;

import static org.junit.Assert.*;

/**
 */
public class LibraryTest {

    private static int xcoord1 = 0;
    private static int ycoord1 = 0;
    private static int xcoord2 = 2;
    private static int ycoord2 = 2;

    @org.junit.Test
    public void segmentsShouldIntersect() throws Exception {
        Point origin = new Point(xcoord1, ycoord1); // 'non-particular' case
        Point a2 = new Point(xcoord2, ycoord2);
        Point a3 = new Point(0, 2);
        Point a4 = new Point(2, 0);
        Segment s1 = new Segment(origin,a2);
        Segment s2 = new Segment(a3,a4);
        assertTrue("OA2 and A3A4 should intersect", Library.segments_intersect(s1, s2));
        Point b2 = new Point(xcoord2, ycoord2); // coincident case
        Point b3 = new Point(xcoord1, ycoord1);
        Point b4 = new Point(xcoord2, ycoord2);
        s1 = new Segment(origin,b2);
        s2 = new Segment(b3, b4);
        assertTrue("OB2 and B3B4 should intersect", Library.segments_intersect(s1, s2));
        Point c2 = new Point(xcoord1, ycoord1); // degenerate case
        Point c3 = new Point(xcoord1, ycoord1);
        Point c4 = new Point(xcoord1, ycoord1);
        s1 = new Segment(origin,c2);
        s2 = new Segment(c3, c4);
        assertTrue("OC2 and C3C4 should intersect", Library.segments_intersect(s1, s2));
        Point d2 = new Point(xcoord1, ycoord1); // semi-degenerate case
        Point d3 = new Point(xcoord1, ycoord1);
        Point d4 = new Point(xcoord1+1, ycoord1+1);
        s1 = new Segment(origin,d2);
        s2 = new Segment(d3, d4);
        assertTrue("OD2 and D3D4 should intersect", Library.segments_intersect(s1, s2));
        Point e2 = new Point(xcoord1, ycoord1); // coincident-for-a-while case
        Point e3 = new Point(xcoord1, ycoord1);
        Point e4 = new Point(xcoord1+1, ycoord1+1);
        s1 = new Segment(origin,e2);
        s2 = new Segment(e3, e4);
        assertTrue("OE2 and E3E4 should intersect", Library.segments_intersect(s1, s2));
    }

    @org.junit.Test
    public void segmentsShouldNotIntersect() throws Exception {
        Point origin = new Point(xcoord1, ycoord1); // 'non-particular' case
        Point a2 = new Point(xcoord2, ycoord2);
        Point a3 = new Point(0, 2);
        Point a4 = new Point(2, 4);
        Segment s1 = new Segment(origin,a2);
        Segment s2 = new Segment(a3,a4);
        assertFalse("OA2 and A3A4 should not intersect", Library.segments_intersect(s1, s2));
        Point b2 = new Point(xcoord1, ycoord1); // 'degenerate' case
        Point b3 = new Point(xcoord2, ycoord2);
        Point b4 = new Point(xcoord2, ycoord2);
        s1 = new Segment(origin,b2);
        s2 = new Segment(b3,b4);
        assertFalse("OB2 and B3B4 should not intersect", Library.segments_intersect(s1, s2));
        Point c2 = new Point(xcoord1, ycoord1); // 'semi-degenerate' case
        Point c3 = new Point(xcoord2, ycoord2);
        Point c4 = new Point(xcoord2*1000, ycoord2*1000);
        s1 = new Segment(origin,c2);
        s2 = new Segment(c3,c4);
        assertFalse("OC2 and C3C4 should not intersect", Library.segments_intersect(s1, s2));
    }

}