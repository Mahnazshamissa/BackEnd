package at.nacs.bew3.exe06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeekTest {

    @Autowired
    Week week;

    @Test
    void getDays() {
        List<String> days = week.getDays();
        List<String> expected = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        assertEquals(expected, days);
    }
}