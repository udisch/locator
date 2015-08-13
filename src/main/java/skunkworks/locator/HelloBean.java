package skunkworks.locator;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {

    public String hello() {
        return "Hello World";
    }
}
