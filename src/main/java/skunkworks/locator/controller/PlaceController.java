package skunkworks.locator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.web.bind.annotation.*;
import skunkworks.locator.data.objects.Place;
import skunkworks.locator.data.repository.LocationRepository;
import skunkworks.locator.exception.ResourceNotFoundException;

import static org.springframework.data.geo.Metrics.*;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private LocationRepository locationRepository;

    @PostMapping
    public Place create(@RequestBody Place place) {
        return locationRepository.save(place);
    }

    @GetMapping(path = "/near/{dist}/{lon},{lat}")
    public GeoResults<Place> getNear(@PathVariable("dist") double distance,
                            @PathVariable("lon") double longitude,
                            @PathVariable("lat") double latitude) {
        Point point = new Point(longitude, latitude);
        Distance dist = new Distance(distance, KILOMETERS);

        return locationRepository.findByLocationNear(point, dist);
    }

    @GetMapping(path = "/{id}")
    public Place get(@PathVariable("id") String id) {
        Place place = locationRepository.findOne(id);

        if (place == null) {
            throw new ResourceNotFoundException();
        }

        return place;
    }
}
