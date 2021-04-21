from typing import List


def count_characters(array: List[str]) -> int:
    if not array:
        return 0
    return len(array[0]) + count_characters(array[1:])


array = ['ab', 'c', 'def', 'ghij']
print(count_characters(array))
