package reflection.prime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class PrimeAdderTest {

    @Autowired
    PrimeAdder primeAdder;

    @Autowired
    Primes primes;


    @Test
    public void addPrimes() {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7);
        Integer actual = primeAdder.addPrimes(numbers);
        Integer expected = 17;

        assertEquals(expected, actual);
    }

    @Test
    void addPrimesUltimatum() {

        List<Integer> primeNumbers = primes.getPrimes(100);
        Integer actual = primeAdder.addPrimes(primeNumbers);
        Integer expected = 24133;

        assertEquals(expected, actual);
    }

}