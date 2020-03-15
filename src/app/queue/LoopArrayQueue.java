package app.queue;

/**
 * LoopQueue: improvement performance of ArrayQueue
 */
public class LoopArrayQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopArrayQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size =0 ;
    }

    public LoopArrayQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
         // queue is full
         if (front == (tail + 1 ) % data.length) {
            this.resize(this.getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1 ) % data.length;
        size++;
    }

    private void resize(int capacity) {
        E[] queue = (E[])new Object[capacity + 1];

        int length = data.length;
        for (int i = 0; i < size; i++) {
            queue[i] = data[(i + front) % length];
        }
        front = 0;
        tail = size;

        data = queue;
    }

    @Override
    public E dequeue() {
        if(this.isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from empty queue");
        }
        
        E e = data[front];
        data[front] = null; // for java GC
        front = (front + 1 )% data.length;
        size--;

        int capacity = this.getCapacity();
        if (capacity != 0 && size == capacity /4){
            this.resize(capacity / 2);
        }

        return e;
    }

    @Override
    public E getFront() {
        if(this.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\n", size, this.getCapacity()));

        sb.append("front [");
        int length = data.length;
        for (int i = 0; i < size; i++) {
            if(i != 0) {
                sb.append(", ");
            }
            sb.append(data[(i+front)%length].toString());
        }
        sb.append("] tail");

        return sb.toString();
    }

    public static void main(String[] args) {
        LoopArrayQueue<Integer> queue = new LoopArrayQueue<>(10);

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2) {
                queue.dequeue();
                System.out.println("<Dequeue> " + queue);
            }
        }
    }
}