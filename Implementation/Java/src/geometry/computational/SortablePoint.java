package geometry.computational;

/**
 * Point that provides O(1) angular comparison with other points.
 */
public class SortablePoint extends Point implements Comparable<Point> {

    private Point origin;

    private SortablePoint(int _x, int _y) {
        super(_x, _y);
    }

    public SortablePoint withOrigin(Point o) {
        origin = o;
        return this;
    }

    @Override
    public int compareTo(Point p) {
        if(this.equals(p))
            return 0;
        if((getY() - origin.getY()) * (origin.getY() - p.getY()) > 0) {
            // check who's above and who's not
            if (getY() > p.getY())
                return -1;
            else
                return 1;
        }
        // points are in the same halfplane
        if(Library.angleLeft(origin, this, p) > 0)
            return -1;
        if(Library.angleLeft(origin, this, p) < 0)
            return 1;
        // points are collinear
        if((getX() - origin.getX()) * (origin.getX() - p.getX()) > 0) {
            // check who's above and who's not
            if (getX() > p.getX())
                return -1;
            else
                return 1;
        }
        // points are in the same halfline starting from origin
        if(origin.sqrDistanceFrom(this) < origin.sqrDistanceFrom(p))
            return -1;
        return 1;
    }

    public static SortablePoint createSortablePoint(int x, int y, Point origin) {
        return new SortablePoint(x,y).withOrigin(origin);
    }
}
