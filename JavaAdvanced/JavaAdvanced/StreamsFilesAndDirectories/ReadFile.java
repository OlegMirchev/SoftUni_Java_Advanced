package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesLab2509;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = "C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        int value = fileInputStream.read();

        while (value != -1) {
            System.out.print(Integer.toBinaryString(value) + " ");
            value = fileInputStream.read();
        }
    }
}
