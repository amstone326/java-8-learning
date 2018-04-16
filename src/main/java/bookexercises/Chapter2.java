package main.java.bookexercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amstone326 on 4/16/18.
 */
public class Chapter2 {

    // exercise 3
    public static void testParallelIsFaster(String textFile) {
        List<String> words = parseWordsFromFile(textFile);

        long start = System.currentTimeMillis();
        long count = countLongWords(words);
        long end = System.currentTimeMillis();
        System.out.println("Not-parallelized count took " + (end-start) + " millis");

        start = System.currentTimeMillis();
        count = countLongWordsParallel(words);
        end = System.currentTimeMillis();
        System.out.println("Parallelized count took " + (end-start) + " millis");
    }

    private static List<String> parseWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e) {
            System.out.println("IOException while parsing " + filename);
            e.printStackTrace();
        }
        return words;
    }

    private static long countLongWords(List<String> words) {
        return words.stream().filter(w -> w.length() > 10).count();
    }

    private static long countLongWordsParallel(List<String> words) {
        return words.parallelStream().filter(w -> w.length() > 10).count();
    }

    public static void main(String[] args) {
        testParallelIsFaster(args[0]);
    }
}
