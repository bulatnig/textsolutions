class Ex16 {

    static String compress(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        var compressed = new StringBuilder();
        char prev = input.charAt(0);
        var counter = 1;
        for (var i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == prev) {
                counter++;
                continue;
            }
            compressed.append(prev);
            compressed.append(counter);
            prev = current;
            counter = 1;
        }
        compressed.append(prev);
        compressed.append(counter);
        return compressed.length() < input.length() ? compressed.toString() : input;
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("aaa"));
        System.out.println(compress("aab"));
    }

}