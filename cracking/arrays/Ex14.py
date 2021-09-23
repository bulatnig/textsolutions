
def is_palindrome_permutation(s: str) -> bool:
    counters = {}
    for c in s.lower():
        if c.isalpha():
            counters[c] = counters.get(c, 0) + 1
    odd_chars = 0
    for counter in counters.values():
        if counter % 2 == 1:
            odd_chars += 1
    return odd_chars < 2


assert is_palindrome_permutation("Tact Coa")
assert not is_palindrome_permutation("tract")
