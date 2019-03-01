package reflection.prime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class PrimesTest {

    @Autowired
    Primes primes;


    @Test
    public void getPrimes() {
        List<Integer> actual = primes.getPrimes(4);
        List<Integer> expected = Arrays.asList(2,3,5,7);

        assertEquals(expected,actual);
    }
}