package main.java.bookexercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    // exercise 4
    private static void intStream() {
        int[] values = {1, 7, 9, 12, 15};
        IntStream stream = Arrays.stream(values);
        stream.forEach(System.out::println);
    }

    // exercise 5
    private static Stream<Long> generateInfiniteStream(long seed) {
        final long a = 252149037;
        final int c = 11;
        final long m = (long)Math.pow(2, 30);
        return generateInfiniteStream(seed, a, c, m);
    }

    private static Stream<Long> generateInfiniteStream(long seed, long a, int c, long m) {
        return Stream.iterate(seed, x -> (a*x + c) % m);
    }

    // exercise 6
    private static Stream<Character> wordToCharStream(String word) {
        return Stream.iterate(0, x -> x+1).limit(word.length()).map(word::charAt);
    }

    // exercise 8 - COME BACK TO THIS
    private static <T> Stream<T> zip(Stream<T> stream1, Stream<T> stream2) {
        List<T> zipped = new LinkedList<>();
        boolean from1 = true;
        while (stream1.count() > 0 || stream2.count() > 0) {
            Stream<T> primary = from1 ? stream1 : stream2;
            Stream<T> secondary = from1 ? stream2 : stream1;
            Stream<T> removedFrom;
            try {
                zipped.add(primary.findFirst().orElseThrow(NoSuchElementException::new));
                primary = primary.skip(1);
            } catch (NoSuchElementException e) {
                zipped.add(secondary.findFirst().get());
                secondary = secondary.skip(1);
            }
            from1 = !from1;
        }
        return zipped.stream();
    }


    public static void main(String[] args) {
        //testParallelIsFaster(args[0]);

        //intStream();

        //generateInfiniteStream(98787).limit(100).forEach(System.out::println);

        //wordToCharStream("apple cider").forEach(System.out::println);


    }

}
