package skunkworks.locator;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class HelloRest {

    @Autowired
    private HelloBean helloBean;

    @GET
    @Path("/hello")
    public String hello() {
        return helloBean.hello();
    }
}
