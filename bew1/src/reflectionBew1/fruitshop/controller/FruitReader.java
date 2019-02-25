package reflectionBew1.fruitshop.controller;


import lombok.experimental.UtilityClass;
import reflectionBew1.fruitshop.model.Fruit;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class FruitReader {

    public List<String> asList(String filePath) {
        return FileReader.lines(filePath)
                .collect(Collectors.toList());
    }

    protected Fruit toFruits(Map.Entry<String, Long> fruitsAsString) {
        return Fruit.builder()
                .name(fruitsAsString.getKey()).amount(fruitsAsString.getValue())
                .build();
    }
}
