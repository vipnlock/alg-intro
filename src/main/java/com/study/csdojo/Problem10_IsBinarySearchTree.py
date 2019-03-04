class Node:
    def __init__(self, value, left = None, right = None):
        self.value = value
        self.left = left
        self.right = right

    def __str__(self):
        return str(self.value)


def is_bst(head, lower_limit = None, upper_limit = None):
    if not head:
        return True
    if (lower_limit and head.value < lower_limit) or (upper_limit and head.value > upper_limit):
        return False
    return is_bst(head.left, lower_limit, head.value) and is_bst(head.right, head.value, upper_limit)

def my_is_bst(head):
    if head is None:
        return True
    if head.left is not None:
        if head.value <= head.left.value:
            return False
        leftMost = head.left
        while leftMost.right:
            leftMost = leftMost.right
        if leftMost.value >= head.value:
            return False
    if head.right is not None:
        if head.value >= head.right.value:
            return False
        rightMin = head.right
        while rightMin.left:
            rightMin = rightMin.left
        if rightMin.value <= head.value:
            return False
    return is_bst(head.left) and is_bst(head.right)

# A function for creating a tree.
# Input:
# - mapping: a node-to-node mapping that shows how the tree should be constructed
# - head_value: the value that will be used for the head ndoe
# Output:
# - The head node of the resulting tree
def create_tree(mapping, head_value):
    head = Node(head_value)
    nodes = {head_value: head}
    for key, value in mapping.items():
        nodes[value[0]] = Node(value[0])
        nodes[value[1]] = Node(value[1])
    for key, value in mapping.items():
        nodes[key].left = nodes[value[0]]
        nodes[key].right = nodes[value[1]]
    return head


if __name__ == '__main__':
    # The mapping we're going to use for constructing a tree.
    # {0: [1, 2]} means that 0's left child is 1, and its right
    # child is 2.
    mapping1 = {0: [1, 2], 1: [3, 4], 2: [5, 6]}
    mapping2 = {3: [1, 4], 1: [0, 2], 4: [5, 6]}
    mapping3 = {3: [1, 5], 1: [0, 2], 5: [4, 6]}
    mapping4 = {3: [1, 5], 1: [0, 4]}
    head1 = create_tree(mapping1, 0)
    # This tree is:
    #  head1 = 0
    #        /   \
    #       1     2
    #      /\    / \
    #     3  4  5   6
    head2 = create_tree(mapping2, 3)
    # This tree is:
    #  head2 = 3
    #        /   \
    #       1     4
    #      /\    / \
    #     0  2  5   6
    head3 = create_tree(mapping3, 3)
    # This tree is:
    #  head3 = 3
    #        /   \
    #       1     5
    #      /\    / \
    #     0  2  4   6
    head4 = create_tree(mapping4, 3)
    # This tree is:
    #  head4 = 3
    #        /   \
    #       1     5
    #      /\
    #     0  4

    print("%s should return False" % (is_bst(head1)))
    print("%s should return False" % (is_bst(head2)))
    print("%s should return True" % (is_bst(head3)))
    print("%s should return False" % (is_bst(head4)))
