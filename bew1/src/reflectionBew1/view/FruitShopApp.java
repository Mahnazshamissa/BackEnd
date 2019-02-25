package reflectionBew1.view;

import reflectionBew1.fruitshop.controller.Assistant;
import reflectionBew1.fruitshop.controller.FruitReader;
import reflectionBew1.fruitshop.model.Fruit;

import java.util.List;

public class FruitShopApp {
    public static void main(String[] args) {
        List<String> fruitsAsString = FruitReader.asList("reflectionBew1/fruitshop/file/delivery.txt");
        List<Fruit> fruits = Assistant.translateIntoListOfFruits(fruitsAsString);

        FruitCounter.countFruit(fruits);
    }
}
