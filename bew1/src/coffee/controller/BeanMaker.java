package coffee.controller;

import coffee.model.Bean;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BeanMaker {

    private List<String> colours = new ArrayList<>(Arrays.asList("black", "white"));

    public List<Bean> makeBeans(Integer max) {
        System.out.println("making beans");
        // could be changed to IntStream.generate(()->0).limit(max)
        return IntStream.range(0, max)
                .mapToObj(e -> getBean())
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private Bean getBean() {
        Collections.shuffle(colours);
        return Bean.builder().color(colours.get(0)).build();
    }
}
