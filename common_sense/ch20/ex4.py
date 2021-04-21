from typing import List


def highest_product(array: List[int]) -> int:
    min_negative = min(array[0], array[1])
    max_positive = max(array[0], array[1])
    max_product = array[0] * array[1]
    for i in range(2, len(array)):
        number = array[i]
        if number >= 0:
            product = number * max_positive
            if product > max_product:
                max_product = product
            if number > max_positive:
                max_positive = number
        if number < 0:
            product = number * min_negative
            if product > max_product:
                max_product = product
            if number < min_negative:
                min_negative = number
    return max_product


print(highest_product([5, -10, -6, 9, 4]))
