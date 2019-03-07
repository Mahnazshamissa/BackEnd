package at.nacs.bew3.exe06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumberTest {

    @Autowired
    Number number;

    @Test
    void getAmount() {
        Integer actualNumber= number.getAmount();
        Assertions.assertEquals(Integer.valueOf(369),actualNumber);
    }
}