package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import geometry.computational.*;

/**
 * Test Class for exercise 4
 * 
 * TODO: Add other special case. I'm not sure I covered'em all
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
	  Point p = new Point(xorigin-3, yorigin+3);
	  Point q = new Point(xorigin-3, yorigin+3);
	  assertEquals(pacp.compare(p,q), 0);
	  assertEquals(p, q);
  }
  
  /**
   *      q
   *     /
   *    p
   *   /
   *  O---------
   * 
   * p < q
   */
  @Test
  public void colinearPBiggerThanQ() {
	 Point p = new Point(xorigin+1, yorigin+1);
	 Point q = new Point(xorigin+3, yorigin+3);
	 assertTrue(pacp.compare(p, q) < 0);
  }
  
  /**   
   *      p
   *     / 
   *    q
   *   /
   *  O-----------
   *  p > q
   */
  @Test
  public void colinearPSmallerThanQ(){
	  Point p = new Point(xorigin+3, yorigin+3);
	  Point q = new Point(xorigin+1, yorigin+1);
	  assertTrue(pacp.compare(p, q) > 0);
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
	  assertTrue(pacp.compare(p,q) < 0);

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
	   assertTrue(pacp.compare(p,q) > 0);
   }

   /** AngleLeft is negative */

  /**
   *
   * 		 q
   * 	p	/
   *     \ /
   *      O-----------
   * 	p > q
   */
   @Test
   public void  NegativeAngleBetweenPAndQ(){
	   Point p = new Point(xorigin-2, yorigin+2);
	   Point q = new Point(xorigin+2, yorigin+4);
	   assertTrue(pacp.compare(p,q) > 0);
   }
   /**
    * 	   p
    *     /
    * 	 /
    * 	O---------------
    * 	 \
    * 	  \
    * 	   q
    *   p < q
    */
   @Test
   public void NegativeAngleBetweenPAndQFalseFriend(){
	   Point p = new Point(xorigin+2, yorigin+4);
	   Point q = new Point(xorigin+2, yorigin-4);
	   assertTrue(pacp.compare(p,q) < 0);

   }

   /**
    *         q
    *
    * 	O------
    *  /
    * p
    *
    *
    *
    * TODO: Find a better name ;)
    */
   @Test
   public void AnotherBrickInTheWall(){
	   Point p = new Point(xorigin-2, yorigin-3);
	   Point q = new Point(xorigin+6, yorigin+2);
	   assertTrue(pacp.compare(p,q) > 0);
   }


}


