
def reverse(string: str) -> str:
    stack = []
    for c in string:
        stack.append(c)
    result = ''
    while stack:
        result += stack.pop()
    return result


s = 'abcde'
print(reverse(s))
