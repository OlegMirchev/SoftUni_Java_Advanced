package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesLab2509;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStream = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(inputStream);

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Oleg\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput");
        BufferedWriter writer = new BufferedWriter(new PrintWriter(outputStream));

        String line = reader.readLine();
        List<String> file = new ArrayList<>();

        while (line != null) {
            file.add(line);
            line = reader.readLine();
        }
        Collections.sort(file);
        for (int i = 0; i < file.size(); i++) {
            if (file.get(i).equals("")) {
              continue;
            }
            writer.write(file.get(i) + System.lineSeparator());
        }
        writer.close();
    }
}
