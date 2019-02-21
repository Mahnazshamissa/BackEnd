package coffee.controller;

import coffee.model.Bean;
import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BeanChecker {

    /*private List<Bean> beans = new BeanMaker().makeBeans();
    private Bean lastBean = getLastBean(beans);*/

    private FileWriter writer = new FileWriter();

    public Bean getLastBean(List<Bean> beans) {

        Queue<Bean> shuffled = shuffle(beans);
        System.out.println("beginning to check");

//        IntStream.generate(() -> 0)
//                .takeWhile(n -> shuffled.size() >1)
//                .mapToObj(n -> Stream.of(shuffled.poll(), shuffled.poll())

        while (shuffled.size() >1){
            Bean first = shuffled.poll();
            Bean second = shuffled.poll();
            if (isSameColour(first, second)) {
                shuffled.add(getBean("black"));
            } else {
                shuffled.add(getBean("white"));
            }

        }
        return shuffled.poll();
    }

    private Queue<Bean> shuffle(List<Bean> beans) {
//        Collections.shuffle(beans);
//        return new LinkedList<>(beans);  //our way
        List<Bean> shuffled = new LinkedList<>(beans);
        Collections.shuffle(shuffled);
        return (Queue<Bean>) shuffled;   //L's way
    }

    private boolean isSameColour(Bean first, Bean second) {
        return first.equals(second);
    }

    private Bean getBean(String color) {
        return Bean.builder().color(color).build();
    }


}

