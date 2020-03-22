package app.set_and_map;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Main
 */
public class Main {

    public static void main(final String[] args) {

        final String file1 = "pride-and-prejudice.txt";
        // final String file2 = "a-tale-of-two-cities.txt";

        double elapsed1 = testSet(Main::analyze, file1);
        System.out.printf("elapsed: %.0f ms\n", elapsed1);
        double elapsed2 = testSet(Main::analyze2, file1);
        System.out.printf("elapsed: %.0f ms\n", elapsed2);

        // analyze(file1);
        // analyze2(file1);
        // analyze(file2);
        // analyze2(file2);

    }

    private static double testSet(final Consumer<String> func, final String filename) {
        final long startTime = System.nanoTime();

        func.accept(filename);

        final long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000;
    }

    private static void analyze(final String filename) {
        System.out.println(filename);
        System.out.println("---------");
        final ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("total word: " + words.size());

            final BSTSet<String> set = new BSTSet<>();
            for (final String word : words) {
                set.add(word);
            }
            System.out.println("total differnet words: " + set.getSize());
        }
    }

    private static void analyze2(final String filename) {
        System.out.println(filename);
        System.out.println("---------");
        final ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("total word: " + words.size());

            final LinkedListSet<String> set = new LinkedListSet<>();
            for (final String word : words) {
                set.add(word);
            }
            System.out.println("total differnet words: " + set.getSize());
        }
    }

}