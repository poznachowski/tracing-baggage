package pl.poznachowski.tracingbaggagebug;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("pubsub")
class TracingBaggageBugApplicationTest {

    @LocalServerPort
    int port;

    @Autowired
    private WebApplicationContext context;

    @Test
    void should_propagate_baggage() throws InterruptedException {
        given()
        .when()
                .get("http://localhost:%s/test".formatted(port))
        .then()
                .statusCode(HttpStatus.OK.value());

        Thread.sleep(5000);
    }
}
