import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Prime {

    public List<Integer> getPrimeTill100() {
        return IntStream.range(1, 100)
                .boxed()
                .filter(this::hasNoFactors)
                .collect(toList());

    }

    private boolean hasNoFactors(int number) {
        return IntStream.range(2, number)
                .noneMatch(e -> number % e == 0);
    }

}
/*


List<Integer> primes = new ArrayList<>();
        IntStream.range(1, 100)
                .filter(n -> primes.parallelStream()
                .nonMatch(p -> n % p == 0))
                .forEach(primes::add);
 */