def compress(input: str) -> str:
    "TODO document function"
    if len(input) < 3:
        return input
    output = []
    prev = input[0]
    count = 1
    for i in range(1, len(input)):
        c = input[i]
        if c == prev:
            count += 1
        else:
            output += prev
            output += str(count)
            prev = c
            count = 1
    output += prev
    output += str(count)
    if len(output) < len(input):
        return ''.join(output)
    else:
        return input

assert compress("aabcccccaaa") == "a2b1c5a3"
assert compress("") == ""
assert compress("a") == "a"
assert compress("aa") == "aa"
assert compress("aaa") == "a3"
assert compress("aaabcde") == "aaabcde"
assert compress("abcdddddd") == "a1b1c1d6"
