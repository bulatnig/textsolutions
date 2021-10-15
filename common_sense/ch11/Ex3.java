public class Ex3 {

    static int triangularNumber(int n) {
        if (n == 1) {
            return 1;
        }
        return n + triangularNumber(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(triangularNumber(7));
    }

}
