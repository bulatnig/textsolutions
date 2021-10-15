class Ex25 {
    static class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static Node sumReverseOrder(Node node1, Node node2) {
      return sumReverseOrder(node1, node2, false);
    }

    static Node sumReverseOrder(Node node1, Node node2, boolean overflow) {
        if (node1 == null && node2 == null && !overflow) {
            return null;
        }
        var sum = 0;
        if (overflow) {
            sum += 1;
            overflow = false;
        }
        if (node1 != null) {
            sum += node1.value;
            node1 = node1.next;
        }
        if (node2 != null) {
            sum += node2.value;
            node2 = node2.next;
        }
        if (sum >= 10) {
            sum = sum % 10;
            overflow = true;
        }
        return new Node(sum, sumReverseOrder(node1, node2, overflow));
    }

    static Node sumForwardOrder(Node node1, Node node2) {
        var len1 = findListLength(node1);
        var len2 = findListLength(node2);
        if (len1 > len2) {
            node2 = padLeft(node2, len1-len2);
        } else {
            node1 = padLeft(node1, len2-len1);
        }
        var pair = sumForwardOrderRecursively(node1, node2);
        if (pair.overflow > 0) {
            return new Node(pair.overflow, pair.node);
        } else {
            return pair.node;
        }
    }

    static int findListLength(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + findListLength(node.next);
    }

    static Node padLeft(Node node, int count) {
        if (count == 0) {
            return node;
        }
        return new Node(0, padLeft(node, count - 1));
    }

    static Pair sumForwardOrderRecursively(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return new Pair(null, 0);
        }
        var sum = 0;
        if (node1 != null) {
            sum += node1.value;
            node1 = node1.next;
        }
        if (node2 != null) {
            sum += node2.value;
            node2 = node2.next;
        }
        var pair = sumForwardOrderRecursively(node1, node2);
        sum += pair.overflow;
        var value = sum % 10;
        var overflow = sum / 10;
        return new Pair(new Node(value, pair.node), overflow);
    }

    static class Pair {
        Node node;
        int overflow;
        Pair(Node node, int overflow) {
            this.node = node;
            this.overflow = overflow;
        }
    }

    public static void main(String[] args) {
        var result = sumReverseOrder(new Node(7, new Node(1, new Node(6, null))), new Node(5, new Node(9, new Node(2, null))));
        System.out.println(toString(result));
        result = sumReverseOrder(new Node(9, null), new Node(9, null));
        System.out.println(toString(result));
        result = sumReverseOrder(new Node(0, null), new Node(0, null));
        System.out.println(toString(result));
        result = sumForwardOrder(new Node(6, new Node(1, new Node(7, null))), new Node(2, new Node(9, new Node(5, null))));
        System.out.println(toString(result));
        result = sumForwardOrder(new Node(1, new Node(2, new Node(3, null))), new Node(9, null));
        System.out.println(toString(result));
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