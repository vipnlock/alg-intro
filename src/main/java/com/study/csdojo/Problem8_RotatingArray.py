def rotate_copy(given_array, n):
    rotated = [[0 for i in range(n)] for j in range(n)]

    for i in range(n):
        for j in range(n):
            rotated[j][n - i - 1] = given_array[i][j]
    return rotated

def rotate(given_array, n):
    for i in range(int(n / 2)):
        for j in range(int(n / 2) + 1):
            current = (i, j)
            tmp = [-1] * 4
            for k in range(4):
                tmp[k] = given_array[current[0]][current[1]]
                current = rotate_sub(current[0], current[1], n)
            for k in range(4):
                given_array[current[0]][current[1]] = tmp[(k + 3) % 4]
                current = rotate_sub(current[0], current[1], n)
    return given_array

def rotate_sub(i, j, n):
    return (j, n - i - 1)

def my_rotate(given_array, n):
    for i in range(int(n / 2) + 1):
        for j in range(i, n - i - 1):
            current = (i, j)
            next1 = (j, n - i - 1)
            next2 = (n - i - 1, n - j -1)
            next3 = (n - j - 1, i)
            current_val = given_array[current[0]][current[1]]
            given_array[current[0]][current[1]] = given_array[next3[0]][next3[1]]
            given_array[next3[0]][next3[1]] = given_array[next2[0]][next2[1]]
            given_array[next2[0]][next2[1]] = given_array[next1[0]][next1[1]]
            given_array[next1[0]][next1[1]] = current_val
    return given_array

def to_string(given_array):
    list_rows = []
    for row in given_array:
        list_rows.append(str(row))
    return '[' + ',\n '.join(list_rows) + ']'

if __name__ == '__main__':
    a1 = [[1, 2, 3],
          [4, 5, 6],
          [7, 8, 9]]
    print("%s" % (to_string(rotate(a1, 3))))
    # should return:
    # [[7, 4, 1],
    #  [8, 5, 2],
    #  [9, 6, 3]]

    a2 = [[1, 2, 3, 4],
          [5, 6, 7, 8],
          [9, 10, 11, 12],
          [13, 14, 15, 16]]
    print("%s" % (to_string(rotate(a2, 4))))
    # should return:
    # [[13, 9, 5, 1],
    #  [14, 10, 6, 2],
    #  [15, 11, 7, 3],
    #  [16, 12, 8, 4]]
