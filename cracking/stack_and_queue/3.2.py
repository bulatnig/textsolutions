from typing import Any, Optional


class MinStack:

    def __init__(self):
        self.values = []
        self.mins = []

    def push(self, value: Any) -> None:
        self.values.append(value)
        prev_min = self.min()
        new_min = value if not prev_min or value < prev_min else prev_min
        self.mins.append(new_min)

    def pop(self) -> Optional[Any]:
        if not self.values:
            return None
        self.mins.pop()
        return self.values.pop()

    def min(self) -> Optional[Any]:
        return self.mins[-1] if self.mins else None


stack = MinStack()
stack.push(4)
assert stack.min() == 4
stack.push(3)
assert stack.min() == 3
stack.push(5)
assert stack.min() == 3
assert stack.pop() == 5
assert stack.min() == 3
assert stack.pop() == 3
assert stack.min() == 4
assert stack.pop() == 4
assert not stack.min()
