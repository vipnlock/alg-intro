def lca(root, a, b):
    if not root:
        return None
    pathA = pathToX(root, a)
    pathB = pathToX(root, b)

    elemToReturn = None
    if pathA and pathB:
        while len(pathA) and len(pathB):
            elemA = pathA.pop()
            elemB = pathB.pop()
            if elemA.value == elemB.value:
                elemToReturn = elemA
            else:
                break
    return elemToReturn

def pathToX(root, x):
    if not root:
        return None
    if root.value == x:
        return [root]

    leftPath = pathToX(root.left, x)
    if leftPath:
        leftPath.append(root)
        return leftPath
    rightPath = pathToX(root.right, x)
    if rightPath:
        rightPath.append(root)
        return rightPath
    return None


class Node:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

    def __str__(self):
        return str(self.value)

    # Overriding the equality operator.
    # This will be used for testing your solution.
    def __eq__(self, other):
        if type(other) is type(self):
            return self.value == other.value
        return False


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
    head1 = create_tree(mapping1, 0)
    # This tree is:
    # head1 = 0
    #        / \
    #       1   2
    #      /\   /\
    #     3  4 5  6


    mapping2 = {5: [1, 4], 1: [3, 8], 4: [9, 2], 3: [6, 7]}
    head2 = create_tree(mapping2, 5)
    # This tree is:
    #  head2 = 5
    #        /   \
    #       1     4
    #      /\    / \
    #     3  8  9  2
    #    /\
    #   6  7


    print("%s should return 0" % (lca(head1, 1, 5)))
    print("%s should return 1" % (lca(head1, 3, 1)))
    print("%s should return 1" % (lca(head1, 1, 4)))
    print("%s should return 0" % (lca(head1, 0, 5)))
    print("%s should return 5" % (lca(head2, 4, 7)))
    print("%s should return 3" % (lca(head2, 3, 3)))
    print("%s should return 1" % (lca(head2, 8, 7)))
    print("%s should return None (0 does not exist in the tree)" % (lca(head2, 3, 0)))
