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


def remove_dups(linked_list: LinkedList) -> None:
    if not linked_list.head or not linked_list.head.next:
        return  # there can't be any duplicates in linked list containing less than 2 elements
    orig = linked_list.head
    while orig:
        prev = orig
        current = orig.next
        while current:
            if current.data == orig.data:
                prev.next = current.next
                current = current.next
            else:
                prev = current
                current = current.next
        orig = orig.next


linked_list = LinkedList()
node1 = Node('1')
node2 = Node('2')
node3 = Node('3')
node4 = Node('2')
node5 = Node('4')
node6 = Node('1')
linked_list.head = node1
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5
node5.next = node6
assert str(linked_list) == '1 -> 2 -> 3 -> 2 -> 4 -> 1 -> None'
remove_dups(linked_list)
assert str(linked_list) == '1 -> 2 -> 3 -> 4 -> None'
