package reflection.prime;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrimeAdder {
    // PrimeAdder - receives the number of primes you want to sum
    // and returns the sum of them

    public Integer addPrimes(List<Integer> primes) {
        return primes.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
