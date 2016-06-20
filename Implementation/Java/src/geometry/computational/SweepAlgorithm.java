package geometry.computational;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SweepAlgorithm {
	private SweepState sweep;
	private List<Segment> ls;
	
	
	
	public SweepAlgorithm(int n){
		Random r = new Random();
		ls = new ArrayList<Segment>();
		for(int i = 0; i < n; i++){
			ls.add(new Segment(r.nextInt(n), r.nextInt(n), r.nextInt(n), r.nextInt(n)));
		}
		sweep = new SweepState();
	}
	
	public SweepAlgorithm(List<Segment> ls){
		sweep = new SweepState();
		this.ls = ls;
	}
	
	public boolean run(){
		int n = ls.size();
		for(int i = 0; i < n; i++){
			ls.get(i).sortExtremity();
		}
		Event [] event = new Event[n * 2];
		int j = 0;
		for(int i = 0; i < n; i++){
			event[j++] = new Event(ls.get(i), true);
			event[j++] = new Event(ls.get(i), false);
		}
		Arrays.sort(event);
		System.out.println(Arrays.asList(event));
		
		for(int i = 0; i < 2*n; i++){
			Event tmp = event[i];
			System.out.println("Processing " + tmp);
			Segment s = tmp.getSegment();
			if(tmp.isLeft()){
				sweep.insert(s);
				Segment s1 = sweep.above(s);
				if(s1 != null && Library.segments_intersect(s, s1)){
					System.out.println("Intersection " + s + "," + s1);

					return true;
				}
				Segment s2 = sweep.below(s);
				if(s1 != null && Library.segments_intersect(s, s2)){
					System.out.println("Intersection " + s + "," + s2);
					return true;
				}
			} else {
				System.out.println("Is right");
				Segment s1 = sweep.above(s);
				Segment s2 = sweep.below(s);
				if(s1 != null && s2 != null && Library.segments_intersect(s1, s2)){
					System.out.println("Intersection " + s1 + "," + s2);

					return true;
				}
				sweep.delete(s);
			}
			
		}
		return false;
	}
}
