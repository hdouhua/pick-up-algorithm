package app.queue;

import app.link.LinkedList;

/**
 * LinkedListQueue
 * 
 * enqueue from tail
 * 
 * dequeue from head
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return this.e.toString();
        }
    }

    private Node head, tail;
    int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e, null);
            head = tail;
        } else {
            tail.next = new Node(e, null);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from empty queue");
        }
        Node node = head;
        head = head.next;
        node.next = null;// special for GC
        if (head == null) {
            tail = null;
        }
        size--;
        return node.e;
    }

    @Override
    public E getFront() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front ");

        Node current = head;
        while (current != null) {
            sb.append(current.e.toString() + " -> ");
            current = current.next;
        }
        sb.append("NULL tail");

        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println("<Dequeue> " + queue);
            }
        }
    }

}