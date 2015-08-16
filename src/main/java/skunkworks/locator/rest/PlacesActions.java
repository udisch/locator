package skunkworks.locator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import skunkworks.locator.data.objects.Place;
import skunkworks.locator.data.repository.LocationRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/place")
public class PlacesActions {

    @Autowired
    private LocationRepository repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Place place) {
        Place createdPlace = repository.save(place);
        URI createdURI = URI.create("place/" + createdPlace.getId());

        return Response.created(createdURI).build();
    }

    @GET
    @Path("/near/{dist}/{lon},{lat}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNear(@PathParam("dist") double distance,
                            @PathParam("lon") double longitude,
                            @PathParam("lat") double latitude) {
        Point point = new Point(longitude, latitude);
        Distance dist = new Distance(distance, Metrics.KILOMETERS);

        GeoResults<Place> geoResults = repository.findByLocationNear(point, dist);

        List<Place> resultPlaces = new ArrayList<>();
        geoResults.forEach(geoResult -> resultPlaces.add(geoResult.getContent()));

        return Response.ok(resultPlaces).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") String id) {
        Place place = repository.findOne(id);

        if (place == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(place).build();
    }
}
