package skunkworks.locator;

import org.glassfish.jersey.server.ResourceConfig;
import skunkworks.locator.rest.HelloRest;
import skunkworks.locator.rest.PlacesActions;

public class App extends ResourceConfig {
    public App() {
        register(HelloRest.class);
        register(PlacesActions.class);
    }
}
