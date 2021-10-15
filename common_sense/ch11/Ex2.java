import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex2 {

    static int[] evenNumbers(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }
        var value = array[0];
        var output = value % 2 == 0 ? new int[]{value} : new int[0];
        return IntStream.concat(
                Arrays.stream(output),
                Arrays.stream(evenNumbers(Arrays.copyOfRange(array, 1, array.length)))
        ).toArray();
    }

    public static void main(String[] args) {
        for (var i : evenNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})) {
            System.out.println(i);
        }
    }

}
