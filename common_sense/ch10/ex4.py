from typing import Any, List


def print_recursively(array: List[Any]) -> None:
    for item in array:
        if isinstance(item, List):
            print_recursively(item)
        else:
            print(item)


array = [1,2,3,[4,5,6],7,[8,[9,10,11, [12,13,14]]]]
print_recursively(array)