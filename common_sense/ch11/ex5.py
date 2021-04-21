def unique_paths(rows: int, columns: int) -> int:
    if rows == 1 or columns == 1:
        return 1
    return unique_paths(rows - 1, columns) + unique_paths(rows, columns - 1)


print(unique_paths(3, 3))
