package reflectionBew1.fruitshop.controller;

import org.junit.jupiter.api.Test;
import reflectionBew1.fruitshop.model.Fruit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AssistantTest {
    private List<Fruit> getExpectedFruits(){
        return Stream.of(Fruit.builder().name("Apple").amount((long)1).build(),
                Fruit.builder().name("Orange").amount((long)4).build(),
                Fruit.builder().name("Banana").amount((long)1).build())
                .collect(Collectors.toList());
    }

    private List<String> getFruits(){
        return Stream.of("Orange","Apple","Orange","Banana","Orange","Orange")
                .collect(Collectors.toList());
    }

    private Map<String, Long> getExpectedFruitsAsMap() {
        Map<String, Long> map = new HashMap<>();
        map.put("Orange", (long)4);
        map.put("Apple", (long)1);
        map.put("Banana", (long)1);
        return map;
    }
    @Test
    void testtranslateIntoListOfFruits() {
        List<Fruit> actualFruits = Assistant.translateIntoListOfFruits(getFruits());
        List<Fruit> expectedFruits = getExpectedFruits();
        assertEquals(expectedFruits,actualFruits);
    }
    @Test
    void testCountFruits() {
        Map<String, Long> actual = Assistant.countFruits(getFruits());
        Map<String, Long> expectedFruits = getExpectedFruitsAsMap();
        assertEquals(expectedFruits.entrySet(), actual.entrySet());
    }

}