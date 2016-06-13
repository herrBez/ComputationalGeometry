package geometry.computational;

public interface RBTree {
	public boolean insert(Segment s);
	public boolean delete(Segment s);
	public Segment above(Segment s);
	public Segment below(Segment s);
}
