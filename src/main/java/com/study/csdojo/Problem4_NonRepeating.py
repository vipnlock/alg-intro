def non_repeating(given_string):
    characters = {}
    for ch in given_string:
        if ch not in characters:
            characters[ch] = 1
        else:
            characters[ch] += 1

    for ch in given_string:
        if (characters[ch] == 1):
            return ch

    return None

if __name__ == '__main__':
    print("%s should return 'c'" % (non_repeating("abcab")))
    print("%s should return None" % (non_repeating("abab")))
    print("%s should return 'c'" % (non_repeating("aabbbc")))
    print("%s should return 'd'" % (non_repeating("aabbdbc")))
