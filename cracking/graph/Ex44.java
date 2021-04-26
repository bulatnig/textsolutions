import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ex44 {
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

    public static boolean isBalanced(Node root) {
        try {
            checkSubtreeHeights(root);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    private static int checkSubtreeHeights(Node node) {
        if (node == null) {
            return 0;
        }
        int left = checkSubtreeHeights(node.left);
        int right = checkSubtreeHeights(node.right);
        if (Math.abs(left - right) > 1) {
            throw new IllegalStateException(node + " subtrees heights are " + left + " and " + right);
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
//        var node1 = new Node(1);
//        node1.left = new Node(2);
//        node1.right = new Node(3);
//        node1.left.left = new Node(4);
//        node1.left.right = new Node(5);

//        var node1 = new Node(1);
//        node1.left = new Node(2);
//        node1.right = new Node(3);
//        node1.left.left = new Node(4);
//        node1.left.right = new Node(5);
//        node1.right.left = new Node(6);
//        node1.left.left.left = new Node(7);

//        var node1 = new Node(1);
//        node1.right = new Node(2);
//        node1.right.right = new Node(3);

        var node1 = new Node(1);
        node1.left = new Node(2);
        node1.right = new Node(3);
        node1.left.left = new Node(4);
        node1.right.left = new Node(5);
        node1.left.left.left = new Node(6);
        boolean result = Ex44.isBalanced(node1);
        System.out.println(result);
    }

}