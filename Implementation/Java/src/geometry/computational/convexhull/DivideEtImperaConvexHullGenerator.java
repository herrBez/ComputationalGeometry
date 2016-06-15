package geometry.computational.convexhull;

import geometry.computational.*;

import java.util.*;

/**
 */
public class DivideEtImperaConvexHullGenerator implements ConvexHullGenerator {
	@Override
    public Polygon generateConvexHull(Polygon polygon) {
		return new Polygon(new ArrayList<Segment>());
	}
}
