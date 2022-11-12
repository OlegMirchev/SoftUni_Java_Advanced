package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesExercises2709;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path inputOne = Path.of("C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path inputTwo = Path.of("C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        List<String> lineOne = Files.readAllLines(inputOne);
        List<String> lineTwo = Files.readAllLines(inputTwo);

        lineOne.addAll(lineTwo);

        lineOne.forEach(System.out::println);
    }
}
