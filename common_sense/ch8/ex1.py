from typing import Any, List


def intersect(array1: List[Any], array2: List[Any]) -> List[Any]:
    dict1 = {item: True for item in array1}
    return [item for item in array2 if dict1.get(item)]


a1 = [1,2,3,4,5]
a2 = [0,2,4,6,8]
print(intersect(a1,a2))
