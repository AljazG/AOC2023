package day3;

import common.models.Pair;
import common.utils.InputUtils;

import java.util.*;


public class Second {

    public static void main(String[] args) {
        Character[][] schematic = InputUtils.readAsCharMatrix("./src/day3/input.txt");
        Map<Pair<Integer, Integer>, List<Long>> gearMap = new HashMap<>();

        Long sum = 0L;

        for (int i = 0; i < schematic.length; i++) {
            char current;
            String currentNumber = "";
            Set<Pair<Integer, Integer>> gearSet = new HashSet<>();

            for (int j = 0; j < schematic[0].length; j++) {
                current = schematic[i][j];
                if (schematic[i][j] >= '0' && schematic[i][j] <= '9') {
                    currentNumber += String.valueOf(current);
                    addGears(schematic, i, j, gearSet);

                } else {
                    if (!"".equals(currentNumber)) {
                        updateGearMap(gearMap, gearSet, currentNumber);
                        gearSet = new HashSet<>();
                    }
                    currentNumber = "";
                }
            }

            if (!"".equals(currentNumber)) {
                updateGearMap(gearMap, gearSet, currentNumber);
            }
        }

        for (Pair<Integer, Integer> key : gearMap.keySet()) {
            List<Long> neighbours = gearMap.get(key);
            if (neighbours.size() == 2) {
                System.out.println(neighbours.get(0) + " " + neighbours.get(1));
                sum += (neighbours.get(0) * neighbours.get(1));
            }
        }

        System.out.println(sum);
    }

    private static void updateGearMap(Map<Pair<Integer, Integer>, List<Long>> gearMap, Set<Pair<Integer, Integer>> gearSet, String currentNumber) {
        gearSet.stream().toList().forEach(gear -> {
            if (gearMap.containsKey(gear)) {
                List<Long> list = gearMap.get(gear);
                list.add(Long.parseLong(currentNumber));
                gearMap.put(gear, list);
            } else {
                gearMap.put(gear, new ArrayList<>(List.of(Long.parseLong(currentNumber))));
            }
        });
    }

    private static void addGears(Character[][] schematic, int i, int j, Set<Pair<Integer, Integer>> gearSet) {

        int iMin = i == 0 ? i : i - 1;
        int iMax = i == schematic.length - 1 ? i : i + 1;

        int jMin = j == 0 ? j : j - 1;
        int jMax = j == schematic[0].length - 1 ? j : j + 1;

        for (int x = iMin; x <= iMax; x++) {
            for (int y = jMin; y <= jMax; y++) {
                if (schematic[x][y] == '*') {
                    gearSet.add(new Pair<>(x, y));
                }
            }
        }
    }


}
