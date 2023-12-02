package day2;

import common.InputUtils;
import java.util.List;

public class First {


    private static final int RED_MAX = 12;
    private static final int GREEN_MAX = 13;
    private static final int BLUE_MAX = 14;

    public static void main(String[] args) {
        List<String> games = InputUtils.readLines("./src/day2/input.txt");

        Long gameIdSum = 0L;

        for (int i = 0; i < games.size(); i++) {
            String game = games.get(i);
            game = game.replaceAll("Game [0-9]+:", "");

            boolean possible = true;

            for (String round : game.split(";")) {
                int blue = 0;
                int red = 0;
                int green = 0;

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

                if (red > RED_MAX || blue > BLUE_MAX || green >GREEN_MAX) {
                    possible = false;
                    break;
                }

            }

            if (possible) {
                System.out.println("Possible: " + (i + 1));
                gameIdSum += (i+1);
            }

        }

        System.out.println(gameIdSum);
    }

}
