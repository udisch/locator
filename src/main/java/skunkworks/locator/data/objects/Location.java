package skunkworks.locator.data.objects;

import org.springframework.data.geo.Point;

public class Location {

    private String type;
    private Point coordinates;

    public Location() {
        type = "Point";
    }

    public Location withCoordinates(double lon, double lat) {
        coordinates = new Point(lon, lat);
        return this;
    }

    // Point is immutable, safe to return it
    public Point getCoordinates() {
        return coordinates;
    }
}
