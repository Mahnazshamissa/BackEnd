package coffee.controller;

import coffee.model.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BeanStatisticsGatherer {

    public List<String> getStatistics(Integer tries, Integer numberBeans) {
        new BeanProcessor().gatherStatistics(tries, numberBeans);
        String numTries = "Number of tries: " + tries;
        String numWhite = "Total number of white beans: " + getTotalWhite(entries);
        String numBlack = "Total number of black beans: " + getTotalBlack(entries);
        String timesLastWhite = "Number of times where the last bean was white:" + getTimesLast("white", entries);
        String timesLastBlack = "Number of times where the last bean was black:" + getTimesLast("black", entries);
        String ratio = getRatio(entries);
        String lastBeanRatio = getLastBeanRatio(entries);
        List<String> answers = new ArrayList<>();
        answers.add(numTries);
        answers.add(numWhite);
        answers.add(numBlack);
        answers.add(timesLastWhite);
        answers.add(timesLastBlack);
        answers.add(ratio);
        answers.add(lastBeanRatio);
        return answers;
    }

    private List<String> lines = readInfo();
    private List<Entry> entries = getEntries();

    Integer getTotalWhite(List<Entry> entries) {
        Optional<Integer> reduce = entries.stream()
                .map(Entry::getNumWhite)
                .reduce(Integer::sum);
        return reduce.orElse(0);
    }

    Integer getTotalBlack(List<Entry> entries) {
        Optional<Integer> reduce = entries.stream()
                .map(Entry::getNumBlack)
                .reduce(Integer::sum);
        return reduce.orElse(0);
    }

    private Integer getTimesLast(String colour, List<Entry> entries) {
        long result = entries.stream()
                .filter(e -> e.getColourLast().equals(colour))
                .count();
        return Math.toIntExact(result);
    }

    private String getRatio(List<Entry> entries) {
        Integer totalWhite = getTotalWhite(entries);
        Integer totalBlack = getTotalBlack(entries);
        Integer totalBeans = totalWhite + totalBlack;
        double ratioWhite = totalWhite*100 / totalBeans;
        double ratioBlack = totalBlack *100/ totalBeans;
        return "Total bean ratio: " + ratioWhite + " % white " + ratioBlack + "% black";
    }

    private String getLastBeanRatio(List<Entry> entries) {
        Integer totalLastWhite = getTimesLast("white", entries);
        Integer totalLastBlack = getTimesLast("black", entries);
        int size = entries.size();
        double ratioLastWhite = totalLastWhite *100 / size;
        double ratioLastBlack = totalLastBlack *100/ size;
        return "Total last bean ratio: " + ratioLastWhite + " % white " + ratioLastBlack + "% black";
    }

    private List<String> readInfo() {
        return new FileReader().getLines("coffee/data/initialStatistics.csv");
    }

    private List<Entry> getEntries() {
        return lines.stream()
                .skip(1)
                .map(e -> e.split(","))
                .map(toEntry())
                .collect(Collectors.toList());
    }

    private Function<String[], Entry> toEntry() {
        return e -> Entry.builder()
                .total(Integer.valueOf(e[0]))
                .numWhite(Integer.valueOf(e[1]))
                .percentWhite(Double.valueOf(e[2]))
                .numBlack(Integer.valueOf(e[3]))
                .percentBlack(Double.valueOf(e[4]))
                .colourLast(e[5])
                .build();
    }
}
