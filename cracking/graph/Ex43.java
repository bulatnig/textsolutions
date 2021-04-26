import java.util.*;

public class Ex43 {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node(" + value + ")";
        }
    }

    public static List<List<Node>> list_depths(Node node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<List<Node>> result = new ArrayList<>();
        Ex43.list_depth(new LinkedList<>(Collections.singletonList(node)), result);
        return result;
    }

    private static void list_depth(LinkedList<Node> nodes, List<List<Node>> result) {
        if (nodes.isEmpty()) {
            return;
        }
        var childNodes = new LinkedList<Node>();
        for (Node node : nodes) {
            if (node.left != null) {
                childNodes.add(node.left);
            }
            if (node.right != null) {
                childNodes.add(node.right);
            }
        }
        result.add(nodes);
        list_depth(childNodes, result);
    }

    public static void main(String[] args) {
        var node1 = new Node(1);
        node1.left = new Node(2);
        node1.right = new Node(3);
        node1.left.left = new Node(4);
        node1.left.right = new Node(5);
        node1.right.left = new Node(6);
        node1.right.right = new Node(7);
        List<List<Node>> result = Ex43.list_depths(node1);
        System.out.println(result);
    }

}