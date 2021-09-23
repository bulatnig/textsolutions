import java.util.Arrays;

public class Ex11 {

    static boolean isUnique(String input) {
        var characters = input.toCharArray();
        Arrays.sort(characters);
        for (int i = 1; i < characters.length; i++) {
            if (characters[i] == characters[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Ex11.isUnique("abdcefg"));
        System.out.println(Ex11.isUnique("abdcea"));
        System.out.println(Ex11.isUnique(""));
    }
}
