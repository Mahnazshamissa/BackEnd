package coffee.view;

import coffee.controller.BeanStatisticsGatherer;

import java.util.List;

public class CoffeeApp {

    public static void main(String[] args) {

        BeanStatisticsGatherer beanStatisticsGatherer = new BeanStatisticsGatherer();
        List<String> statistics = beanStatisticsGatherer.getStatistics(100, 50);
        for (String statistic : statistics) {
            System.out.println(statistic);
        }
    }
}
