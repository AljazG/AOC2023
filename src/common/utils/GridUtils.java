package common.utils;

public class GridUtils {

    public static void printGrid(Object[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
                if (j < grid[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
