package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesLab2509;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        int value = fileInputStream.read();

        Set<Character> setSeparators = Set.of(',', '.', '!', '?');

        while (value != -1) {
            char symbol = (char) value;
            if (!setSeparators.contains(symbol)) {
                System.out.print(symbol);
            }
            value = fileInputStream.read();
        }
    }
}
