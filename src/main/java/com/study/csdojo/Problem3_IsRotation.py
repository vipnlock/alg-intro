def is_rotation(list1, list2):
    n = len(list1)
    if len(list1) != len(list2):
        return False
    key = list1[0]
    key_i = -1
    for i in range(n):
        if key == list2[i]:
            key_i = i
            break
    if key_i == -1:
        return False
    for i in range(n):
        j = (key_i + i) % n
        if list1[i] != list2[j]:
            return False
    return True

def my_is_rotation(list1, list2):
    n = len(list1)
    if n != len(list2):
        return False

    p1 = 0
    p2 = 0
    while list1[p1] != list2[p2]:
        p1 += 1
    while p1 != n:
        if list1[p1] != list2[p2]:
            return False
        p1 += 1
        p2 += 1
    p1 = 0
    while p2 != n:
        if list1[p1] != list2[p2]:
            return False
        p1 += 1
        p2 += 1

    return True

if __name__ == '__main__':
    list1 = [1, 2, 3, 4, 5, 6, 7]
    list2a = [4, 5, 6, 7, 8, 1, 2, 3]
    print("%s should return False." % (is_rotation(list1, list2a)))
    list2b = [4, 5, 6, 7, 1, 2, 3]
    print("%s should return True." % (is_rotation(list1, list2b)))
    list2c = [4, 5, 6, 9, 1, 2, 3]
    print("%s should return False." % (is_rotation(list1, list2c)))
    list2d = [4, 6, 5, 7, 1, 2, 3]
    print("%s should return False." % (is_rotation(list1, list2d)))
    list2e = [4, 5, 6, 7, 0, 2, 3]
    print("%s should return False." % (is_rotation(list1, list2e)))
    list2f = [1, 2, 3, 4, 5, 6, 7]
    print("%s should return True." % (is_rotation(list1, list2f)))
