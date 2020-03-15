package app.queue;

import java.util.Random;

/**
 * Main
 */
public class Main {

    /**
     * get elapsed seconds:
     * enqueue/dequeue no. of opCount Queue
     * @param q
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000_000.0;
    }

    public static void main(String[] args) {
        int opCount = 100_000;
        
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double eplased = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, eplased: " + eplased +"s");

        LoopArrayQueue<Integer> loopArrayQueue = new LoopArrayQueue<>();
        eplased = testQueue(loopArrayQueue, opCount);
        System.out.println("LoopArrayQueue, eplased: " + eplased +"s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        eplased = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue, eplased: " + eplased +"s");
    }
}