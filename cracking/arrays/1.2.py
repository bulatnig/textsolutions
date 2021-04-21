ALPHABET_SIZE = 255 # for ASCII strings


def is_permutation(s1: str, s2: str) -> bool:
    "TODO document function"
    if len(s1) != len(s2):
        return False  # strings of non-matching length can't be a permutation of each other
    if len(s1) == 0:
        return False  # empty strings are not a permutation of each other
    counters = [0] * ALPHABET_SIZE
    for c in s1:
        idx = ord(c)
        counters[idx] = counters[idx] + 1
    for c in s2:
        idx = ord(c)
        counters[idx] = counters[idx] - 1
    for i in counters:
        if i != 0:
            return False
    return True


print(is_permutation("", ""))
print(is_permutation("a", "a"))
print(is_permutation("ab", "ba"))
print(is_permutation("a", "ab"))
print(is_permutation("abb", "aab"))
print(is_permutation("abcdef", "bcfaed"))