package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesLab2509;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\Oleg\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File file = path.toFile();
        
        File[] arrFile = file.listFiles();

        if (arrFile != null) {
            for (File resultFile : arrFile) {
                if (!resultFile.isDirectory()) {
                    System.out.printf("%s: [%d]%n", resultFile.getName(), resultFile.length());
                }
            }
        }
    }
}
