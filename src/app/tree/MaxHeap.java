package app.tree;

import app.array.Array;

/**
 * MaxHeap
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    public int left(int index) {
        return index * 2 + 1;
    }

    public int right(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 
     * @param k current index
     */
    private void siftUp(int k) {
        // parent node < current node
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Cannot findMax when heap is empty");
        }
        return data.getFirst();
    }

    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {
        while (left(k) < data.getSize()) {
            int maxChildIdx = left(k);
            if (maxChildIdx + 1 < data.getSize() && data.get(maxChildIdx + 1).compareTo(data.get(maxChildIdx)) > 0) {
                // set maxChildIdx to right child
                maxChildIdx = maxChildIdx + 1;
            }
            if (data.get(k).compareTo(data.get(maxChildIdx)) > 0) {
                break;
            }
            data.swap(k, maxChildIdx);
            k = maxChildIdx;
        }
    }

    public E replaceMax(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

}