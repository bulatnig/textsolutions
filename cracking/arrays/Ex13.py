from typing import List


def urlify(s: List[str], true_length: int) -> None:
    p1 = true_length - 1
    p2 = len(s) - 1
    while p1 != p2:
        if s[p1] == ' ':
            s[p2] = '0'
            p2 -= 1
            s[p2] = '2'
            p2 -= 1
            s[p2] = '%'
        else:
            s[p2] = s[p1]
        p1 -= 1
        p2 -= 1


s = list("Mr John Smith    ")
urlify(s, 13)
assert ''.join(s) == "Mr%20John%20Smith"

s = list(" Hi  ")
urlify(s, 3)
assert ''.join(s) == "%20Hi"

s = list("World")
urlify(s, 5)
assert ''.join(s) == "World"
