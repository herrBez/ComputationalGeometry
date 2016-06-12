package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import geometry.computational.*;

/**
 * Test for exercise 4
 * 
 */
public class PolarAngleCompareTest {
	private static Point o;
	private static PolarAngleComparatorPoint pacp;
	private static int xorigin = 10;
	private static int yorigin = 10;
  
	@BeforeClass
	public static void setUp(){
		o = new Point(xorigin, yorigin);
		pacp = new PolarAngleComparatorPoint(o);
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
  public void equalityTest() {
	  int xcord = xorigin + 2;
	  int ycord = yorigin + 2;
	  Point p = new Point(xorigin-3, yorigin+3);
	  Point q = new Point(xorigin-3, yorigin+3);
	  assertEquals(pacp.compare(p,q), 0);
	  assertEquals(p, q);
  }
  
  /**
   * N.B. The distance is the same, it is not sufficient
   *  	  to check the distance and the collinearity: you
   * 	  have also to check if both the points lies on the
   * 	  same part with respect to the origin O.
   *       p
   *      /
   *     O-----
   *    /
   *   q
   * 
   * p < q
   */
  @Test
  public void oppositeTest(){
	  Point p = new Point(xorigin+2, yorigin+2);
	  Point q = new Point(xorigin-2, yorigin-2);
	  assertTrue(pacp.compare(p,q) == 0);

  }
  /** AngleLeft is positive */
  
  /**
   *  
   * 		 p
   * 	q	/					
   *     \ /
   *      O-----------
   * 	p < q
   */
   @Test
   public void  PositiveAngleBetweenPAndQ(){
	   Point p = new Point(xorigin+2, yorigin+4);
	   Point q = new Point(xorigin-2, yorigin+2);
	   assertTrue(pacp.compare(p,q) < 0);
   }
   /**    
    * 	   q
    *     /
    * 	 /
    * 	O---------------
    * 	 \
    * 	  \
    * 	   p
    *   p > q
    */
   @Test
   public void PositiveAngleBetweenPAndQFalseFriend(){
	   Point p = new Point(xorigin+2, yorigin-4);
	   Point q = new Point(xorigin+2, yorigin+4);
	   assertTrue(pacp.compare(p,q) < 0);

   }
  

}


