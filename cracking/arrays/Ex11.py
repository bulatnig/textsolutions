def is_unique(input: str) -> bool:
    characters = list(input)
    characters.sort()
    for i in range(1, len(characters)):
        if characters[i] == characters[i - 1]:
            return False
    return True


assert is_unique("abcdefg")
assert not is_unique("abcda")
assert is_unique("")