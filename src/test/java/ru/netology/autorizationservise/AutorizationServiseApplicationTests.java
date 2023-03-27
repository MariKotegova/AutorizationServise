package ru.netology.autorizationservise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AutorizationServiseApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    private static GenericContainer<?> myAppDev = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    private static GenericContainer<?> myAppProd = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp()  {
        myAppDev.start();
        myAppProd.start();
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> forEntityDev = restTemplate.getForEntity("http://localhost:" + myAppDev.getMappedPort(8080), String.class);
        ResponseEntity<String> forEntityProd = restTemplate.getForEntity("http://localhost:" + myAppProd.getMappedPort(8081), String.class);

        System.out.println(forEntityDev.getBody());
        System.out.println(forEntityProd.getBody());
    }
}
