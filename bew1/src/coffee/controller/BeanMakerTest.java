package coffee.controller;

import coffee.model.Bean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BeanMakerTest {

    private BeanMaker beanMaker = new BeanMaker();

    @Test
    void makeBeans() {

        List<Bean> beans = beanMaker.makeBeans(5);

        Assertions.assertTrue(beans.size() > 0 && beans.size() <= 10000);
    }
}