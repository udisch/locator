package skunkworks.locator.data.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlaceTest {

    @Test
    public void testWithLocation() throws Exception {
        final double lon = 35.5452312;
        final double lat = -23.4354545;
        Place place = new Place().withLocation(new Location().withCoordinates(lon, lat));
        assertEquals(lat, place.getLocation().getCoordinates().getLatitude(), 0.01);
        assertEquals(lon, place.getLocation().getCoordinates().getLongitute(), 0.01);
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
        assertEquals(lat, place.getLocation().getCoordinates().getLatitude(), 0.01);
        assertEquals(lon, place.getLocation().getCoordinates().getLongitute(), 0.01);
        assertEquals(name, place.getName());
    }
}