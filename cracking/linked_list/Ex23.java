class Ex23 {

    static class Node {
        String value;
        Node next;
        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static void deleteMiddleNode(Node node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        var head = new Node("a", new Node("b", new Node("c", new Node("d", new Node("e", new Node("f", null))))));
        System.out.println(toString(head));
        deleteMiddleNode(head.next.next);
        System.out.println(toString(head));

        head = new Node("a", new Node("b", new Node("c", null)));
        System.out.println(toString(head));
        deleteMiddleNode(head.next);
        System.out.println(toString(head));
    }

    private static String toString(Node head) {
        var sb = new StringBuilder();
        sb.append(head.value);
        var node = head.next;
        while (node != null) {
            sb.append(" - ");
            sb.append(node.value);
            node = node.next;
        }
        return sb.toString();
    }


}