def mine_sweeper(bombs, num_rows, num_cols):
    field = [[0 for x in range(num_cols)] for x in range(num_rows)]
    for (row, col) in bombs:
        field[row][col] = -1
        for ir in range(row - 1, row + 2):
            if 0 <= ir < num_rows:
                for jr in range(col - 1, col + 2):
                    if 0 <= jr < num_cols and field[ir][jr] != -1:
                        field[ir][jr] += 1
    return field

def to_string(given_array):
    list_rows = []
    for row in given_array:
        list_rows.append(str(row))
    return '[' + ',\n '.join(list_rows) + ']'

if __name__ == '__main__':
    print("%s" % to_string(mine_sweeper([[0, 2], [2, 0]], 3, 3)))
    # [[0, 1, -1],
    #  [1, 2, 1],
    #  [-1, 1, 0]]

    print("%s" % to_string(mine_sweeper([[0, 0], [0, 1], [1, 2]], 3, 4)))
    # [[-1, -1, 2, 1],
    #  [2, 3, -1, 1],
    #  [0, 1, 1, 1]]

    print("%s" % to_string(mine_sweeper([[1, 1], [1, 2], [2, 2], [4, 3]], 5, 5)))
    # [[1, 2, 2, 1, 0],
    #  [1, -1, -1, 2, 0],
    #  [1, 3, -1, 2, 0],
    #  [0, 1, 2, 2, 1],
    #  [0, 0, 1, -1, 1]]