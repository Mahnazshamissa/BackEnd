package coffee.controller;

import coffee.model.Bean;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BeanMaker {

    private List<String> colours = new ArrayList<>(Arrays.asList("black", "white"));

    public List<Bean> makeBeans(Integer max){
        Random random = new Random();
        //int numberBeans = random.nextInt(max);
        System.out.println("making beans");
        return IntStream.range(1,max)
                .mapToObj(e -> getBean())
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private Bean getBean() {
        Collections.shuffle(colours);
        return Bean.builder().color(colours.get(0)).build();
    }
}
