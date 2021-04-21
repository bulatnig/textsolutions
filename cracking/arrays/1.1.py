MAX_ALPHABET_INDEX = 255


def is_unique(s: str) -> bool:
    """TODO document"""
    a = [0] * MAX_ALPHABET_INDEX
    for c in s:
        idx = ord(c)
        val = a[idx]
        if val:
            return False
        else:
            a[idx] = 1
    return True


print(is_unique(""))
print(is_unique("abcdef"))
print(is_unique("abcba"))
print(is_unique("aaaa"))
