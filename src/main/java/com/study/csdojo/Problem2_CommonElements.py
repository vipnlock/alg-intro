def common_elements(list1, list2):
    p1 = 0
    p2 = 0
    result = []

    while p1 < len(list1) and p2 < len(list2):
        if list1[p1] == list2[p2]:
            result.append(list1[p1])
            p1 += 1
            p2 += 1
        elif list1[p1] < list2[p2]:
            p1 += 1
        else:
            p2 += 1
    return result

def my_common_elements(list1, list2):
    if len(list1) >= len(list2):
        first = list1
        second = list2
    else:
        first = list2
        second = list1
    n = len(first)
    m = len(second)
    result = []

    j = 0
    for firstElement in first:
        while j < m and firstElement > second[j]:
            j += 1
        if j == m:
            break
        elif firstElement == second[j]:
            result.append(firstElement)
    return result

if __name__ == '__main__':
    list_a1 = [1, 3, 4, 6, 7, 9]
    list_a2 = [1, 2, 4, 5, 9, 10]
    print ("Call common_elements should return [1, 4, 9] (a list) %s" % (common_elements(list_a1, list_a2)))

    list_b1 = [1, 2, 9, 10, 11, 12]
    list_b2 = [0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15]
    print ("Call common_elements should return [1, 2, 9, 10, 12] (a list) %s" % (common_elements(list_b1, list_b2)))

    list_c1 = [0, 1, 2, 3, 4, 5]
    list_c2 = [6, 7, 8, 9, 10, 11]
    print ("Call common_elements should return an empty list %s" % common_elements(list_c1, list_c2))