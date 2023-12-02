package common;

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
}
