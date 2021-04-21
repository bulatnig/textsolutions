from typing import List


def max_consecutive_sequence(array: List[int]) -> int:
    s = set(array)
    max_sequence = 0
    for item in array:
        if item - 1 in s:
            continue  # try to build the sequence only from the last element of the sequence
        sequence = 1
        next_item = item + 1
        while next_item in s:
            sequence += 1
            next_item = next_item + 1
        if sequence > max_sequence:
            max_sequence = sequence
    return max_sequence


print(max_consecutive_sequence([10, 5, 12, 3, 55, 30, 4, 11, 2]))
print(max_consecutive_sequence([19, 13, 15, 12, 18, 14, 17, 11]))
