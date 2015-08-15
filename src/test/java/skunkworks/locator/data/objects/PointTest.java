package skunkworks.locator.data.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {


    @Test
    public void testWithCoordinates() throws Exception {
        final double lon = 35.5452312;
        final double lat = -23.4354545;
        Point p = new Point()
                .withCoordinates(lon, lat);
        assertEquals(p.getLatitude(), lat, 0.01);
        assertEquals(p.getLongitute(), lon, 0.01);
    }
}