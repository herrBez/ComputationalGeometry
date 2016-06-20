package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import geometry.computational.Polygon;
import geometry.computational.Segment;
import geometry.computational.SweepAlgorithm;
import geometry.computational.SweepState;
import geometry.computational.comparator.SweepSegmentComparator;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Test class for exercise 9
 */
public class SweepStateTest {
	private static SweepState sweepState;

	@Before
	public void setUpBeforeMethod() {

	}
	@Test
	public void compare(){
		SweepSegmentComparator ssc = new SweepSegmentComparator();
		Segment s = new Segment(0,2,2,2);
		Segment t = new Segment(0,0,2,0);
		ssc.setX(1);
		assertTrue(ssc.compare(s, t) > 0);
	}

	@Test
	public void insertTest() {
	
		SweepAlgorithm sa = new SweepAlgorithm(10);
		sa.run();
		
	}

	@Test
	public void aboveTest() {
		
	}

	@Test
	public void deleteTest() {

	}

	@Test
	public void below() {

	}
}
