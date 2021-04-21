import string


def find_missing(s: str) -> str:
    seen_letters = {letter: True for letter in s}
    for letter in string.ascii_letters:
        if not seen_letters.get(letter):
            return letter


print(find_missing('the quick brown box jumps over a lazy dog'))
