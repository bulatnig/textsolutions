class Ex28 {
    static class Node {
        String value;
        Node next;
        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static Node findLoopStart(Node head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node end = new Node("E", null);
        Node start = new Node("C", new Node("D", end));
        end.next = start;
        Node head = new Node("A", new Node("B", start));
        Node result = findLoopStart(head);
        assert start == result;
    }

}


