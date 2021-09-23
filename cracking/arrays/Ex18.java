
class Ex18 {

    static void zerofy(int[][] matrix) {
        var zerofyFirstRow = isFirstRowHasZeroes(matrix);
        var zerofyFirstColumn = isFirstColumnHasZeroes(matrix);
        reflectZeroesToFirstRowAndColumn(matrix);
        zerofyColumnsExceptFirst(matrix);
        zerofyRowsExceptFirst(matrix);
        if (zerofyFirstRow) {
            zerofyFirstRow(matrix);
        }
        if (zerofyFirstColumn) {
            zerofyFirstColumn(matrix);
        }
    }

    static boolean isFirstRowHasZeroes(int[][] matrix) {
        for (var i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                return true;
            }
        }
        return false;
    }

    static boolean isFirstColumnHasZeroes(int[][] matrix) {
        for (var i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                return true;
            }
        }
        return false;
    }

    private static void reflectZeroesToFirstRowAndColumn(int[][] matrix) {
        for (var i = 1; i < matrix.length; i++) {
            for (var j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
    }

    private static void zerofyColumnsExceptFirst(int[][] matrix) {
        for (var j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (var i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void zerofyRowsExceptFirst(int[][] matrix) {
        for (var i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (var j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void zerofyFirstRow(int[][] matrix) {
        for (var j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 0;
        }
    }

    private static void zerofyFirstColumn(int[][] matrix) {
        for (var i = 1; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        var matrix = new int[][]{
                {1, 2, 0, 4},
                {5, 6, 7, 8},
                {9, 0, 10, 11},
        };
        zerofy(matrix);
        System.out.println(matrix);
    }

}