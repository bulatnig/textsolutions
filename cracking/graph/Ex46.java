public class Ex46 {
    public static class Node {
        private final int value;
        private Node parent;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Node(" + value + ")";
        }
    }

    Node findSuccessor(Node node) {
        if (node.right != null)
            return findLeftMostNode(node.right);
        if (node.parent == null)
            return null;
        if (node.parent.left == node)
            return node.parent;
        return findParentOfLeftChild(node.parent);
    }

    Node findLeftMostNode(Node node) {
        if (node.left == null)
            return node;
        return findLeftMostNode(node.left);
    }

    Node findParentOfLeftChild(Node node) {
        if (node.parent == null) {
            return null;
        }
        if (node.parent.left == node) {
            return node.parent;
        }
        return findParentOfLeftChild(node.parent);
    }

    public static void main(String[] args) {
        var node1 = new Node(10);
        node1.left = new Node(5, node1);
        node1.left.left = new Node(3, node1.left);
        node1.left.right = new Node(8, node1.left);
        node1.right = new Node(15, node1);
        node1.right.left = new Node(12, node1.right);
        node1.right.right = new Node(17, node1.right);
        node1.right.left.right = new Node(13, node1.right);

        assert new Ex46().findSuccessor(node1.left.left).value == 5;
        assert new Ex46().findSuccessor(node1.left).value == 8;
        assert new Ex46().findSuccessor(node1.left.right).value == 10;
        assert new Ex46().findSuccessor(node1).value == 12;
        assert new Ex46().findSuccessor(node1.right.left.right).value == 15;
        assert new Ex46().findSuccessor(node1.right.right) == null;
    }

}