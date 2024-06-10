package com.enigma.gosling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    static final File fileBook = new File("src/com/enigma/gosling/db/Book.txt");


    public static void saveData(List<Book> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileBook))) {
            for (Book item : data) {
                writer.write(item.toString());
                writer.newLine();
            }
        }
    }

    public static List<Book> loadData() throws IOException {
         int counterMagazine = 0;
         int counterNovel = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileBook))) {
            List<Book> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
               String []code = data[0].split("-");
                if (code[1].equalsIgnoreCase("A")) {
                    Novel novel = new Novel(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4]);
                    if (counterNovel < Integer.parseInt(code[2])) {
                        counterNovel = Integer.parseInt(code[2]);
                    }
                    lines.add(novel);
                } else if (code[1].equalsIgnoreCase("B")) {
                    Magazine magazine = new Magazine(data[0], data[1], data[2], Integer.parseInt(data[3]));
                    if (counterMagazine < Integer.parseInt(code[2])) {
                        counterMagazine = Integer.parseInt(code[2]);
                    }
                    lines.add(magazine);
                }
            }

            InventoryUtil.setCounterMagazine(counterMagazine);
            InventoryUtil.setCounterNovel(counterNovel);
            return lines;
        }
    }



}
