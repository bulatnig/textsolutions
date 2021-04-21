def triangular_number(n: int) -> int:
    if n == 1:
        return 1
    return n + triangular_number(n - 1)


print(triangular_number(7))
