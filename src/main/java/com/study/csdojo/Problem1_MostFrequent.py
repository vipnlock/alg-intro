def most_frequent(given_list):
    max_count = -1
    max_item = None
    count = {}

    for i in given_list:
        if i not in count:
            count[i] = 1
        else:
            count[i] += 1
        if (count[i] > max_count):
            max_count = count[i]
            max_item = i
    return max_item

if __name__ == '__main__':
    print("Result of %s must be %i" % (most_frequent([1, 3, 1, 3, 2, 1]), 1))
    print("Result of %s must be %i" % (most_frequent([3, 3, 1, 3, 2, 1]), 3))
    print("Result of %s must be None" % (most_frequent([])))
    print("Result of %s must be %i" % (most_frequent([0]), 0))
    print("Result of %s must be %i" % (most_frequent([0, -1, 10, 10, -1, 10, -1, -1, -1, 1]), -1))