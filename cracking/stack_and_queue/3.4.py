class MyQueue:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def add(self, item):
        self.stack1.append(item)

    def remove(self):
        self._move(self.stack1, self.stack2)
        item = self.stack2.pop()
        self._move(self.stack2, self.stack1)
        return item

    @classmethod
    def _move(cls, source, target):
        while source:
            target.append(source.pop())


q = MyQueue()
q.add(1)
q.add(2)
assert q.remove() == 1
assert q.remove() == 2