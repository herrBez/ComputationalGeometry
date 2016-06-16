package test;

import geometry.computational.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
/**
 * 
 * Test class for exercise 9
 */
public class SweepStateTest {
	private static SweepState sweepState;
	@Before
	public void setUpBeforeMethod(){
	
	}
	@Test
	public void insertTest(){
			sweepState = new SweepState();
		sweepState.insert(new Segment(1, 2, 2, 1));
		sweepState.insert(new Segment(1, 1, 2, 2));
		sweepState.insert(new Segment(5, 5, 3, 3));
		Iterator<Segment> it = sweepState.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
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

