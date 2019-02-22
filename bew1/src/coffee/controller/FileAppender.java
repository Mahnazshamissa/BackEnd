package coffee.controller;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender {

    public void append(String line, String filePath) {

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {

            fileWriter.append(line).append("\n");
        } catch (IOException e) {
            System.out.println("exception occoured in the FileAppender" + e);
        }
    }
}
