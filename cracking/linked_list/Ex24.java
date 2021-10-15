class Ex24 {
    static class Node {
        int value;
        Node next;
        Node (int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static Node partition(Node node, int partition) {
        Node fakeHead1 = new Node(0, null);
        Node fakeHead2 = new Node(0, null);
        var pointer1 = fakeHead1;
        var pointer2 = fakeHead2;
        while (node != null) {
            if (node.value < partition) {
                pointer1.next = node;
                pointer1 = node;
            } else {
                pointer2.next = node;
                pointer2 = node;
            }
            node = node.next;
        }
        pointer1.next = fakeHead2.next;
        pointer2.next = null;
        return fakeHead1.next;
    }

    public static void main(String[] args) {
        var head = new Node(3, new Node(5, new Node(8, new Node(5, new Node(10, new Node(2, new Node(1, null)))))));
        System.out.println(toString(head));
        var result = partition(head, 5);
        System.out.println(toString(result));
        System.out.println(toString(partition(new Node(8, null), 5)));
        System.out.println(toString(partition(new Node(4, null), 5)));
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