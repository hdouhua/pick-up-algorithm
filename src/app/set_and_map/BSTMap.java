package app.set_and_map;

/**
 * BSTMap
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
        root = addNode(root, key, value);
    }

    private Node addNode(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = addNode(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = addNode(node.right, key, value);
        } else {
            // overwrite
            node.value = value;
        }

        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = removeElement(root, key);
            return node.value;
        }
        return null;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node removeElement(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = removeElement(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = removeElement(node.right, key);
            return node;
        } else {
            // found it

            if (node.left == null) {
                Node newRoot = node.right;
                node.right = null;
                size--;
                return newRoot;
            }
            if (node.right == null) {
                Node newRoot = node.left;
                node.left = null;
                size--;
                return newRoot;
            }

            Node successor = minimum(node.right);
            successor.right = removeElement(node.right, successor.key);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(root, key);
        return node != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}