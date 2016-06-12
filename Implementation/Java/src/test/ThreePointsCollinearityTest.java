package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import geometry.computational.*;

/**
 * Test Class for exercise 5
 * 
 */
public class ThreePointsCollinearityTest {
	private static Point [] positiveSet;
	private static Point [] negativeSet;
	private static ThreePointsCollinearityChecker tpcc;
	private static int xorigin = 10;
	private static int yorigin = 10;
  
	@BeforeClass
	public static void setUp(){
		
		/**
		 *   
		 *      *     *
		 *         O
		 *      *     *  *
		 *         *      
		 *      
		 */
		positiveSet = new Point[6];
		positiveSet[0] = new Point(xorigin+1, yorigin+1);
		positiveSet[1] = new Point(xorigin-1, yorigin+1);
		positiveSet[2] = new Point(xorigin+1, yorigin-1);
		positiveSet[3] = new Point(xorigin-1, yorigin-1);
		positiveSet[4] = new Point(xorigin, yorigin-2);
		positiveSet[5] = new Point(xorigin+2, yorigin-1);
		
		/**
		 * Negative example
		 *       *      *
		 *    
		 *    *     O     *
		 *       
		 *      *       *
		 */
		negativeSet = new Point[6];
		negativeSet[0] = new Point(xorigin+2, yorigin+4);
		negativeSet[1] = new Point(xorigin-2, yorigin+4);
		negativeSet[2] = new Point(xorigin-4, yorigin);
		negativeSet[3] = new Point(xorigin+4, yorigin);
		negativeSet[4] = new Point(xorigin-2, yorigin-4);
		negativeSet[5] = new Point(xorigin+2, yorigin-4);
		
		tpcc = new ThreePointsCollinearityChecker(positiveSet);
	}
  /** Colinear tests */
  /**
   * p == q, It should return 0 if p is equal to q
   *      p = q 
   * 	 /
   *    O------
   *  
   */ 
   @Test
   public void positiveSetTest(){
	   tpcc.setSet(positiveSet);
	   assertTrue(tpcc.check());
   }
   
   @Test
   public void negativeSetTest(){
	   tpcc.setSet(negativeSet);
	   assertFalse(tpcc.check());
   }

}


