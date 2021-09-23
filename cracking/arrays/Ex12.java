class Ex12 {
    static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        var counters = new int[256];
        for (char c : s1.toCharArray()) {
            counters[c] += 1;
        }
        for (char c : s2.toCharArray()) {
            counters[c] -= 1;
        }
        for (int counter : counters) {
            if (counter != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("a", "b"));
        System.out.println(isPermutation("abcd", "bcad"));
        System.out.println(isPermutation("c", "abc"));
    }
}