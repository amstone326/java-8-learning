package main.java.bookexercises;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amstone326 on 4/11/18.
 */
public class Chapter1 {

    // exercise 2
    public static File[] getSubdirectories(File parent) {
        return parent.listFiles(File::isDirectory);
    }

    // exercise 3
    public static String[] getFilesWithExtension(File parent, String extension) {
        return parent.list((dir, name) -> name.endsWith(extension));
    }

    // exercise 4
    public static List<File> sortFilesByTypeAndName(File[] files) {
        List<File> sorted = Arrays.asList(files);
        sorted.sort((f1, f2) -> {
            if (f1.isDirectory() && f2.isDirectory()) {
                return f1.getName().compareTo(f2.getName());
            } else if (f1.isDirectory()) {
                return -1;
            } else if (f2.isDirectory()) {
                return 1;
            } else {
                return f1.getName().compareTo(f2.getName());
            }
        });
        return sorted;
    }
}
