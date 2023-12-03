package day3;

import common.utils.InputUtils;

public class First {

    public static void main(String[] args) {
        Character[][] schematic = InputUtils.readAsCharMatrix("./src/day3/input.txt");

        Long sum = 0L;

        for (int i = 0; i < schematic.length; i++) {
            char current;
            String currentNumber = "";
            boolean isPartNumber = false;

            for (int j = 0; j < schematic[0].length; j++) {
                current = schematic[i][j];
                if (schematic[i][j] >= '0' && schematic[i][j] <= '9') {
                    currentNumber += String.valueOf(current);
                    isPartNumber = isPartNumber || isPartChar(schematic, i, j);

                } else {
                    if (!"".equals(currentNumber) && isPartNumber) {
                        sum += Long.parseLong(currentNumber);
                    }
                    currentNumber = "";
                    isPartNumber = false;
                }
            }

            if (!"".equals(currentNumber) && isPartNumber) {
                sum += Long.parseLong(currentNumber);
            }
        }

        System.out.println(sum);
    }

    private static boolean isPartChar(Character[][] schematic, int i, int j) {

        int iMin = i == 0 ? i : i - 1;
        int iMax = i == schematic.length - 1 ? i : i + 1;

        int jMin = j == 0 ? j : j - 1;
        int jMax = j == schematic[0].length - 1 ? j : j + 1;

        for (int x = iMin; x <= iMax; x++) {
            for (int y = jMin; y <= jMax; y++) {
                if ((schematic[x][y] < '0' || schematic[x][y] > '9') && schematic[x][y] != '.') {
                    return true;
                }
            }
        }

        return false;
    }


}
