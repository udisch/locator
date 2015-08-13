package skunkworks.locator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class Foo {

    @GET
    @Path("/hello")
    public String hello() {
        return "Hello world";
    }
}
