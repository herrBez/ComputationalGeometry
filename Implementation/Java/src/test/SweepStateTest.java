package test;

import static org.junit.Assert.assertTrue;
import geometry.computational.Segment;
import geometry.computational.SweepState;
import geometry.computational.comparator.SweepSegmentComparator;

import java.util.Iterator;

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
		sweepState = new SweepState();
		sweepState.insert(new Segment(1, 2, 2, 1));
		sweepState.insert(new Segment(1, 1, 2, 2));
		sweepState.insert(new Segment(5, 5, 3, 3));
		
		assertTrue(sweepState.size() == 3);
		System.out.println(sweepState);
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
