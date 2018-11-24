package binary_tree;

import java.util.ArrayList;

public class Tree<K  extends Comparable<K>, V> {

    private Node root;

    static private class Node<K, V> {
        
        K key;
        V value;

        Node<K, V> left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
    }

    Tree(K key, V value) {
        this.root = new Node(key, value);
    }

    Tree(Node root) {
        this.root = root;
    }

    Tree() { }

    private Node getNode(K key) {
        Node<K, V> el = root;
        while (el != null) {
            int d = key.compareTo(el.key);
            if (d == 0) {
                return el;
            }
            el = d < 0 ? el.left : el.right;
        }
        return null;
    }

    public V get(K key) {
        Node<K, V> node = this.getNode(key);
        return node == null ? null : node.value;
    }

    public void add(K key, V value) {
        Node<K, V> el = root, parent = null;

        while (el != null) {
            int d = key.compareTo(el.key);
            if (d == 0) {
                el.value = value;
                return;
            }
            parent = el;
            el = d < 0 ? el.left : el.right;
        }

        Node<K, V> newNode = new Node<>(key, value);

        if (parent == null) {
            this.root = newNode;
        } else if (key.compareTo(parent.key) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public void remove(K key) {
        Node<K, V> el = root, parent = null;

        while (el != null) {
            int d = key.compareTo(el.key);
            if (d == 0) {
                break;
            } else {
                parent = el;
                el = d < 0 ? el.left : el.right;
            }
        }

        if (el == null) {
            return;
        }

        if (el.right == null) {
            if (parent == null) {
                this.root = el.left;
            } else if (el == parent.left) {
                parent.left = el.left;
            } else {
                parent.right = el.left;
            }
        } else {
            Node<K, V> leftNode = el.right;
            parent = null;

            while (leftNode.left != null) {
                parent = leftNode;
                leftNode = leftNode.left;
            }

            if (parent == null) {
                el.right = leftNode.right;
            } else {
                parent.left = leftNode.right;
            }

            el.key = leftNode.key;
            el.value = leftNode.value;
        }
    }

    public ArrayList<V> toList() {

        ArrayList<V> result = new ArrayList<>();

        if (this.root != null) {
            result.addAll(new Tree(this.root.left).toList());
            result.add((V)this.root.value);
            result.addAll(new Tree(this.root.right).toList());
        }

        return result;
    }

}
