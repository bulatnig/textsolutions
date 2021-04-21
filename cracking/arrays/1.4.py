ALPHABET_SIZE = 256


def is_palindrome_permutation(s: str) -> bool:
    "TODO document function"
    if len(s) == 0:
        return False
    counters = [0] * ALPHABET_SIZE
    for c in s:
        if c.isalpha():
            continue
        idx = ord(c.lower())
        counters[idx] += 1
    odd_count = 0
    for counter in counters:
        if counter % 2 != 0:
            odd_count += 1
    return True if odd_count < 2 else False


assert not is_palindrome_permutation("")
assert is_palindrome_permutation("   a  a ")
assert is_palindrome_permutation("moMo")
assert is_palindrome_permutation("Tact Coa")



