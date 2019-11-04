package app.array;

/**
 * manually define Array
 * @param <E> cannot be basic type: boolean, byte, char, short, int, long, float, double
 */
public class Array<E> {

    private E[] data;
    private int size;

    /***
     * 
     * @param capacity
     */
    public Array(int capacity) {
        // data = new E[capacity]; // cannot support new generic type in this way
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * default capacity: 10
     */
    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >0 and index <= size");
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", this.size, this.getCapacity()));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');

        return sb.toString();
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        return this.data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        this.data[index] = e;
    }

    boolean contains(E e) {
        for (E x : data) {
            if (x.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /***
     * find the index of value
     * 
     * @param e : the value
     * @return
     */
    int find(E e) {
        for (int i = 0; i < size; i++) {
            if (this.data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        E val = this.data[index];
        for (int i = index; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        size--;
        this.data[size] = null; // this is optional, to let java GC collect (this is loitering object != memory leak)
        return val;
    }

    E removeFirst() {
        return remove(0);
    }

    E removeLast() {
        return remove(this.size - 1);
    }

    boolean removeElement(E e) {
        int index = find(e);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }
}
