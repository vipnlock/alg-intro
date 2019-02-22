# Would gladly accept suggestions.
def rodcutter(cost, n):
    rod = [0] * (n + 1)
    rod[0] = 0
    best = {}
    for i in range(0, n + 1):
        best[i] = []

    for i in range(1, n + 1):
        maxv = -1
        for j in range(1, i + 1):
            if cost[j] + rod[i - j] > maxv:
                maxv = cost[j] + rod[i - j]

        for j in range(1, i + 1):
            if cost[j] + rod[i - j] == maxv:
                if len(best[i - j]) == 0:
                    best[i].append([j])
                else:
                    for k in best[i - j]:
                        if sorted([j] + k) not in best[i]:
                            best[i].append(sorted([j] + k))
        rod[i] = maxv

    return (best[n])

def rodcutter2(cost, n):
    rod = [0] * (n + 1)
    rod[0] = 0
    best = {}
    for i in range(0, n + 1):
        best[i] = []

    for i in range(1, n + 1):
        maxv = -1
        for j in range(1, i + 1):
            interStep = cost[j] + rod[i - j]
            if maxv < interStep:
                maxv = interStep
            if interStep == maxv:
                if len(best[i - j]) == 0:
                    best[i].append([j])
                else:
                    for k in best[i - j]:
                        if sorted([j] + k) not in best[i]:
                            best[i].append(sorted([j] + k))

        rod[i] = maxv
    return (best[n])

if __name__ == '__main__':
    print(rodcutter2([0, 2, 4, 6, 8, 9], 5))
