package test;

import geometry.computational.*;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * 
 * Test class for exercise 9
 */
public class SweepStateTest {
	private static SweepState sweepState;
	@Before
	public void setUpBeforeMethod(){
		sweepState = new SweepState();
		sweepState.insert(new Segment(1, 2, 2, 1));
		sweepState.insert(new Segment(1, 1, 2, 2));
		sweepState.insert(new Segment(1, 1, 2, 2));
		sweepState.insert(new Segment(1, 1, 2, 2));
	}
	@Test
	public void insertTest(){
		
		System.out.println(sweepState.getRBTree());
	 }
	 
	 @Test
	 public void aboveTest(){
		
	 }
	 
	 @Test
	 public void deleteTest(){
	 
	 }
	 
	 @Test
	 public void below(){
	 
	 }
}

