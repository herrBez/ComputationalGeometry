package geometry.computational;

import geometry.computational.comparator.SweepSegmentComparator;

import java.util.Iterator;
import java.util.TreeSet;

public class SweepState extends TreeSet<Segment> implements RBTree {

	
	private static final long serialVersionUID = 1L;

	public SweepState() {
		super(new SweepSegmentComparator());
	}

	private void updateComparator(int x) {
		((SweepSegmentComparator) comparator()).setX(x);
	}

	public boolean insert(Segment s) {
		// Insert -> Event correspond to left extremity of s
		int x = s.getLeft().getX();
		updateComparator(x);
		boolean res = this.add(s);
		return res;
	}

	public boolean delete(Segment s) {
		int x = s.getP2().getX();
		updateComparator(x);
		return this.remove(s);
	}

	public Segment above(Segment s) {
		Iterator<Segment> it = this.iterator();
		while(it.hasNext()){
			if(it.next().equals(s))
				if(it.hasNext())
					return it.next();
		}
		return null;
	}

	public Segment below(Segment s) {
		Iterator<Segment> it = this.descendingIterator();
		while(it.hasNext()){
			if(it.next().equals(s))
				if(it.hasNext())
					return it.next();
		}
		return null;
	}

}
