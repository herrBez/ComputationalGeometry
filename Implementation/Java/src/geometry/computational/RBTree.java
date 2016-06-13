package geometry.computational;

public interface RBTree {
	public void insert(Segment s);
	public void delete(Segment s);
	public Segment above(Segment s);
	public Segment below(Segment s);
}
