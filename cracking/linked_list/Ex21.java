class Ex21 {

    static class Node {

        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static void removeDuplicates(Node head) {
        for (var p1 = head; p1 != null; p1 = p1.next) {
            var p2 = p1;
            while (p2.next != null) {
                if (p2.next.value == p1.value) {
                    p2.next = p2.next.next;
                } else {
                    p2 = p2.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        var head = new Node(1, new Node(2, new Node(3, new Node(1, new Node(4, new Node(3, null))))));
        System.out.println(toString(head));
        removeDuplicates(head);
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