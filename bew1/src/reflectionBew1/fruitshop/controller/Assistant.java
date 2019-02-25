package reflectionBew1.fruitshop.controller;


import lombok.experimental.UtilityClass;
import reflectionBew1.fruitshop.model.Fruit;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@UtilityClass
public class Assistant {
    //translates a list of fruit names into a list of fruit

    public List<Fruit> translateIntoListOfFruits(List<String> fruitsAsString) {
        return countFruits(fruitsAsString).entrySet().stream()
                .map(e->FruitReader.toFruits(e)).sorted().collect(Collectors.toList());
    }

    public Map<String, Long> countFruits(List<String> fruits) {
        return fruits.stream()
                .collect(groupingBy(Function.identity(), counting()));
    }
}
