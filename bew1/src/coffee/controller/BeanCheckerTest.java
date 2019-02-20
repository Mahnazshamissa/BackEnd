package coffee.controller;

import coffee.model.Bean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanCheckerTest {

    @Test
    void getLastBean() {
        BeanChecker beanChecker = new BeanChecker();
        Bean lastBean = beanChecker.getLastBean(new BeanMaker().makeBeans(5));
        System.out.println(lastBean.getColor());
    }
}