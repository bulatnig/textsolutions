import java.util.Arrays;

public class Ex1 {

    static int countCharacters(String[] input) {
        if (input.length == 0) {
            return 0;
        }
        return input[0].length() + countCharacters(Arrays.copyOfRange(input, 1, input.length));
    }

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[] {"ab", "c", "def", "ghij"}));
    }

}
