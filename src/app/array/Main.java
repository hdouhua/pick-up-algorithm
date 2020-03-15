package app.array;

public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.set(9, 99);
        System.out.println(arr);

        if(arr.contains(99)){
            System.out.println(arr.find(99));
        }

        arr.removeLast();
        System.out.println(arr);

        if(arr.removeElement(99)) {
            System.out.println(arr);
        }

        ArrayStack stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

    }
}
