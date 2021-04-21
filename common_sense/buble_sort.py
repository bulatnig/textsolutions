from typing import List, Any


def buble_sort(array: List[Any]) -> None:
    unsorted_until_idx = len(array) - 1
    is_sorted = False
    while not is_sorted:
        is_sorted = True
        for i in range(unsorted_until_idx):
            if array[i] > array[i + 1]:
                array[i], array[i + 1] = array[i + 1], array[i]
                is_sorted = False
        unsorted_until_idx -= 1


a = [5,4,3,2,1]
buble_sort(a)
print(a)
