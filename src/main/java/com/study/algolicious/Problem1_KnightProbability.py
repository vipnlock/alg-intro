# On an n x n chessboard a chess knight has 8 possible moves.
# Each time knight needs to move, it chooses one of the 8 possible moves uniformly
# at random and moves there, even if it would go out of the chessboard boundaries.
# That is, the probability of each move is 1/8.
#
# Main tricks for this question:
# - Drawing a simple example can lead us to an intuitive solution.
# - Breaking up our problem into smaller problems using DP.
#
# DP recursive function:
# f(r, c, k) = 1, 0 <= c, r < n && k = 0
#            = SUM_(x, y)_from_Delta (f(r + x, c + y, k - 1)), 0 <= r + x, c + y < n && k >= 1
# Delta = [(2, 1), (2, -1), (-2, 1), (-2, -1), (1, 2), (1, -2), (-1, 2), (-1, -2)]
def knightProbability(n, row, col, k):
    delta = [(2, 1), (2, -1), (-2, 1), (-2, -1), (1, 2), (1, -2), (-1, 2), (-1, -2)]
    # 1. Create 2 matrices of size n x n
    prob1 = [[0 for i in range(n)] for j in range(n)]
    prob2 = [[0 for i in range(n)] for j in range(n)]
    # 2. Initialize prob1[row][col] = 1 and the rest of the entries with 0
    if 0 <= col < n and 0 <= row < n:
        prob1[col][row] = 1

    main = prob1
    slave = prob2
    # 3. Perform k times:
    for i in range(1, k + 1):
        # 3.1. Update the entries in slave (according the recursive function),
        #      which can be reached with a knight's move from the entries in main.
        for i in range(n):
            for j in range(n):
                if main[i][j] != 0:
                    for d in delta:
                        if 0 <= i + d[0] < n and 0 <= j + d[1] < n:
                            slave[i + d[0]][j + d[1]] += main[i][j] / 8
        # 3.2. Switch between main and slave
        temp = slave
        slave = main
        main = temp
        # 3.3. Reset slave to zeros
        for i in range(n):
            for j in range(n):
                slave[i][j] = 0
        printArr(main)

    # 4. Summarize all the entries in main and return the result.
    sum = 0
    for i in range(n):
        for j in range(n):
            sum += main[i][j]
    return sum


def printArr(arr):
    result = ""
    for entries in arr:
        delimeter = ""
        for elem in entries:
            result += delimeter
            delimeter = ", "
            result += str(elem)
        result += "\n"
    print(result)


if __name__ == '__main__':
    print("%s" % knightProbability(3, 0, 0, 2))
    print("%s" % knightProbability(8, 3, 3, 10))