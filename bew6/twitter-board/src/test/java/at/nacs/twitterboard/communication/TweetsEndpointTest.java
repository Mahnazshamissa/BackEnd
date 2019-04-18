package at.nacs.twitterboard.communication;

import at.nacs.twitterboard.logic.Twitter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TweetsEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @SpyBean
    Twitter twitter;

    @Test
    void get() {
    }

    @Test
    void getOne() {
    }

    @Test
    void post() {
    }

    @Test
    void like() {
    }

    @Test
    void comment() {
    }
}