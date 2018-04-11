package test.bookexercises;

import main.java.bookexercises.Chapter1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by amstone326 on 4/11/18.
 */
public class Chapter1Tests {

    File parentDir;
    File subDir1;
    File subDir2;
    File xmlFile;
    File txtFile;
    File txtFile2;
    File fileInSubDir1;
    File fileInSubDir2;
    File[] allFiles;

    @Before
    public void setup() {
        parentDir = new File("root/");
        subDir1 = new File(parentDir, "subdir1");
        subDir2 = new File(parentDir, "subdir2");
        xmlFile = new File(parentDir, "somefile.xml");
        txtFile = new File(parentDir, "somefile.txt");
        txtFile2 = new File(parentDir, "somefile2.txt");
        fileInSubDir1 = new File(subDir1, "child.txt");
        fileInSubDir2 = new File(subDir2, "child.xml");
        allFiles = new File[]{parentDir, subDir1, subDir2, xmlFile, txtFile, txtFile2, fileInSubDir1, fileInSubDir2};
    }

    @Test
    public void testGetSubdirectories() {
        File[] expected = new File[]{subDir1, subDir2};
    }
}
