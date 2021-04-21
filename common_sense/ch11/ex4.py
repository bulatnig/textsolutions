def find_x(s: str) -> int:
    if s[0] == 'x':
        return 0
    return 1 + find_x(s[1:])


s = 'abcdefghijklmonpqarstuvwxyz'
print(find_x(s))
