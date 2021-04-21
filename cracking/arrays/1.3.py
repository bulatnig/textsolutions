def urlify(s: str, true_length: int) -> str:
    "TODO document function"
    array = list(s)
    i = true_length - 1
    j = len(array) - 1
    while i != j:
        if array[i] == ' ':
            array[j] = '0'
            array[j - 1] = '2'
            array[j - 2] = '%'
            j -= 2
        else:
            array[j] = array[i]
        i -= 1
        j -= 1
    return ''.join(array)


assert urlify("Mr John Smith    ", 13) == "Mr%20John%20Smith"
assert urlify("", 0) == ""
assert urlify("abcde", 5) == "abcde"
assert urlify("         ", 3) == "%20%20%20"
