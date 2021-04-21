class SetOfStacks:
    def __init__(self, threshold: int):
        self.stacks = []
        self.threshold = threshold

    def push(self, value):
        if not self.stacks or len(self.stacks[-1]) >= self.threshold:
            self.stacks.append([])
        stack = self.stacks[-1]
        stack.append(value)

    def pop(self):
        return self.popAt(-1)

    def popAt(self, index: int):
        if not self.stacks:
            return None
        try:
            stack = self.stacks[index]
        except IndexError:  # index provided is outside of available stacks range
            return None
        result = stack.pop()
        if not stack:  # no other element left in a stack
            self.stacks.remove(stack)
        return result


ss = SetOfStacks(1)
ss.push(1)
ss.push(2)
assert ss.popAt(0) == 1
assert len(ss.stacks) == 1
assert ss.pop() == 2