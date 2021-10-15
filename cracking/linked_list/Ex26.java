class Ex26 {
    static class Node {
        String value;
        Node next;

        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static boolean isPalindrome(Node head) {
        var len = findLength(head);
        var left = head;                        // a
        var right = left.next;                  // b
        for (var i = 1; i < len / 2; i++) {
            var temp = right.next;                // c
            right.next = left;                    // b -> a
            left = right;                         // b
            right = temp;                         // c
        }
        if (len % 2 > 0) {
            right = right.next;
        }
        for (var i = 0; i < len / 2; i++) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    static int findLength(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + findLength(node.next);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(new Node("a", new Node("b", new Node("a", null)))));
        System.out.println(isPalindrome(new Node("a", new Node("a", null))));
        System.out.println(isPalindrome(new Node("a", new Node("b", new Node("b", new Node("a", null))))));
        System.out.println(isPalindrome(new Node("a", new Node("b", new Node("c", new Node("a", null))))));
        System.out.println(isPalindrome(new Node("a", new Node("b", new Node("c", new Node("a", new Node("b", null)))))));
    }

}