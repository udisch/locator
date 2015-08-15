package skunkworks.locator.data.objects;

public class Location {

    private static final String POINT = "Point";

    private String type;
    private Point coordinates;

    public Location() {
        type = POINT;
    }

    public Location withCoordinates(double lon, double lat) {
        coordinates = new Point().withCoordinates(lon, lat);
        return this;
    }

    // Point is immutable, safe to return it
    public Point getCoordinates() {
        return coordinates;
    }
}
