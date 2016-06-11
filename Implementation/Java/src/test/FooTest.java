package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import geometry.computational.Point;

public class FooTest {
  
  
  @Test
  public void getTest() {
		Point p = new Point(1,2);
		assertEquals(1,p.getX());
  }
  @Test
  public void setTest() {
		Point p = new Point(1,2);
		assertEquals(2, p.getY());
  }
}

