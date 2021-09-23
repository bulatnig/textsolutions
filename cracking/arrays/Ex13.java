class Ex13 {

    static void urlify(char[] s, int true_length) {
        var p1 = true_length - 1;
        var p2 = s.length - 1;
        for (; p1 != p2; p1--, p2--) {
            if (s[p1] == ' ') {
                s[p2] = '0';
                p2--;
                s[p2] = '2';
                p2--;
                s[p2] = '%';
            } else {
                s[p2] = s[p1];
            }
        }
    }

    public static void main(String[] args) {
        var s = "Mr John Smith    ".toCharArray();
        urlify(s, 13);
        System.out.println(new String(s));
        s = " Hi  ".toCharArray();
        urlify(s, 3);
        System.out.println(new String(s));
        s = "World".toCharArray();
        urlify(s, 5);
        System.out.println(new String(s));
    }

}