from typing import List


def sort(stack: List):
    if not stack:
        return
    size = _size(stack)
    tmp = []
    for i in range(size - 1):  # last element already sorted
        # skip already sorted elements
        for j in range(i):
            tmp.append(stack.pop())
        # move and find next min
        min = stack.pop()
        tmp.append(min)
        while stack:
            item = stack.pop()
            tmp.append(item)
            if item < min:
                min = item
        # move back and add min at the end
        for k in range(size - i):
            item = tmp.pop()
            if min != item:
                stack.append(item)
        stack.append(min)
        # move back already sorted elements
        while tmp:
            stack.append(tmp.pop())


def _size(stack: List) -> int:
    tmp = []
    size = 0
    while stack:
        tmp.append(stack.pop())
        size += 1
    while tmp:
        stack.append(tmp.pop())
    return size


stack = [1, 2, 3]
sort(stack)
assert str(stack) == '[3, 2, 1]'
