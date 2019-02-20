package coffee.controller;

import coffee.model.Bean;

import java.util.*;

public class BeanChecker {

    /*private List<Bean> beans = new BeanMaker().makeBeans();
    private Bean lastBean = getLastBean(beans);*/

    public Bean getLastBean(List<Bean> beans) {

        Queue<Bean> shuffled = shuffle(beans);
        System.out.println("beginning to check");
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

    private Bean getBean(String color) {
        return Bean.builder().color(color).build();
    }


    private Queue<Bean> shuffle(List<Bean> beans) {
        Collections.shuffle(beans);
        return new LinkedList<>(beans);
    }

    private boolean isSameColour(Bean first, Bean second) {
        return first.equals(second);
    }


}

