package coffee;

import coffee.controller.BeanStatisticsGatherer;

public class CoffeeApp {

    public static void main(String[] args) {

        BeanStatisticsGatherer beanStatisticsGatherer = new BeanStatisticsGatherer();
        beanStatisticsGatherer.gatherStatistics(17481);

        //the outcomes are suspiciously close to 50 percent
    }
}
