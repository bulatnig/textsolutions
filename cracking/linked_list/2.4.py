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


def partition(ll: LinkedList, x: int) -> None:
    right = None
    # in case first element >= x then we need to change list head pointer
    while ll.head and ll.head.data >= x:
        new_head = ll.head.next
        if right:
            ll.head.next = right
        else:
            ll.head.next = None
        right = ll.head
        ll.head = new_head
    # list was empty or all element were moved to right
    if not ll.head:
        ll.head = right
        return
    # input list got a head < x, so we iterate through the rest
    node = ll.head
    while node.next:
        if node.next.data >= x:
            new_next = node.next.next
            if right:
                node.next.next = right
            else:
                node.next.next = None
            right = node.next
            node.next = new_next
        else:
            node = node.next
    node.next = right


linked_list = LinkedList()
node1 = Node(3)
node2 = Node(5)
node3 = Node(8)
node4 = Node(5)
node5 = Node(10)
node6 = Node(2)
node7 = Node(1)
linked_list.head = node1
node1.next = node2
node2.next = node3
node3.next = node4
node4.next = node5
node5.next = node6
node6.next = node7
partition(linked_list, 5)
print(linked_list)
assert str(linked_list) == "3 -> 2 -> 1 -> 10 -> 5 -> 8 -> 5 -> None"
