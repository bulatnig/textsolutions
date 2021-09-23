import java.util.HashMap;

class Ex14 {

    static boolean isPermutationOfPalindrome(String s) {
        var counters = new HashMap<Character, Integer>();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                counters.put(c, counters.getOrDefault(c, 0) + 1);
            }
        }
        var oddChars = counters.values().stream().filter(counter -> counter % 2 == 1).count();
        return oddChars < 2;
    }

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("Tact Coa"));
        System.out.println(isPermutationOfPalindrome("tract"));
    }

}