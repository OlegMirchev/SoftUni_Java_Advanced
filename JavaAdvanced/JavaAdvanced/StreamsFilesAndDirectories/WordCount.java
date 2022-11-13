package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesExercises2709;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Path inputOne = Path.of("C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        Path inputTwo = Path.of("C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        List<String> lineOne = Files.readAllLines(inputOne);
        List<String> lineTwo = Files.readAllLines(inputTwo);
        FileOutputStream out = new FileOutputStream("C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt");
        BufferedWriter writer = new BufferedWriter(new PrintWriter(out));

        int countOf = 0;
        int countWhich = 0;
        int countThe = 0;

        for (String resultLine : lineTwo) {
            String[] arrLine = resultLine.split("\\s+");
            for (int i = 0; i < arrLine.length; i++) {
                String letter = arrLine[i];
                if (letter.equals("of")) {
                    countOf++;
                }
                if (letter.equals("which")) {
                    countWhich++;
                }
                if (letter.equals("The")) {
                    countThe++;
                }
            }
        }
        writer.write("of - " + countOf + System.lineSeparator());
        writer.write("which - " + countWhich + System.lineSeparator());
        writer.write("The - " + countThe + System.lineSeparator());
        writer.close();
    }
}
