package main.java.katas;

import main.java.util.Person;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by amstone326 on 4/6/18.
 *
 * Taken from https://technologyconversations.com/2014/11/04/java-8-streams-micro-katas/
 */
public class SimpleImplementations {

    public static List<String> toUpperCase(List<String> collection) {
        return collection.stream().map(String::toUpperCase).collect(toList());
    }

    public static List<String> filterToLessThanFour(List<String> collection) {
        return collection.stream().filter(s -> s.length() < 4).collect(toList());
    }

    // the mapping function f passed to flatMap() must produce a stream, because flatMap() operates by applying f to
    // each element in the input, and then adding all the elements of each resulting stream to the final "flattened"
    // output stream
    public static List<String> flattenList(List<List<String>> collection) {
        return collection.stream().flatMap(Collection::stream).collect(toList());
    }

    public static Person getOldestPerson(List<Person> collection) {
        return collection.stream().max(Comparator.comparing(Person::getAge)).get();
        //return collection.stream().collect(Collectors.toMap(Person::getAge, Function.identity()));
    }

    public static int sum(List<Integer> collection) {
        return collection.stream().reduce(0, (totalSoFar, next) -> totalSoFar + next);
    }
}
