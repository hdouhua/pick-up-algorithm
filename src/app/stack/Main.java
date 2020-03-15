package app.stack;

import java.util.Random;

/**
 * Main
 */
public class Main {

    static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000_000.0;
    }

    public static void main(String[] args) {
        int opCount = 100_000;
        
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double eplased = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, eplased: " + eplased +"s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        eplased = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, eplased: " + eplased +"s");
    }
}