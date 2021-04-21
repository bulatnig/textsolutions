def zero_matrix(matrix: list[list[int]]) -> None:
    "TODO document function"
    if len(matrix) == 0 or (len(matrix) == 1 and len(matrix[0]) == 1):
        return
    M = len(matrix)
    N = len(matrix[0])
    zero_rows = [0] * M
    zero_columns = [0] * N
    for i in range(0, M):
        for j in range(0, N):
            if matrix[i][j] == 0:
                zero_rows[i] = 1
                zero_columns[j] = 1
    for i in range(0, M):
        if zero_rows[i] == 1:
            for j in range(0, N):
                matrix[i][j] = 0
    for j in range (0, N):
        if zero_columns[j] == 1:
            for i in range (0, M):
                matrix[i][j] = 0


matrix1 = [[1,2,3],
           [4, 0, 6],
           [7,8,9]]
zero_matrix(matrix1)
print(matrix1)

matrix2 = [[1, 2, 3, 4, 5],
           [6 ,7, 8, 0, 10],
           [11, 12, 13, 14, 15],
           [16, 0, 18, 19, 20]]
zero_matrix(matrix2)
print(matrix2)
