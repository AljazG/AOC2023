package common.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class InputUtils {
    public static List<String> readLines(String fileLocation) {
        BufferedReader reader;
        List<String> out = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(fileLocation));
            String line = reader.readLine();

            while (line != null) {
                out.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Problem reading input from file!");
            System.out.println(e.getMessage());
        }
        return out;
    }

    public static Character[][] readAsCharMatrix(String fileLocation) {

        List<String> lines = readLines(fileLocation);

        if (lines.isEmpty()) {
            return new Character[0][0];
        }

        Character[][] out = new Character[lines.size()][lines.get(0).length()];

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(0).length(); j++) {
                    out[i][j] = lines.get(i).charAt(j);
            }
        }

        return out;
    }
}
