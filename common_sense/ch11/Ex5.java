public class Ex5 {

    static int uniquePaths(int rows, int columns) {
        if (rows == 1 || columns == 1) {
            return 1;
        }
        return uniquePaths(rows - 1, columns) + uniquePaths(rows, columns - 1);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2));
        System.out.println(uniquePaths(3, 3));
    }

}
