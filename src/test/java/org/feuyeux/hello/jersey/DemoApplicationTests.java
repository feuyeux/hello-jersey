package org.feuyeux.hello.jersey;


import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class DemoApplicationTests {
    @LocalServerPort
    private int port;

    private String url;

    @BeforeEach
    public void setUp() {
        url = String.format("http://localhost:%d/hi", port);
    }

    @Test
    public void testHi() {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget webTarget = client.target(url);
            GenericType<List<String>> stringListType = new GenericType<>() {
            };
            List<String> list = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get(stringListType);
            assertNotNull(list);
            String value = list.getFirst();
            log.info("value: {}", value);
            assertEquals("hello spring boot", value);
        }
    }
}

