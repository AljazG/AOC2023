package day4;

import common.utils.InputUtils;

import java.util.Arrays;
import java.util.List;

public class First {

    public static void main(String[] args) {
        List<String> cards = InputUtils.readLines("./src/day4/input.txt");
        Long sum = 0L;
        for (String card : cards) {
            Long points = 0L;
            card = card.replaceAll("Card\\s+[0-9]+: ", "").strip();
            String[] cardSplit = card.split("\\|");
            List<String> winningNumbers = Arrays.asList(cardSplit[0].strip().split(" "));
            String[] myNumbers = cardSplit[1].strip().split(" +");

            for (String num : myNumbers) {
                if (winningNumbers.contains(num)) {
                    if (points == 0L) {
                        points = 1L;
                    } else {
                        points = points * 2;
                    }
                }
            }
            System.out.println(points);

            sum += points;
        }
        System.out.println(sum);
    }



}
