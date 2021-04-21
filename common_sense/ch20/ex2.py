from typing import List


def find_missing(array: List[int]) -> int:
    actual_sum = sum(array)
    expected_sum = len(array) * (len(array) + 1) // 2
    if actual_sum < expected_sum:
        return expected_sum - actual_sum
    elif actual_sum == expected_sum:
        return len(array) + 1
    else:
        raise Exception("Invalid array provided")


print(find_missing([2,3,0,6,1,5]))
print(find_missing([8,2,3,9,4,7,5,0,6]))
print(find_missing([0,1,2,3,4]))
