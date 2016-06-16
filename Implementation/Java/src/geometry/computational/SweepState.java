package geometry.computational;

import geometry.computational.comparator.SweepSegmentComparator;

import java.util.TreeSet;

public class SweepState extends TreeSet<Segment> implements RBTree{
	
	
	public SweepState(){
		super(new SweepSegmentComparator());
	}
	
	private void updateComparator(int x){
		((SweepSegmentComparator) comparator()).setX(x);
	}
	
	public boolean insert(Segment s) {
		//Insert -> Event correspond to left extremity of s
		int x = s.getP1().getX();
		updateComparator(x);
		boolean res = this.add(s);
		if(!res){
			System.err.println("Cannot add");
		}
		return res;
	}
	public boolean delete(Segment s){
		int x = s.getP2().getX();
		updateComparator(x);
		return this.remove(s);
	}
	public Segment above(Segment s){
		return this.ceiling(s);
	}
	public Segment below(Segment s){
		return this.floor(s);
	}
	
}

