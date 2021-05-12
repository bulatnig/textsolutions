public class Ex48 {
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

    // return first common ancestor or null if it doesn't exist
    Node findFirstCommonAncestor(Node root, Node node1, Node node2) {
        if (node1 == node2) {
            throw new IllegalArgumentException("Two different nodes should be provided for search");
        }
        if (node1 == root || node2 == root) {
            return null;  // root can't have common ancestor with any other node
        }
        Node result = searchRecursively(root, node1, node2);
        return result != node1 && result != node2 ? result : null;
    }

    Node searchRecursively(Node node, Node node1, Node node2) {
        if (node == null) {
            return null;
        }
        if (node1 == node || node2 == node) {
            return node;
        }
        Node leftResult = searchRecursively(node.left, node1, node2);
        Node rightResult = searchRecursively(node.right, node1, node2);
        if (leftResult != null && rightResult != null) {
            return node;  // current node is the common ancestor
        } else if (leftResult != null) {
            return leftResult;
        } else if (rightResult != null) {
            return rightResult;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(4);
        root.right.right = new Node(10);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right.right.right = new Node(11);

//        Node result = new Ex48().findFirstCommonAncestor(root, root.left.left.right, root.left.right.left);
        Node result = new Ex48().findFirstCommonAncestor(root, root.left.left.right, new Node(12));
        System.out.println(result);
    }

}