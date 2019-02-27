def is_one_away(s1, s2):
    if abs(len(s1) - len(s2)) > 1:
        return False
    elif len(s1) == len(s2):
        return is_one_away_same_length(s1, s2)
    elif len(s1) > len(s2):
        return is_one_away_diff_length(s1, s2)
    else:
        return is_one_away_diff_length(s2, s1)

def is_one_away_same_length(s1, s2):
    diff_count = 0
    for i in range(len(s1)):
        if s1[i] != s2[i]:
            diff_count += 1
            if diff_count > 1:
                return False
    return True

def is_one_away_diff_length(s1, s2):
    diff_count = 0
    i = 0
    while i < len(s2):
        if s1[i + diff_count] == s2[i]:
            i += 1
        else:
            diff_count += 1
            if diff_count > 1:
                return False
    return True

if __name__ == '__main__':
    print("%s should return False" % (is_one_away("abcde", "abme")))
    print("%s should return True" % (is_one_away("abcde", "abcd")))
    print("%s should return True" % (is_one_away("abde", "abcde")))
    print("%s should return True" % (is_one_away("a", "a")))
    print("%s should return True" % (is_one_away("abcdef", "abqdef")))
    print("%s should return True" % (is_one_away("abcdef", "abccef")))
    print("%s should return True" % (is_one_away("abcdef", "abcde")))
    print("%s should return False" % (is_one_away("aaa", "abc")))
    print("%s should return False" % (is_one_away("abcde", "abc")))
    print("%s should return False" % (is_one_away("abc", "abcde")))
    print("%s should return False" % (is_one_away("abc", "bcc")))