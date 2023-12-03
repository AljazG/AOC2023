package day2;

import common.utils.InputUtils;

import java.util.List;

public class Second {

    public static void main(String[] args) {
        List<String> games = InputUtils.readLines("./src/day2/input.txt");

        Long sum = 0L;

        for (String game : games) {
            game = game.replaceAll("Game [0-9]+:", "");

            long blueMin = 0L;
            long redMin = 0L;
            long greenMin = 0L;

            for (String round : game.split(";")) {

                long blue = 0L;
                long red = 0L;
                long green = 0L;

                for (String cubes : round.split(",")) {
                    String[] split = cubes.strip().split(" ");
                    if (split[1].equals("blue")) {
                        blue += Integer.parseInt(split[0]);
                    }

                    if (split[1].equals("red")) {
                        red += Integer.parseInt(split[0]);
                    }

                    if (split[1].equals("green")) {
                        green += Integer.parseInt(split[0]);
                    }
                }

                if (red > redMin) {
                    redMin = red;
                }

                if (blue > blueMin) {
                    blueMin = blue;
                }

                if (green > greenMin) {
                    greenMin = green;
                }

            }

            Long power = blueMin * redMin * greenMin;
            System.out.println(power);
            sum += power;

        }

        System.out.print(sum);
    }

}
