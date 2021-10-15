class Ex27 {

    static class Node {
        String value;
        Node next;
        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static Node findIntersection(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        var len1 = countElements(head1);
        var len2 = countElements(head2);
        var pointer1 = head1;
        var pointer2 = head2;
        var diff = len1 - len2;
        if (diff > 0) {
            pointer1 = skip(pointer1, diff);
        } else if (diff < 0) {
            pointer2 = skip(pointer2, -diff);
        }
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }

    static int countElements(Node node) {
        var count = 1;
        while (node.next != null) {
            node = node.next;
            count += 1;
        }
        return count;
    }

    static Node skip(Node node, int n) {
        for (; n > 0; n--) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        Node common = new Node("D", new Node("F", null));
        Node head1 = new Node("A", new Node("B", new Node("C", common)));
        Node head2 = new Node("X", new Node("Y", common));
        Node result = findIntersection(head1, head2);
        System.out.println(result.value);
    }

}