package day4;

import common.utils.InputUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Second {

    public static void main(String[] args) {
        List<String> cards = InputUtils.readLines("./src/day4/input.txt");

        int[] counter = new int[cards.size()];


        for (int i = 0; i < cards.size(); i++) {

            String card = cards.get(i);
            card = card.replaceAll("Card\\s+[0-9]+: ", "").strip();
            String[] cardSplit = card.split(Pattern.quote("|"));

            List<String> winningNumbers = Arrays.asList(cardSplit[0].strip().split(" "));
            String[] myNumbers = cardSplit[1].strip().split(" +");

            long hits = Arrays.stream(myNumbers).filter(winningNumbers::contains).count();
            counter[i]++;

            for (int j  = 1; j <= hits; j++) {
                if ( i + j < cards.size()) {
                    counter[i+j]+=counter[i];
                }
            }


        }
        System.out.println(Arrays.stream(counter).sum());
    }



}
