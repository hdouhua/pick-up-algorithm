package app.link;

/**
 * LinkedList
 * time complecity: add/remove/set - O(n)
 */
public class LinkedList<E> {

    /**
     * set the modifier private because user don't need to know the internal data structure
     */
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

    // private Node head;
    private Node dummyHead;
    private int size;

    public LinkedList() {
        // head = null;
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
         if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        // if(index == 0) {
        //     this.addFirst(e);
        // }else {
            // Node prev = head;
            // for (int i = 0; i < index - 1; i++){
            //     prev = prev.next;
            // }

            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }

            prev.next = new Node(e, prev.next);
            size++;
        // }
    }

    public void addFirst(E e) {
        // Node node = new Node(e);
        // node.next = head;
        // head = node;
        // => 
        // head = new Node(e, head);
        add(0, e);
    }

    public void addLast(E e){
        this.add(size -1, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.e;
    }

    public E getFirst() {
       return this.get(0);
    }

    public E getLast() {
        return this.get(size-1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    public boolean contains(E e) {
        Node current = dummyHead.next;
        while(current != null) {
            if(current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node removedNode = prev.next;
        prev.next = removedNode.next;
        removedNode.next = null;
        size--;

        return removedNode.e;
    }

    public E removeFirst(){
        return this.remove(0);
    }

    public E removeLast(){
        return this.remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = dummyHead.next;
        while(current != null) {
            sb.append(current.e.toString() + " -> ");
            current = current.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}