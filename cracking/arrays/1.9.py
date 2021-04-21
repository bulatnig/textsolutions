def is_rotation(s1: str, s2: str) -> bool:
    if len(s1) != len(s2):
        return False  # strings of different length can't be rotation of one to another
    s1s1 = s1 + s1
    return s2 in s1s1


assert is_rotation("waterbottle", "erbottlewat")
assert not is_rotation("blabla", "blalab")