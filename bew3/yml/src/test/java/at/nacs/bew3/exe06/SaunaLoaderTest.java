package at.nacs.bew3.exe06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaunaLoaderTest {

    @Autowired
    SaunaLoader saunaLoader;

    @Test
    void testTempreture() {
        Sauna sauna = saunaLoader.getSauna();
        assertEquals(87.9,sauna.getTemperature());
    }
}