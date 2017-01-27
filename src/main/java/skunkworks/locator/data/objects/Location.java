package skunkworks.locator.data.objects;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Arrays;

public class Location {

    private static final String TYPE_POINT = "Point";
    private String type;
    private double[] coordinates;

    public Location() {
        type = TYPE_POINT;
    }

    public Location withCoordinates(double lon, double lat) {
        coordinates = new double[2];
        coordinates[0] = lon;
        coordinates[1] = lat;
        return this;
    }

    @XmlTransient
    public double getLongitude() {
        return coordinates[0];
    }

    @XmlTransient
    public double getLatitude() {
        return coordinates[1];
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
