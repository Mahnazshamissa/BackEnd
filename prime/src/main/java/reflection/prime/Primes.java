package reflection.prime;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Component
public class Primes {
    // Primes - tells you whether a number is prime or not
    /*List<Integer> primes = new ArrayList<>();
    IntStream.range(1, 100)
        .filter(n -> primes.parallelStream()
            .nonMatch(p -> n % p == 0))
            .forEach(primes::add);*/

    public List<Integer> getPrimes(int max) {
        return IntStream.iterate(1, i -> i+1)
                .boxed()
                .filter(e -> isPrime(e))
                .limit(max)
                .collect(toList());
    }

    Boolean isPrime(Integer number) {
        return IntStream.rangeClosed(1, number)
                .filter(e -> number % e == 0)
                .count() == 2;
    }
}
