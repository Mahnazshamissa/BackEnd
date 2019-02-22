package coffee.controller;

import coffee.model.Bean;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BeanChecker {

    public Bean getLastBean(List<Bean> beans) {

        Queue<Bean> shuffled = shuffle(beans);
        System.out.println("beginning to check");

//        IntStream.generate(() -> 0)
//                .takeWhile(n -> shuffled.size() >1)
//                .mapToObj(n -> Stream.of(shuffled.poll(), shuffled.poll())

        while (shuffled.size() > 1) {
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
//        TODO which is better?
//        Collections.shuffle(beans);
//        return new LinkedList<>(beans);  //our way
        LinkedList<Bean> shuffled = new LinkedList<>(beans);
        Collections.shuffle(shuffled);
        return shuffled;   //L's way
    }

    private boolean isSameColour(Bean first, Bean second) {
        return first.equals(second);
    }

    private Bean getBean(String color) {
        return Bean.builder().color(color).build();
    }


}

