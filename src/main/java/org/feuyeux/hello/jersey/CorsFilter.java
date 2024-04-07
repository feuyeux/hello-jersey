package org.feuyeux.hello.jersey;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Provider
@PreMatching
public class CorsFilter implements ContainerResponseFilter {
    private static final Log logger = LogFactory.getLog(CorsFilter.class);

    @Override
    public void filter(ContainerRequestContext requestCtx, ContainerResponseContext responseCtx) {
        responseCtx.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseCtx.getHeaders().add("Access-Control-Allow-Headers",
                "X-HTTP-Method-Override, Content-Type, x-requested-with");
        responseCtx.getHeaders().add("Access-Control-Allow-Methods", "GET");
        logger.debug(responseCtx.getHeaders().get("Access-Control-Allow-Origin"));
    }
}
