from collections import deque
from typing import Optional


class Node:
    def __init__(self, name: str) -> None:
        self.name = name
        self.children = []

    def __str__(self) -> str:
        return f"Node({self.name})"


def bfs(start_node: Node, search_name: str) -> Optional[Node]:
    queue = deque()
    queue.append(start_node)
    visited_nodes = {start_node}
    while queue:
        current_node: Node = queue.popleft()
        if current_node.name == search_name:
            return current_node
        print(f"Node {current_node.name} visited")
        for child in current_node.children:
            if child not in visited_nodes:
                queue.append(child)
                visited_nodes.add(child)
    return None


a = Node('A')
b = Node('B')
c = Node('C')
d = Node('D')
e = Node('E')
f = Node('F')
g = Node('G')
h = Node('H')
i = Node('I')

a.children = [b,c,d]
b.children = [e,f]
c.children = [g]
d.children = [h, i]

print("Node found: ", bfs(a, 'D'))
