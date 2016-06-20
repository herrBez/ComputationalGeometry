package geometry.computational;

/**
 * Created by nate on 11/06/16.
 */
public class Segment {
	private Point p1;
	private Point p2;
	

	public Segment(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Segment(int x1, int y1, int x2, int y2) {
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}

	private void swapExtremity() {
		Point tmp = p1;
		p1 = p2;
		p2 = tmp;
	}
	
	public Point getLeft(){
		return p1;
	}
	public Point getRight(){
		return p2;
	}

	/**
	 * Sort extremities of segment left to right
	 */
	public void sortExtremity() {
		int x1 = p1.getX();
		int y1 = p1.getY();
		int x2 = p2.getX();
		int y2 = p2.getY();
		if (x1 > x2) {
			swapExtremity();
		} else if (x1 == x2) {
			if (y1 > y2) {
				swapExtremity();
			}
		}
	}

	public String toString() {
		return "{" + p1 + "," + p2 + "}";
	}

	@Override
	public boolean equals(Object obj) {
		Segment s = (Segment) obj;
		return p1.equals(s.p1) && p2.equals(s.p2);
	}

}
