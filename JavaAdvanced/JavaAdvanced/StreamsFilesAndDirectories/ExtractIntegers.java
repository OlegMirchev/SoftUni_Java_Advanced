package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesLab2509;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Oleg\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput");

        PrintStream out = new PrintStream(outputStream);

        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                out.println(number);
            }
            scanner.next();
        }
        fileInputStream.close();
        outputStream.close();
    }
}
