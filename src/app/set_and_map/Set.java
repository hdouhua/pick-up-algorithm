package app.set_and_map;

/**
 * Set
 */
public interface Set<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    Integer getSize();
    boolean isEmpty();
}