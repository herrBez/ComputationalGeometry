package geometry.computational;

import geometry.computational.*;
import java.util.TreeSet;

public class SweepState implements RBTree{
	private TreeSet<Segment> ts;
	
	public SweepState(){
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
	public TreeSet<Segment> getRBTree(){
		return ts;
	}
}

