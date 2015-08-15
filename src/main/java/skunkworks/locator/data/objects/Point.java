package skunkworks.locator.data.objects;

public class Point {
    private static final int LONGITUDE = 0;
    private static final int LATITUDE = 1;

    private double[] coordinates;

    public Point() {}

    public Point withCoordinates(double lon, double lat) {
        double[] coord = new double[2];
        coord[LONGITUDE] = lon;
        coord[LATITUDE] = lat;
        coordinates = coord;
        return this;
    }

    public double getLongitute() {
        return coordinates[LONGITUDE];
    }

    public double getLatitude() {
        return coordinates[LATITUDE];
    }
}
