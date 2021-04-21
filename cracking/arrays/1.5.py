def is_one_way(s1: str, s2: str) -> bool:
    len_diff = len(s1) - len(s2)
    if len_diff > 1 or len_diff < -1:
        return False
    if len_diff > 0:
        short_string = s2
        long_string = s1
    else:
        short_string = s1
        long_string = s2
    i = 0
    j = 0
    character_added = False
    diff_count = 0
    while i < len(short_string):
        if short_string[i] != long_string[j]:
            diff_count += 1
            if not character_added and len_diff != 0:
                j += 1  # emulate character addition by moving cursor over longer string to the next character
                character_added = True
                continue
        i += 1
        j += 1
    return True if diff_count < 2 else False


assert is_one_way("pale", "ple")
assert is_one_way("pales", "pale")
assert is_one_way("pale", "bale")
assert not is_one_way("pale", "bake")
assert is_one_way("", "")
assert is_one_way("", "b")
assert is_one_way("a", "b")