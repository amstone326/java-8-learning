package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import static java.util.Arrays.asList;
import static main.java.SimpleImplementations.toUpperCase;

/**
 * Created by amstone326 on 4/6/18.
 */
public class Tests {

    @Test
    public void testToUpperCase() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");
        Assert.assertEquals(expected, toUpperCase(collection));
    }

}
