package org.feuyeux.hello.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(DemoResource.class);
        register(CorsFilter.class);
        this.property("jersey.config.server.wadl.disableWadl", true);
    }
}
