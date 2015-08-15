package skunkworks.locator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import skunkworks.locator.data.objects.Place;
import skunkworks.locator.data.repository.LocationRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/place")
public class PlacesActions {

    @Autowired
    private LocationRepository repository;

    @POST
    @Path("/{lon}/{lat}/{name}")
    public Response create(@PathParam("name") String name,
                       @PathParam("lon") double longitude,
                       @PathParam("lat") double latitude) {
        Place place = new Place()
                .withCoordinates(longitude, latitude)
                .withName(name);

        Place createdPlace = repository.save(place);

        return Response
                .created(URI.create("/place" + createdPlace.getId()))
                .build();
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
