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


def sum_lists(head1: Node, head2: Node) -> Node:
    overflown = False
    node1 = head1
    node2 = head2
    fake_head = Node(-1)
    result_node = fake_head
    while node1 or node2:
        sum = 1 if overflown else 0
        overflown = False
        if node1:
            sum += node1.data
            node1 = node1.next
        if node2:
            sum += node2.data
            node2 = node2.next
        if sum >= 10:
            overflown = True
            sum = sum % 10
        sum_node = Node(sum)
        result_node.next = sum_node
        result_node = sum_node
    if overflown:
        result_node.next = Node(1)
    return fake_head.next


head1 = Node(1)
head1.next = Node(2)
head2 = Node(7)
node2 = Node(8)
node3 = Node(9)
head2.next = node2
node2.next = node3
result = sum_lists(head1, head2)
ll = LinkedList()
ll.head = result
assert str(result) == "8 -> 0 -> 0 -> 1 -> None"
