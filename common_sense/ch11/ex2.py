from typing import List


def filter_even(array: List[int]) -> List[int]:
    if not array:
        return []
    number = array[0]
    result = [number] if number % 2 == 0 else []
    return result + filter_even(array[1:])


array = [1,2,3,4,5,6,7]
print(filter_even(array))
