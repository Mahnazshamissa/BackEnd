package reflectionBew1.view;

import lombok.experimental.UtilityClass;
import reflectionBew1.fruitshop.model.Fruit;

import java.util.List;

@UtilityClass
public class FruitCounter {
    public static void countFruit(List<Fruit> fruits) {
        System.out.println("\n------- FRUITS -------\n");
        fruits.stream().forEach(e -> display(e));
    }

    private String display(Fruit fruit) {
        return " \n" + fruit.getName() + ", " + fruit.getAmount() + " \n";
    }
}
