package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesExercises2709;

import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String pathInput = "C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        FileInputStream fileInputStream = new FileInputStream(pathInput);
        InputStreamReader inputStream = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(inputStream);
        FileOutputStream out = new FileOutputStream("C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\AllBytes");
        BufferedWriter writer = new BufferedWriter(new PrintWriter(out));

        String line = reader.readLine();
        int punctuations = 0;
        int vowels = 0;
        int consonants = 0;

        while (line != null) {
            for (char symbol : line.toCharArray()) {
                if (symbol == ' ') {
                    continue;
                }else if (symbol == ',') {
                    punctuations++;
                }else if (symbol == 'a' || symbol == 'e' || symbol == 'o' || symbol == 'i' || symbol == 'u') {
                    vowels++;
                }else {
                    consonants++;
                }
            }
            line = reader.readLine();
        }
        writer.write("Vowels: " + vowels + System.lineSeparator());
        writer.write("Consonants: " + consonants + System.lineSeparator());
        writer.write("Punctuation: " + punctuations + System.lineSeparator());
        writer.close();
    }
}
