package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * Created by amstone326 on 4/22/18.
 */
public class RandomSubset {

    private static List<Integer> getRandomSubset(List<Integer> list) {
        List<List<Integer>> allSubsets = getPowerset(list);
        allSubsets.forEach(System.out::println);
        int randIndex = (int)Math.floor(Math.random() * allSubsets.size());
        return allSubsets.get(randIndex);
    }

    private static List<List<Integer>> getPowerset(List<Integer> list) {
        return list.stream().reduce(getIdentity(), getAccumulator(), getCombiner());
    }

    private static List<List<Integer>> getIdentity() {
        List<List<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>());
        return l;
    }

    private static BiFunction<List<List<Integer>>, Integer, List<List<Integer>>> getAccumulator() {
        return (listOfLists, num) -> {
            List<List<Integer>> output = new ArrayList<>(listOfLists);
            listOfLists.forEach(list -> {
                List<Integer> withNext = new ArrayList<>(list);
                withNext.add(num);
                output.add(withNext);
            });
            return output;
        };
    }

    private static BinaryOperator<List<List<Integer>>> getCombiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    public static void main(String[] args) {
        List<Integer> startingList = new ArrayList<>();
        startingList.add(1);
        startingList.add(2);
        startingList.add(3);
        startingList.add(4);
        System.out.println(getRandomSubset(startingList));
    }

    private static void test() {
        List<List<Integer>> orig = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);

        orig.add(l1);
        orig.add(l2);

        List<List<Integer>> copy = new ArrayList<>(orig);

        for (List<Integer> l : orig) {
            l.add(2);
        }

        orig.remove(0);

        System.out.println("Original: ");
        orig.forEach(System.out::println);

        System.out.println("Copy: ");
        copy.forEach(System.out::println);
    }
}
