package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesLab2509;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStream = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(inputStream);
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Oleg\\Desktop\\" +
             "04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput");

        BufferedWriter writer = new BufferedWriter(new PrintWriter(outputStream));

        String line = reader.readLine();
        int count = 1;

        while (line != null) {
            if (count % 3 == 0) {
                writer.write(line + System.lineSeparator());
            }
            line = reader.readLine();
            count++;
        }
        writer.flush();
    }
}
