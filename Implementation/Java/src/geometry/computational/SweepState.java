package geometry.computational;

import java.util.TreeSet;

public class SweepState extends TreeSet<Segment> implements RBTree{
	
	
	public SweepState(){
		super(new SweepSegmentComparator());
	}
	
	public boolean insert(Segment s) {
		boolean res = this.add(s);
		if(!res){
			System.err.println("Cannot add");
		}
		return res;
	}
	public boolean delete(Segment s){
		return this.remove(s);
	}
	public Segment above(Segment s){
		return this.ceiling(s);
	}
	public Segment below(Segment s){
		return this.floor(s);
	}
	
}

