package org.example;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteToFile {
    public static void writeToFile(List<String> lines, String filename) { // метод создает файл с абзацем
        try (FileWriter fileWriter = new FileWriter(filename);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

