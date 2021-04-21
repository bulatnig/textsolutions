def rotate(matrix: list[list[int]]) -> list[list[int]]:
    size = len(matrix)
    if size < 2:
        return matrix
    circle_count = size // 2
    for i in range(0, circle_count):
        for j in range(0, size - 1 - i * 2):
            tmp = matrix[i][i + j]
            matrix[i][i + j] = matrix[size - 1 - i - j][i]
            matrix[size - 1 - i - j][i] = matrix[size - 1 - i][size - 1 - i - j]
            matrix[size - 1 - i][size - 1 - i - j] = matrix[i + j][size - 1 - i]
            matrix[i + j][size - 1 - i] = tmp
    return matrix


print(rotate([[1, 2, 3],
              [4, 5, 6],
              [7, 8, 9]]))

print(rotate([[1, 2, 3, 4],
              [5, 6, 7, 8],
              [9, 10, 11, 12],
              [13, 14, 15, 16]]))

print(rotate([[1, 2, 3, 4, 5],
              [6, 7, 8, 9, 10],
              [11, 12, 13, 14, 15],
              [16, 17, 18, 19, 20],
              [21, 22, 23, 24, 25]]))
