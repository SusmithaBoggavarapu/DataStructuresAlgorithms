package graphs.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GraphUtils {
    int time = 0;

    private void convertEdgesToAdjacencyList(int[][] edges, Graph g) {

        List<Integer>[] adjacencylist = new List[g.noOfVertices];
        for (int i = 0; i < edges.length; i++) {
            System.out.println(Arrays.toString(edges[i]));
            List neighbours = adjacencylist[edges[i][0]] != null ? adjacencylist[edges[i][0]] : new ArrayList();
            neighbours.add(edges[i][1]);
            adjacencylist[edges[i][0]] = neighbours;
        }
        g.adjacencylist = adjacencylist;
    }

    public void DFS(Graph g) {
        DFS(g.vertices[0], g);
    }

    public boolean isAcyclic(Graph g) {
        DFS(g.vertices[0], g);

        //for any edge (A -> B) in the graph,
        // if the end time of B (end vertex) is greater than the end time of A (start vertex) then there is a back edge
        // Graph is acyclic if there are no back edges
        int[][] edges = g.getEdges();
        for (int i = 0; i < edges.length; i++) {
            Vertex startV = g.vertices[edges[i][0]];
            Vertex endV = g.vertices[edges[i][1]];
            if (endV.end > startV.start)
                return false;
        }
        return true;
    }


    private void DFS(Vertex v, Graph g) {
        System.out.println("DFS Vertex: " + v.val);
        time++;
        if (v.visited) {
            v.end = time;
            return;
        }

        v.start = time;
        List<Integer> neighbours = g.adjacencylist[v.val];

        if (neighbours == null) {
            v.end = ++time;
            return;
        }
        v.visited = true;

        for (int neighbourIndex : neighbours) {
            Vertex neighbour = g.vertices[neighbourIndex];
            if (neighbour.visited)
                continue;
            DFS(neighbour, g);
        }

        v.end = ++time;

    }

    public Graph constructGraph() {
        Graph g = new Graph(5);
        int[][] edges = new int[14][2];

        edges[0][0] = 0;
        edges[0][1] = 1;

        edges[1][0] = 1;
        edges[1][1] = 0;

        edges[2][0] = 0;
        edges[2][1] = 4;

        edges[3][0] = 4;
        edges[3][1] = 0;

        edges[4][0] = 1;
        edges[4][1] = 4;

        edges[5][0] = 4;
        edges[5][1] = 1;

        edges[6][0] = 1;
        edges[6][1] = 2;

        edges[7][0] = 2;
        edges[7][1] = 1;

        edges[8][0] = 1;
        edges[8][1] = 3;

        edges[9][0] = 3;
        edges[9][1] = 1;

        edges[10][0] = 2;
        edges[10][1] = 3;

        edges[11][0] = 3;
        edges[11][1] = 2;

        edges[12][0] = 3;
        edges[12][1] = 4;

        edges[13][0] = 4;
        edges[13][1] = 3;

        convertEdgesToAdjacencyList(edges, g);
        g.setEdges(edges);

        return g;
    }


}
