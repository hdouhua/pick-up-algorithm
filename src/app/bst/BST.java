package app.bst;

import java.util.IllegalFormatFlagsException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BST: binary search tree
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (node.e.compareTo(e) > 0) {
            node.left = add(node.left, e);
        } else if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    public boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (node.e.equals(e)) {
            return true;
        }

        if (node.e.compareTo(e) > 0) {
            return contains(node.left, e);
        }

        return contains(node.right, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Non-recursive traversal
     * 
     * 1) push node
     * 
     * 2) pop, push right & left
     * 
     * 3) loop 2)
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }

    }

    public E minimum() {
        if (size == 0) {
            throw new IllegalFormatFlagsException("BST is empty");
        }

        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalFormatFlagsException("BST is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() {
        if (size == 0) {
            throw new IllegalFormatFlagsException("BST is empty");
        }

        // E e = minimum();
        // root = removeMin(root);
        // return e;

        return removeMin(root, null).e;
    }

    private Node removeMin(Node node, Node parent) {
        if (node.left == null) {
            if (parent == null) {
                root = node.right;
            } else {
                parent.left = node.right;
            }
            size--;
            return node;
        }
        return removeMin(node.left, node);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            // return node.right
            // specially handle for GC
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        if (size == 0) {
            throw new IllegalFormatFlagsException("BST is empty");
        }

        E e = maximum();
        root = removeMax(root);
        return e;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            size--;
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = { 5, 3, 6, 8, 4, 2 };
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
        bst.preOrder();
        System.out.println("-----");

        bst.preOrderNR();
        System.out.println("-----");

        bst.levelOrder();
        System.out.println("-----");

        // bst.inOrder();
        // System.out.println("-----");
        // bst.postOrder();
        // System.out.println("-----");

        // System.out.println(bst.contains(4));
        // System.out.println(bst.contains(7));
        // System.out.println("-----");

        System.out.println(bst.minimum());
        System.out.println("-----");
        // System.out.println(bst.maximum());
        // System.out.println("-----");

        Integer removed = bst.removeMin();
        System.out.println(removed);
        System.out.println("-----");
        bst.preOrder();
        System.out.println("-----");

        removed = bst.removeMax();
        System.out.println(removed);
        System.out.println("-----");
        bst.preOrder();
        System.out.println("-----");
    }
}