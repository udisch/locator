package skunkworks.locator;

import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {
    public App() {
        register(Foo.class);
    }
}
