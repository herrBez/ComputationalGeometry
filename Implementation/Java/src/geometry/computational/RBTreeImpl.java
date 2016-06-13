package geometry.computational;

import geometry.computational.*;
import java.util.TreeSet;

public class RBTreeImpl implements RBTree{
	private TreeSet<Segment> ts;
	
	public RBTreeImpl(){
		ts = new TreeSet<>(new SweepSegmentComparator());
	}
	public void insert(Segment s) {
		ts.add(s);
	}
	public void delete(Segment s){
		ts.remove(s);
	}
	public Segment above(Segment s){
		return ts.ceiling(s);
	}
	public Segment below(Segment s){
		return ts.floor(s);
	}
}

