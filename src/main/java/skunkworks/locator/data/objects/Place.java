package skunkworks.locator.data.objects;

import org.springframework.data.annotation.Id;

public class Place {

    @Id
    private String id;

    private Location location;
    private String name;

    public Place() {}

    public Place withLocation(Location location) {
        this.location = location;
        return this;
    }

    public Place withCoordinates(double lon, double lat) {
        this.location = new Location().withCoordinates(lon, lat);
        return this;
    }

    public Place withName(String name) {
        this.name = name;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id='" + id + '\'' +
                ", location=" + location +
                ", name='" + name + '\'' +
                '}';
    }
}
