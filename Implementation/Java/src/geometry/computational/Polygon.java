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

    public boolean isConvex() {
        Point[] vertices = new Point[list.size()];
        for (int i = 0; i < list.size(); i++)
            vertices[i] = list.get(i).getP1();
        for (int i = 2; i < list.size(); i++) {
            boolean neverTurnsRight =
                    Library.turnLeft(vertices[i-2],vertices[i-1],vertices[i]) >= 0;
            boolean neverClosesOnItself =
                    Library.angleLeft(vertices[0],vertices[i-1],vertices[i]) >= 0;
            boolean neverGoesOverTheFirstEdge =
                    Library.angleLeft(vertices[0],vertices[1],vertices[i]) >= 0;
            if(!neverTurnsRight || !neverClosesOnItself || !neverGoesOverTheFirstEdge)
                return false;
        }
        return true;
    }
}
