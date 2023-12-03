package day1;

import common.utils.InputUtils;
import java.util.*;

public class Day1 {
    public static void main(String[] args) {
        List<String> lines = InputUtils.readLines("./src/day1/input.txt");

        long sum = 0L;

        for (String line : lines) {
            List<String> digits = getDigits(line);
            long num = Long.parseLong(digits.get(0) + digits.get(digits.size() - 1));
            sum += num;
        }

        System.out.println(sum);
    }

    static List<String> validNumbers = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    private static List<String> getDigits(String line) {
        List<String> digits = new LinkedList<>();
        for (int i = 0; i< line.length(); i++) {
            char current = line.charAt(i);
            if (current >= '0' && current <= '9') {
                digits.add(String.valueOf(current));
            } else {
                for (int j = 0; j < validNumbers.size(); j++) {
                    int index = line.substring(i).indexOf(validNumbers.get(j));
                    if (index == 0) {
                        digits.add(String.valueOf(j + 1));
                        break;
                    }
                }
            }
        }
        return digits;
    }
}