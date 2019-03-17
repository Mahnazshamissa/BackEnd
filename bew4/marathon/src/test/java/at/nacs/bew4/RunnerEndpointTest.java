package at.nacs.bew4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RunnerEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;


    @Test
    void runners() {
    }

    @Test
    void add() {
    }
}