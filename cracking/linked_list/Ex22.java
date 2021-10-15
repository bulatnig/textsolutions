class Ex22 {

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    static Node findKthToLast(Node head, int k) {
        var pointer1 = head;
        for (int i = 1; i < k; i++) {
            pointer1 = pointer1.next;
        }
        var pointer2 = head;
        while (pointer1.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer2;
    }

    public static void main(String[] args) {
        var head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, new Node(8, null))))))));
        var result = findKthToLast(head, 4);
        System.out.println(result.value);
    }

}