package test;

import main.java.util.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import static java.util.Arrays.asList;
import static main.java.katas.SimpleImplementations.filterToLessThanFour;
import static main.java.katas.SimpleImplementations.flattenList;
import static main.java.katas.SimpleImplementations.getOldestPerson;
import static main.java.katas.SimpleImplementations.sum;
import static main.java.katas.SimpleImplementations.toUpperCase;

/**
 * Created by amstone326 on 4/6/18.
 */
public class KataTests {

    @Test
    public void testToUpperCase() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");
        Assert.assertEquals(expected, toUpperCase(collection));
    }

    @Test
    public void testFilter() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");
        Assert.assertEquals(expected, filterToLessThanFour(collection));
    }

    @Test
    public void testFlatten() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"),
                asList("Sara", "Samantha"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third", "Sara", "Samantha");
        Assert.assertEquals(expected, flattenList(collection));
    }

    @Test
    public void testGetOldestPerson() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Assert.assertEquals(eva, getOldestPerson(collection));
    }

    @Test
    public void testSum() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        Assert.assertEquals((1 + 2 + 3 + 4 + 5), sum(numbers));
    }

}
