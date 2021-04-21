def first_non_dup(string: str) -> str:
    letter_counts = {}
    for letter in string:
        count = letter_counts.get(letter)
        if not count:
            count = 0
        count += 1
        letter_counts[letter] = count
    for letter in string:
        count = letter_counts.get(letter)
        if count == 1:
            return letter


s = 'minimum'
print(first_non_dup(s))