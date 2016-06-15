package geometry.computational;

import java.util.*;

public class CircularList<T> extends ArrayList<T> {
	public CircularList(){
		super();
	}
	
	public CircularList(List<T> l){
		super(l);
	}
	
	public T getNext(int i){
		return get((i + this.size() + 1) % this.size());
	}
	public T getPrec(int i){
		return get((i - 1 + this.size()) % this.size());
	}
}
