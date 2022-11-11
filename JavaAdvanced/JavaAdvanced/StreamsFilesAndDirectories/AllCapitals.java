package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesExercises2709;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String pathInput = "C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        FileInputStream fileInputStream = new FileInputStream(pathInput);
        InputStreamReader inputStream = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(inputStream);
        FileOutputStream out = new FileOutputStream("C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\AllBytes");
        BufferedWriter writer = new BufferedWriter(new PrintWriter(out));

        String line = reader.readLine();

        while (line != null) {
            writer.write(line.toUpperCase() + System.lineSeparator());

            line = reader.readLine();
        }
        writer.close();
    }
}
