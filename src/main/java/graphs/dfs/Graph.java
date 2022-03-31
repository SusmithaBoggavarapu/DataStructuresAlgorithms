package graphs.dfs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Graph {
    List<Vertex> vertices;
    HashMap<Vertex, List<Vertex>> adjacencyList;

    void DFS() {

    }

    void BFS() {
        HashSet<Vertex> visited = new HashSet<>();
        Vertex source = vertices.get(0);
        BFSRec(source, visited);
    }

    void BFSRec(Vertex source, HashSet<Vertex> visited) {
        if (visited.contains(source)) {
        //    System.out.println(source + "is visited");
            return;
        }
        List<Vertex> neighbours = adjacencyList.get(source);
        if (neighbours == null || neighbours.isEmpty()) {
            System.out.println("no path from this source" + source);
            return;
        }

        System.out.println(source);
        visited.add(source);
        for (Vertex neighbour : neighbours) {
            BFSRec(neighbour, visited);
        }

        return;
    }
}
