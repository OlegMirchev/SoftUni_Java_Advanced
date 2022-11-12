package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesExercises2709;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String pathInput = "C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        FileInputStream fileInputStream = new FileInputStream(pathInput);
        InputStreamReader inputStream = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(inputStream);
        FileOutputStream out = new FileOutputStream("C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");
        BufferedWriter writer = new BufferedWriter(new PrintWriter(out));

        String line = reader.readLine();
        int count = 1;

        while (line != null) {
            writer.write(count + ". " + line + System.lineSeparator());
            count++;

            line = reader.readLine();
        }
        writer.close();
    }
}
