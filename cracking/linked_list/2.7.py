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


def intersection(head1: Node, head2: Node) -> Optional[Node]:
    cache = set()
    node = head1
    while node:
        cache.add(node)
        node = node.next
    node = head2
    while node:
        if node in cache:
            return node
        node = node.next
    return None


node_a = Node('a')
node_b = Node('b')
node_c = Node('c')
node_a.next = node_b
node_b.next = node_c
node_d = Node('d')
node_e = Node('e')
node_d.next = node_e
node_e.next = node_b
assert intersection(node_a, node_d) == node_b

node_a = Node('a')
node_b = Node('b')
node_c = Node('c')
node_a.next = node_b
node_b.next = node_c
assert intersection(node_a, node_a) == node_a

node_a = Node('a')
node_b = Node('b')
node_c = Node('c')
node_a.next = node_b
node_b.next = node_c
node_d = Node('d')
node_e = Node('e')
node_f = Node('f')
node_d.next = node_e
node_e.next = node_f
assert intersection(node_a, node_d) == None

node_a = Node('a')
node_b = Node('b')
node_c = Node('c')
node_a.next = node_b
node_b.next = node_c
assert intersection(node_a, node_c) == node_c
