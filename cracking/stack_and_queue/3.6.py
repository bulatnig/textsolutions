from collections import deque
from typing import Optional
from dataclasses import dataclass


@dataclass
class Entry:
    name: str
    number: int


class AnimalShelter:

    def __init__(self):
        self.sequence = 0
        self.dogs = deque()
        self.cats = deque()

    def enqueue(self, type: str, name: str) -> None:
        self.sequence += 1
        entry = Entry(name=name, number=self.sequence)
        queue = self.dogs if "dog" == type else self.cats
        queue.append(entry)

    def dequeueAny(self) -> Optional[str]:
        if not self.dogs and not self.cats:
            return None
        if not self.dogs:
            return self.cats.popleft().name
        if not self.cats:
            return self.dogs.popleft().name
        if self.dogs[0].number < self.cats[0].number:
            return self.dogs.popleft().name
        else:
            return self.cats.popleft().name

    def dequeueDog(self) -> Optional[str]:
        return self.dogs.popleft().name if self.dogs else None

    def dequeueCat(self) -> Optional[str]:
        return self.cats.popleft().name if self.cats else None


shelter = AnimalShelter()
shelter.enqueue("dog", "dogA")
shelter.enqueue("cat", "catA")
shelter.enqueue("dog", "dogB")
shelter.enqueue("cat", "catB")

assert shelter.dequeueAny() == "dogA"
assert shelter.dequeueAny() == "catA"

shelter = AnimalShelter()
shelter.enqueue("dog", "dogA")
shelter.enqueue("dog", "dogB")
shelter.enqueue("cat", "catA")

assert shelter.dequeueAny() == "dogA"
assert shelter.dequeueAny() == "dogB"
assert not shelter.dequeueDog()
assert shelter.dequeueAny() == "catA"
assert not shelter.dequeueAny()

shelter = AnimalShelter()
shelter.enqueue("dog", "dogA")
shelter.enqueue("dog", "dogB")
shelter.enqueue("cat", "catA")
shelter.enqueue("cat", "catB")

assert shelter.dequeueDog() == "dogA"
assert shelter.dequeueCat() == "catA"
