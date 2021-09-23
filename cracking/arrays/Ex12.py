def is_permutation(s1: str, s2: str) -> bool:
    if len(s1) != len(s2):
        return False
    counters = [0]*256
    for c in s1:
        counters[ord(c)] += 1
    for c in s2:
        counters[ord(c)] -= 1
    for counter in counters:
        if counter != 0:
            return False
    return True


assert not is_permutation("a", "b")
assert is_permutation("abcd", "bcad")
assert not is_permutation("a", "abc")