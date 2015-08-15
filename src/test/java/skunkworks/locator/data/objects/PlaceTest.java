package skunkworks.locator.data.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlaceTest {

    @Test
    public void testWithLocation() throws Exception {
        final double lon = 35.5452312;
        final double lat = -23.4354545;
        Place place = new Place().withLocation(new Location().withCoordinates(lon, lat));
        assertEquals(lon, place.getLocation().getLongitude(), 0.01);
        assertEquals(lat, place.getLocation().getLatitude(), 0.01);
    }

    @Test
    public void testWithCoordinates() throws Exception {
        final double lon = 35.5452312;
        final double lat = -23.4354545;
        Place place = new Place().withCoordinates(lon, lat);
        assertEquals(lon, place.getLocation().getLongitude(), 0.01);
        assertEquals(lat, place.getLocation().getLatitude(), 0.01);
    }

    @Test
    public void testWithName() throws Exception {
        final String name = "Ray's Pizza";
        Place place = new Place().withName(name);
        assertEquals(name, place.getName());
    }

    @Test
    public void testWithNameAndLocation() throws Exception {
        final double lon = 35.5452312;
        final double lat = -23.4354545;
        final String name = "Ray's Pizza";
        Place place = new Place()
                .withName(name)
                .withLocation(new Location().withCoordinates(lon, lat));
        assertEquals(lon, place.getLocation().getLongitude(), 0.01);
        assertEquals(lat, place.getLocation().getLatitude(), 0.01);
        assertEquals(name, place.getName());
    }
}