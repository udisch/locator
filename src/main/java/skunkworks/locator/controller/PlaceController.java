package skunkworks.locator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import skunkworks.locator.data.objects.Place;
import skunkworks.locator.data.repository.LocationRepository;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private LocationRepository locationRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Place create(@RequestBody Place place) {
        return locationRepository.save(place);
    }

//    @GET
//    @Path("/near/{dist}/{lon},{lat}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getNear(@PathParam("dist") double distance,
//                            @PathParam("lon") double longitude,
//                            @PathParam("lat") double latitude) {
//        Point point = new Point(longitude, latitude);
//        Distance dist = new Distance(distance, Metrics.KILOMETERS);
//
//        GeoResults<Place> results = repository.findByLocationNear(point, dist);
//
//        List<Place> resultPlaces = new ArrayList<>();
//        for (GeoResult<Place> result : results) {
//            resultPlaces.add(result.getContent());
//        }
//
//        return Response.ok(resultPlaces).build();
//    }
//
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response get(@PathParam("id") String id) {
//        Place place = repository.findOne(id);
//
//        if (place == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//        return Response.ok(place).build();
//    }
}
