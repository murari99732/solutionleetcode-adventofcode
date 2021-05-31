import java.io.StringWriter;
import java.util.*;

public class DoubleLinkedList {
    static class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;
    }

    static Set<Node> set = new HashSet<>();

    static <T> Node<T> addArFirst(Node<T> node, T value) {
        if (node == null) {
            return createNode(value);
        }
        Node<T> curr = node;
        Node<T> temp = createNode(value);
        temp.next = curr;
        curr.previous = temp;
        node = curr;
        return node;

    }

    static <T> Node<T> addAtLast(Node<T> root, T value) {
        if (root == null) {
            return createNode(value);
        }
        Node<T> node = root;

        while (node.next != null) {
            node = node.next;
        }
        Node<T> curr = node;
        Node<T> temp = createNode(value);
        curr.next = temp;
        temp.previous = curr;
        return root;
    }

    static <T> Node<T> addAtPosition(Node<T> root, T value, int i) {
        if (root == null) {
            return createNode(value);
        }

        Node<T> node = root;
        int indx = 0;
        while (node.next != null && indx != i) {
            node = node.next;
            i++;
        }
        if (indx != i) {
            System.out.println("No position +" + i);
            return node;
        }
        Node<T> next = null;
        Node<T> curr = node;
        if (curr.next != null) {
            next = curr.next;
        }
        Node<T> temp = createNode(value);
        if (next == null) {
            curr.next = temp;
            temp.previous = curr;
        } else {
            curr.next = temp;
            temp.next = next;
            next.previous = temp;
            temp.previous = curr;
        }
        return root;
    }

    static <T> Node<T> deleteAtFirst(Node<T> node) {
        if (node == null || node.next == null) {
            if (node.next == null) {
                set.remove(node);
            }
            return null;
        }
        Node<T> curr = node.next;
        set.remove(curr);
        curr.previous = null;
        node = curr;
        return node;
    }

    static <T> Node<T> deleteAtLast(Node<T> root) {
        if (root == null || root.next == null) {
            if (root.next == null) {
                set.remove(root);
            }
            return null;
        }
        Node<T> node = root;
        Node curr = null;
        while (node.next != null) {
            curr = node;
            node = node.next;
        }
        Node<T> temp = node;
        set.remove(temp);
        temp.previous = null;
        curr.next = null;
        return root;
    }

    static <T> Node<T> deleteAtPositon(Node<T> root, int i) {
        if (root == null) {
            return null;
        }
        if (i == 0) {
            return deleteAtFirst(root);
        }
        Node<T> node = root;
        int indx = 0;
        while (node.next != null && indx != i) {
            indx++;
            node = node.next;
        }
        if (indx != i) {
            System.out.println("No position");
            return root;
        }
        Node curr = node;
        Node temp1 = curr.next;
        Node temp2 = temp1.next;
        set.remove(temp1);
        temp1.previous = null;
        temp1.next = null;
        curr.next = temp2;
        temp2.next = curr;
        return root;
    }

    static <T> void findTheNode(T value) {
        if (set.contains(value)) {

            System.out.println("found");
        } else {
            System.out.println("not found");
        }


    }

    private static <T> Node<T> createNode(T value) {
        Node<T> node = new Node<>();

        node.data = value;
        set.add(node);
        return node;
    }

}
