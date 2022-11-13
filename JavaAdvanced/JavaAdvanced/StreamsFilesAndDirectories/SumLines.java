package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesExercises2709;

import java.io.*;


public class SumLines {
    public static void main(String[] args) throws IOException {
        String pathInput = "C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        FileInputStream input = new FileInputStream(pathInput);
        InputStreamReader inputStream = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(inputStream);
        FileOutputStream out = new FileOutputStream("C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\SumLine");

        BufferedWriter writer = new BufferedWriter(new PrintWriter(out));

        String line = reader.readLine();

        while (line != null) {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            writer.write(sum + System.lineSeparator());
            line = reader.readLine();
        }
        writer.close();
    }
}
