package graphs.shortestpath.dijkstra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Edge {
    int weight;
    Vertex startV, endV;
}
