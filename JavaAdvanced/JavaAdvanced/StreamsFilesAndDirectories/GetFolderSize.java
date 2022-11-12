package JavaAdvanced2021.JavaAdvanced.StreamsFilesAndDirectoriesExercises2709;

import java.io.*;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Oleg\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);
        File[] files = folder.listFiles();
        long sizeFolder = 0L;

        for (File resultFile : files) {
            sizeFolder += resultFile.length();
        }
        System.out.printf("Folder size: %d", sizeFolder);
    }
}
