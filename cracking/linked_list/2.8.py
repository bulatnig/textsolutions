from typing import Optional


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


def detect_loop(head: Node) -> Optional[Node]:
    node = head
    while node.next:
        tmp = node.next
        node.next = None
        node = tmp
    return node


node_a = Node('a')
node_b = Node('b')
node_c = Node('c')
node_d = Node('d')
node_e = Node('e')
node_a.next = node_b
node_b.next = node_c
node_c.next = node_d
node_d.next = node_e
node_e.next = node_c
assert detect_loop(node_a) == node_c

node_a = Node('a')
node_a.next = node_a
assert detect_loop(node_a) == node_a
