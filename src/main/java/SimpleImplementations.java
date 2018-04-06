package main.java;

import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * Created by amstone326 on 4/6/18.
 */
public class SimpleImplementations {

    public static List<String> toUpperCase(List<String> collection) {
        return collection.stream().map(String::toUpperCase).collect(toList());
    }

}
