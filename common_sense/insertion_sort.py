from typing import Any, List


def insertion_sort(array: List[Any]) -> None:
    for i in range(1, len(array)):
        tmp = array[i]
        position = i - 1
        while position >= 0:
            if array[position] > tmp:
                array[position + 1] = array[position]
                position -= 1
            else:
                break
        array[position + 1] = tmp


a = [5,4,3,2,1]
insertion_sort(a)
print(a)