package geometry.computational;

public class Event implements Comparable<Event> {
	private Segment s;
	private boolean left;
	private Point p;

	public Event(Segment _s, boolean _left) {
		s = _s;
		left = _left;
		if (left)
			p = s.getP1();
		else
			p = s.getP2();
	}

	public Segment getSegment() {
		return s;
	}

	public boolean isLeft() {
		return left;
	}

	public int compareTo(Event e) {

		if (this.p.getX() < e.p.getX())
			return -1;
		else if (this.p.getX() > e.p.getX())
			return 1;
		// They have the same x
		if (this.left && !e.left) {
			return -1;
		} else if (!this.left && e.left) {
			return 1;
		} else {
			int diff = this.p.getY() - e.p.getY();
			if (diff > 0) { // yp bigger than ye --> p > e
				return 1;
			} else if (diff == 0) {
				return 0;
			} else {
				return -1;
			}
		}
	}
	public String toString(){
		return "[" + s + " " + (left?"true":"false") + "]";
	}
}
