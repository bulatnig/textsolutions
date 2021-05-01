import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ex45 {
    public static class Node {
        private final int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node(" + value + ")";
        }
    }

    boolean isBST(Node root) {
        return checkRecursively(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkRecursively(Node node, int min, int max) {
        if (node.value < min || node.value > max) {
            return false;
        }
        if (node.left != null) {
            if (node.value == Integer.MIN_VALUE) {
                return false;
            }
            if (!checkRecursively(node.left, min, node.value - 1)) {
                return false;
            }
        }
        if (node.right != null) {
            if (node.value == Integer.MAX_VALUE) {
                return false;
            }
            if (!checkRecursively(node.right, node.value + 1, max)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        var node1 = new Node(2);
//        node1.left = new Node(1);
//        node1.right = new Node(3);

//        var node1 = new Node(1);
//        node1.left = new Node(2);
//        node1.right = new Node(3);

//        var node1 = new Node(10);
//        node1.left = new Node(5);
//        node1.right = new Node(15);
//        node1.left.left = new Node(1);
//        node1.left.right = new Node(11);
//        node1.right.left = new Node(4);
//        node1.right.right = new Node(20);

        var node1 = new Node(5);
        node1.right = new Node(10);
        node1.right.left = new Node(7);
        node1.right.right = new Node(15);
        node1.right.right.left = new Node(12);
        node1.right.right.right = new Node(17);

        boolean result = new Ex45().isBST(node1);
        System.out.println(result);
    }

}