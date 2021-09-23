class Ex17 {

    static void rotate(int[][] image) {
        for (var i = 0; i < image.length / 2; i++) {
            var end = image.length - 1 - i;
            for (var j = i; j < end; j++) {
                var temp = image[i][j];
                image[i][j] = image[image.length - 1 - j][i];
                image[image.length - 1 - j][i] = image[image.length - 1 - i][image.length - 1 - j];
                image[image.length - 1 - i][image.length - 1 - j] = image[j][image.length - 1 - i];
                image[j][image.length - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        var matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
//        rotate(matrix);
        matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
        rotate(matrix);
        System.out.println(matrix);
    }

}