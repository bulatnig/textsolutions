from typing import List, Any


def selection_sort(array: List[Any]) -> None:
    for i in range(len(array) - 1):
        min_idx = i
        for j in range(i + 1, len(array)):
            if array[j] < array[min_idx]:
                min_idx = j
        if min_idx != i:
            array[i], array[min_idx] = array[min_idx], array[i]


a = [5,4,3,2,1]
selection_sort(a)
print(a)