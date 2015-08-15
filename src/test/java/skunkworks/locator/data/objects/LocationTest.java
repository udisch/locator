package skunkworks.locator.data.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    @Test
    public void testWithCoordinates() throws Exception {
        final double lon = 35.5452312;
        final double lat = -23.4354545;

        Location location = new Location().withCoordinates(lon, lat);
        assertEquals(lon, location.getCoordinates().getX(), 0.01);
        assertEquals(lat, location.getCoordinates().getY(), 0.01);
    }

}