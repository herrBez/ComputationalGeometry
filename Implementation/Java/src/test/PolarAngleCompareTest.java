package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import geometry.computational.*;

public class PolarAngleCompareTest {
  
  
  @Test
  public void equalityTest() {
		Point o = new Point(1, 1);
		Point p = new Point(1, 2);
		Point q = new Point(1, 2);
		PolarAngleComparatorPoint pacp = new PolarAngleComparatorPoint(o);
		assertEquals(pacp.compare(p,q), 0);
		assertEquals(p, q);
  }
  

}


