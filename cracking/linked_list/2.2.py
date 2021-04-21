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


def kth_to_last(linked_list: LinkedList, k: int):
    last = linked_list.head
    for i in range(0, k):
        last = last.next
    kth = linked_list.head
    while last.next:
        last = last.next
        kth = kth.next
    return kth.data


linked_list = LinkedList()
node1 = Node('1')
node2 = Node('2')
node3 = Node('3')
node4 = Node('4')
node5 = Node('5')
linked_list.head = node1
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5
assert kth_to_last(linked_list, 3) == '2'
