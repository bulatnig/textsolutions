public class Ex4 {

    static int findXIndex(String input) {
        if (input.charAt(0) == 'x') {
            return 0;
        } else {
            return 1 + findXIndex(input.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(findXIndex("abcdefghijklmnopqrstuvwxyz"));
    }

}
