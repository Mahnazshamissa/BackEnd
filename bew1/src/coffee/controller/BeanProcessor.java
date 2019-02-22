package coffee.controller;

import coffee.model.Bean;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class BeanProcessor {

    public void gatherStatistics(Integer tries, Integer numberBeans) {
        IntStream.range(0,tries)
                .forEach(e -> runSimulation(numberBeans));
    }

    private void runSimulation(Integer numberBeans) {

        List<Bean> can = new BeanMaker().makeBeans(numberBeans);

        String result = getResult(can);

        saveResult(result);
    }

    private String getResult(List<Bean> can) {
        Integer numBeans = can.size();
        String colourRatio = getColourRatio(can);
        String colour = getLastBeanColour(can);
        return numBeans + "," + colourRatio + "," + colour;
    }

    private String getColourRatio(List<Bean> can) {
        int total = can.size();
        return can.stream()
                .collect(groupingBy(Bean::getColor, (counting())))
                .entrySet().stream()
                .map(e -> getColourInfo(total, e))
                .collect(Collectors.joining(","));
    }

    private String getColourInfo(int total, Map.Entry<String, Long> e) {
        Long value = e.getValue();
        return value +  "," + getPercentage(total, value);
    }

    private String getPercentage(int totalBeans, Long number) {
        double value = (double) (number * 100) / totalBeans;

        NumberFormat formatter = new DecimalFormat("0.00");
        return formatter.format(value);
    }

    private String getLastBeanColour(List<Bean> can) {
        return new BeanChecker().getLastBean(can).getColor();
    }

    private void saveResult(String string) {
        FileAppender fileAppender = new FileAppender();
        fileAppender.append(string, "experiment/statistics.csv");
    }
}
