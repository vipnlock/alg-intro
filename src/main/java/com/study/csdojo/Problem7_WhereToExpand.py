def my_click(field, num_rows, num_cols, given_i, given_j):
    if field[given_i][given_j] != 0:
        return field
    queue = [(given_i, given_j)]

    while len(queue) != 0:
        (pos_i, pos_j) = queue.pop()
        field[pos_i][pos_j] = -2
        for i in range(pos_i - 1, pos_i + 2):
            for j in range(pos_j - 1, pos_j + 2):
                if 0 <= i < num_rows and 0 <= j < num_cols and field[i][j] == 0:
                    field[i][j] = -2
                    queue.insert(0, (i, j))
    return field

# Implement your function below.
def click(field, num_rows, num_cols, given_i, given_j):
    import queue
    to_check = queue.Queue()
    if field[given_i][given_j] == 0:
        field[given_i][given_j] = -2
        to_check.put((given_i, given_j))
    else:
        return field
    while not to_check.empty():
        (current_i, current_j) = to_check.get()
        for i in range(current_i - 1, current_i + 2):
            for j in range(current_j - 1, current_j + 2):
                if (0 <= i < num_rows and 0 <= j < num_cols
                        and field[i][j] == 0):
                    field[i][j] = -2
                    to_check.put((i, j))
    return field


def to_string(given_array):
    list_rows = []
    for row in given_array:
        list_rows.append(str(row))
    return '[' + ',\n '.join(list_rows) + ']'

if __name__ == '__main__':
    field1 = [[0, 0, 0, 0, 0],
              [0, 1, 1, 1, 0],
              [0, 1, -1, 1, 0]]

    print("%s" % to_string(click(field1, 3, 5, 2, 2)))
    # should return:
    # [[0, 0, 0, 0, 0],
    #  [0, 1, 1, 1, 0],
    #  [0, 1, -1, 1, 0]]

    print("%s" % to_string(click(field1, 3, 5, 1, 4)))
    # should return:
    # [[-2, -2, -2, -2, -2],
    #  [-2, 1, 1, 1, -2],
    #  [-2, 1, -1, 1, -2]]


    field2 = [[-1, 1, 0, 0],
              [1, 1, 0, 0],
              [0, 0, 1, 1],
              [0, 0, 1, -1]]

    print("%s" % to_string(click(field2, 4, 4, 0, 1)))
    # should return:
    # [[-1, 1, 0, 0],
    #  [1, 1, 0, 0],
    #  [0, 0, 1, 1],
    #  [0, 0, 1, -1]]

    print("%s" % to_string(click(field2, 4, 4, 1, 3)))
    # should return:
    # [[-1, 1, -2, -2],
    #  [1, 1, -2, -2],
    #  [-2, -2, 1, 1],
    #  [-2, -2, 1, -1]]
