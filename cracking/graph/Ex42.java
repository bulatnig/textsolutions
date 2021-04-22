public class Ex42 {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node(" + value + ")";
        }
    }

    /**
     * Convert sorted array into binary search tree.
     *
     * @param array array to convert
     * @param from  array index to start from, inclusive
     * @param to    array index to finish at, exclusive
     *
     * @return  tree root node
     */
    public static Node to_binary_search_tree(int[] array, int from, int to) {
        if (from < 0 || to > array.length) {
            throw new IllegalArgumentException("Incorrect range provided from " + from + " to " + to);
        }
        if (from >= to) {
            return null;
        }
        var middle = from + (to - from) / 2;
        var root = new Node(array[middle]);
        root.left = to_binary_search_tree(array, from, middle);
        root.right = to_binary_search_tree(array, middle + 1, to);
        return root;
    }

    public static void main(String[] args) {
        Node root = Ex42.to_binary_search_tree(new int[] {1,2,3,4,5,6,7}, 0, 7);
        System.out.println(root);
    }

}