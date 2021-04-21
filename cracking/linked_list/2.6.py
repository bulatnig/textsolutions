class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

    def __repr__(self):
        return self.data


class LinkedList:
    def __init__(self):
        self.head = None

    def __repr__(self):
        node = self.head
        nodes = []
        while node is not None:
            nodes.append(str(node.data))
            node = node.next
        nodes.append("None")
        return " -> ".join(nodes)


def is_palindrome(input_head: Node) -> bool:
    if not input_head:
        return False
    reverse_head = None
    node = input_head
    while node:
        tmp = node.next
        node.next = reverse_head
        reverse_head = node
        node = tmp
    forward_node = input_head
    reverse_node = reverse_head
    while forward_node:
        if forward_node.data != reverse_node.data:
            return False
        forward_node = forward_node.next
        reverse_node = reverse_node.next
    return True


node1 = Node('a')
node2 = Node('b')
node3 = Node('a')
node1.next = node2
node2.next = node3
assert is_palindrome(node1)

node1 = Node('a')
node2 = Node('b')
node3 = Node('b')
node4 = Node('a')
node1.next = node2
node2.next = node3
node3.next = node4
assert is_palindrome(node1)


node1 = Node('a')
node2 = Node('a')
node3 = Node('b')
node1.next = node2
node2.next = node3
assert not is_palindrome(node1)


node1 = Node('a')
assert is_palindrome(node1)
