from typing import Any, List


def find_dup(array: List[Any]) -> str:
    visited = {}
    for item in array:
        if item in visited:
            return item
        visited[item] = True


a = ['a', 'b', 'c', 'd', 'c', 'e']
print(find_dup(a))