package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.example.WriteToFile.writeToFile;

public class Main {
    public static void main(String[] args) {
        String inputline; // временно хранит каждую строку, прочитанную из файла
        int partNo = 1; // отслеживание порядкового номера абзаца
        ArrayList<String> paragraf = new ArrayList<>(); // в параграф записывается абзац, затем будет очищаться

        try (FileReader fileReader = new FileReader("poem.txt");
             BufferedReader reader = new BufferedReader(fileReader)) { // для чтения по одной строке

            while ((inputline = reader.readLine()) != null) {
                if (!inputline.trim().isEmpty()) {
                    paragraf.add(inputline);
                } else if (!paragraf.isEmpty()) {
                    writeToFile(paragraf, "part" + partNo++);
                    paragraf.clear();
                }
            }
            if (!paragraf.isEmpty()) {
                writeToFile(paragraf, "part" + partNo++);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
