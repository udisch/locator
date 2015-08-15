package skunkworks.locator.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import skunkworks.locator.HelloBean;
import skunkworks.locator.data.objects.Place;
import skunkworks.locator.data.repository.LocationRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class HelloRest {

    private static Logger logger = LoggerFactory.getLogger(HelloRest.class);

    @Autowired
    private HelloBean helloBean;

    @Autowired
    private LocationRepository repository;

    @GET
    @Path("/hello")
    public String hello() {
        return helloBean.hello();
    }


    @GET
     @Path("/location")
     public String location() {
//        repository.insert(new Place()
//                .withName("Ray's pizza")
//                .withCoordinates(-73.9971711, 40.7159716));

        GeoResults<Place> byLocationNear = repository.findByLocationNear(new Point(-73.9971711, 40.7159716),
                new Distance(1000, Metrics.KILOMETERS));
        StringBuilder sb = new StringBuilder();
        for (GeoResult<Place> result : byLocationNear.getContent()) {
            sb.append(result.getContent().toString());
        }

        return sb.toString();
    }
}
