class Node:

    def __init__(self, value, child = None):
        self.value = value
        self.child = child

    # The string representation of this node. Will be used for testing.
    def __str__(self):
        return str(self.value)


def nth_from_last(head, n):
    left = head
    right = head
    for i in range(n):
        if right is None:
            return None
        right = right.child
    while right:
        left = left.child
        right = right.child
    return left

def my_nth_from_last(head, n):
    if head is None:
        return None
    count = 0
    tmp = head
    while tmp:
        tmp = tmp.child
        count += 1
    if count < n:
        return None
    tmp = head
    for i in range(count - n):
        tmp = tmp.child
    return tmp


def revert(head):
    if head is None:
        return None
    tmp = head
    last = None
    while tmp:
        next = tmp.child
        tmp.child = last
        last = tmp
        tmp = next
    head = last
    return head


def linked_list_to_string(head):
    current = head
    str_list = []
    while current:
        str_list.append(str(current.value))
        current = current.child
    str_list.append('(None)')
    return ' -> '.join(str_list)

if __name__ == '__main__':
    current = Node(1)
    for i in range(2, 8):
        current = Node(i, current)
    head = current
    # head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (None)

    current2 = Node(4)
    for i in range(3, 0, -1):
        current2 = Node(i, current2)
    head2 = current2
    # head2 = 1 -> 2 -> 3 -> 4 -> (None)

    print("%s should return 1." % (nth_from_last(head, 1)))
    print("%s should return 5." % (nth_from_last(head, 5)))
    print("%s should return 3." % (nth_from_last(head2, 2)))
    print("%s should return 1." % (nth_from_last(head2, 4)))
    print("%s should return None." % (nth_from_last(head2, 5)))
    print("%s should return None." % (nth_from_last(None, 1)))

    print("Reverted head: %s" % (linked_list_to_string(revert(head))))
    print("Reverted head2: %s" % (linked_list_to_string(revert(head2))))