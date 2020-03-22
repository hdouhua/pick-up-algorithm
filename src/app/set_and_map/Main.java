package app.set_and_map;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Main
 */
public class Main {

    private static String filename = "pride-and-prejudice.txt";// "a-tale-of-two-cities.txt";

    public static void main(final String[] args) {

        // set test

        double elapsed1 = testSet(Main::analyzeSet, new LinkedListSet<String>());
        System.out.printf("LinkedListSet elapsed: %.0f ms\n", elapsed1);
        double elapsed2 = testSet(Main::analyzeSet, new BSTSet<String>());
        System.out.printf("BSTSet elapsed: %.0f ms\n", elapsed2);

        // map test

        double elapsed3 = testSet(Main::analyzeMap, new LinkedListMap<String, Integer>());
        System.out.printf("LinkedListMap elapsed: %.0f ms\n", elapsed3);
        double elapsed4 = testSet(Main::analyzeMap, new BSTMap<String, Integer>());
        System.out.printf("BSTMap elapsed: %.0f ms\n", elapsed4);

    }

    private static double testSet(Consumer<Set<String>> func, Set<String> set) {

        final long startTime = System.nanoTime();

        func.accept(set);

        final long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000;
    }

    private static double testSet(Consumer<Map<String, Integer>> func, Map<String, Integer> map) {
        final long startTime = System.nanoTime();

        func.accept(map);

        final long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000;
    }

    private static void analyzeSet(Set<String> set) {
        System.out.println(filename);
        System.out.println("---------");
        final ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("total word: " + words.size());

            // final BSTSet<String> set = new BSTSet<>();
            for (final String word : words) {
                set.add(word);
            }
            System.out.println("total differnet words: " + set.getSize());
            set.remove("prejudice");
            System.out.println("total differnet words: " + set.getSize());
        }
    }

    private static void analyzeMap(Map<String, Integer> map) {
        System.out.println(filename);
        System.out.println("---------");
        final ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("total word: " + words.size());

            // final BSTMap<String, Integer> map = new BSTMap<>();
            for (final String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("total differnet words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            map.remove("prejudice");
            System.out.println("total differnet words: " + map.getSize());
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
    }

}