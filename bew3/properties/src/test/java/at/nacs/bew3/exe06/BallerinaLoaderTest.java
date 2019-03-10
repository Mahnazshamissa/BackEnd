package at.nacs.bew3.exe06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BallerinaLoaderTest {

    @Autowired
    BallerinaLoader ballerinaLoader;

    @Test
    void getBallerinas() {
        List<Ballerina> ballerinas = ballerinaLoader.getBallerinas();
        assertEquals(3, ballerinas.size());
    }

    @ParameterizedTest
    @CsvSource({
            "0, shamissa, 1",
            "1, farnaz, 2",
            "2, mahnaz, 3"
    })
    void testIndividualBallerina(int index, String name, int performance) {
        List<Ballerina> ballerinas = ballerinaLoader.getBallerinas();
        Ballerina ballerina = ballerinas.get(index);

        assertEquals(name, ballerina.getName());
        assertEquals(performance, ballerina.getPerformanceQuality());
    }
}