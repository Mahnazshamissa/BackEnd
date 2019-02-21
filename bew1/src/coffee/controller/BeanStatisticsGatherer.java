package coffee.controller;

import coffee.model.Bean;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class BeanStatisticsGatherer {

    public void gatherStatistics(Integer numberBeans) {
        List<Bean> can = new BeanMaker().makeBeans(numberBeans);
        int numBeans = can.size();
        String colourRatio = getColourRatio(can);

        Bean lastBean = new BeanChecker().getLastBean(can);
        String colorOfLast = lastBean.getColor();

        String result = numBeans + "," + colourRatio + "," + colorOfLast + ",";
        List<String> string = Arrays.asList(result);

        FileWriter fileWriter = new FileWriter();
        String path = "/home/paulius/IdeaProjects/backend/week1/BackEnd/bew1/src/coffee/data/initialStatistics.csv";
        fileWriter.append(string, path);
    }

    private String getColourRatio(List<Bean> can) {
        int total = can.size();
        return can.stream()
                .collect(groupingBy(Bean::getColor, (counting())))
                .entrySet().stream()
                .peek(e -> System.out.println("There are " + e.getValue() + " of colour" + e.getKey()))
//                not happy with this.
//                .sorted(sortByValue())
                .map(e -> e.getKey() + " " + getPercentage(total, e))

//              Not sure if percentage is calculated correctly.
                .collect(Collectors.joining(","));
    }

    private Comparator<Map.Entry<String, Long>> sortByValue() {
        return (e1, e2) -> e2.getKey().compareTo(e1.getKey());
    }

    private String getPercentage(int can, Map.Entry<String, Long> e) {
        double value = (double) (e.getValue() * 100) / can;

        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(value);
//        return String.format( "%.2f", (double) value );
//        return String.valueOf(value);
    }
}
