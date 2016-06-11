package main;

import geometry.computational.*;


public class PolarAngleTest {
	
	
	
	public static void main(String[] args){
		System.out.println("Hello World!");
		Point p0 = new Point(1,2);
		Point p1 = new Point(2,2);
		Point p2 = new Point(7,7);
		int d = Library.angleLeft(p0, p1, p2);
		System.out.println("This is a good angle " + d);
	}

}
