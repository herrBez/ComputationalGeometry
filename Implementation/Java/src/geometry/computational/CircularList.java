package geometry.computational;

import java.util.ArrayList;
import java.util.List;

public class CircularList<T> extends ArrayList<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CircularList() {
		super();
	}

	public CircularList(List<T> l) {
		super(l);
	}

	public T getNext(int i) {
		return get((i + 1 + this.size()) % this.size());
	}

	public T getPrec(int i) {
		return get((i - 1 + this.size()) % this.size());
	}
}
