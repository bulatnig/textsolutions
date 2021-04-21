from collections import deque
from typing import List, Optional


class Vertex:
    def __init__(self, value: str) -> None:
        self.value = value
        self.adjacent_vertices = []

    def __str__(self) -> str:
        return f"Vertex({self.value})"

    def __repr__(self) -> str:
        return self.__str__()


def find_path(vertex1: Vertex, vertex2: Vertex) -> Optional[List[Vertex]]:
    queue = deque()
    queue.append(vertex1)
    visited_vertices = {vertex1}
    previous_vertex = {}
    while queue:
        current_vertex = queue.popleft()
        if current_vertex == vertex2:
            break
        for adjacent_vertex in current_vertex.adjacent_vertices:
            if adjacent_vertex not in visited_vertices:
                visited_vertices.add(adjacent_vertex)
                previous_vertex[adjacent_vertex] = current_vertex
                queue.append(adjacent_vertex)
    path = []
    vertex = vertex2
    while vertex != vertex1:
        path.append(vertex)
        vertex = previous_vertex[vertex]
    path.append(vertex1)
    path.reverse()
    return path


idris = Vertex('Idris')
talia = Vertex('Talia')
ken = Vertex('Ken')
marco = Vertex('Marco')
sasha = Vertex('Sasha')
lina = Vertex('Lina')
kamil = Vertex('Kamil')

idris.adjacent_vertices = [kamil, talia]
kamil.adjacent_vertices = [idris, lina]
lina.adjacent_vertices = [kamil, sasha]
sasha.adjacent_vertices = [lina, marco]
marco.adjacent_vertices = [sasha, ken]
ken.adjacent_vertices = [marco, talia]
talia.adjacent_vertices = [ken, idris]


print("", find_path(idris, marco))
