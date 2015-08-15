package skunkworks.locator.data.objects;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Arrays;

public class Location {

    private static final String TYPE_POINT = "Point";
    private static final int COORDINATES_SIZE = 2;
    private static final int LONGITUDE = 0;
    private static final int LATITUDE = 1;

    private String type;
    private double[] coordinates;

    public Location() {
        type = TYPE_POINT;
    }

    public Location withCoordinates(double lon, double lat) {
        coordinates = new double[COORDINATES_SIZE];
        coordinates[LONGITUDE] = lon;
        coordinates[LATITUDE] = lat;
        return this;
    }

    @XmlTransient
    public double getLongitude() {
        return coordinates[LONGITUDE];
    }

    @XmlTransient
    public double getLatitude() {
        return coordinates[LATITUDE];
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Location{" +
                "coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
