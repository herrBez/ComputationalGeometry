package geometry.computational;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nate on 11/06/16.
 */
public class Polygon {
    private List<Segment> list;

    public Polygon(List<Segment> _list) {
        list = _list;
    }

    public List<Segment> getList() {
        return list;
    }

    public List<Point> getVertices() {
        List<Point> vertices = new ArrayList<>();
        for(Segment s : list)
            vertices.add(s.getP1());
        return vertices;
    }
}
