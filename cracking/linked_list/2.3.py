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
            nodes.append(node.data)
            node = node.next
        nodes.append("None")
        return " -> ".join(nodes)


def delete_middle_node(node: Node) -> None:
    node.data = node.next.data
    node.next = node.next.next


linked_list = LinkedList()
node1 = Node('a')
node2 = Node('b')
node3 = Node('c')
node4 = Node('d')
node5 = Node('e')
node6 = Node('f')
linked_list.head = node1
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5
node5.next = node6
delete_middle_node(node3)
assert str(linked_list) == "a -> b -> d -> e -> f -> None"
