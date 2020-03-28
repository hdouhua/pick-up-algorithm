package app.tree;

import java.util.Random;

/**
 * Main
 */
public class Main {

    static double testHeap(final Integer[] testData, boolean isHeapify) throws Exception {
        final long startTime = System.nanoTime();

        int n = testData.length;

        MaxHeap<Integer> heap;
        if (isHeapify) {
            heap = new MaxHeap<>(testData);
        } else {
            heap = new MaxHeap<>(n);
            for (int i = 0; i < n; i++) {
                heap.add(testData[i]);
            }
        }

        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new Exception("Error");
            }
        }

        final long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000_000.0;
    }

    public static void main(final String[] args) throws Exception {

        final int n = 1_000_000;
        final Integer[] arr = new Integer[n];
        final Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        testHeap(arr, false);
        testHeap(arr, true);
        System.out.printf("Without Heapify: %f\n", testHeap(arr, false));
        System.out.printf("Heapify: %f\n", testHeap(arr, true));

        System.out.println("Text MaxHeap Completed");
    }
}