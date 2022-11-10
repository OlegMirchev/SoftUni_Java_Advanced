package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesLab2509;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\Oleg\\Desktop\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File file = path.toFile();

        ArrayDeque<File> queueFile = new ArrayDeque<>();
        queueFile.offer(file);
        int countFile = 0;

        while (!queueFile.isEmpty()) {
            File currentFile = queueFile.poll();
            countFile++;
            System.out.println(currentFile.getName());
            File[] arrFile = currentFile.listFiles();

            if (arrFile != null) {
                for (File resultFile : arrFile) {
                    if (resultFile.isDirectory()) {
                        queueFile.offer(resultFile);
                    }
                }
            }
        }
        System.out.printf("%d folders", countFile);
    }
}
