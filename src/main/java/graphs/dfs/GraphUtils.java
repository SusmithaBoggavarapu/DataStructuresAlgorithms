package graphs.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphUtils {
    public static  void main(String[] args){
        Graph g  = constructGraph();
        g.BFS();
    }

    public static Graph constructGraph(){
        HashMap<Vertex, List<Vertex>> adjacencyList = new HashMap<>();
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        ArrayList<Vertex> neighbours0 = new ArrayList<>();

        neighbours0.add(v1);
        neighbours0.add(v3);
        neighbours0.add(v4);

        ArrayList<Vertex> neighbours1 = new ArrayList<>();
        neighbours1.add(v0);
        neighbours1.add(v3);

        ArrayList<Vertex> neighbours2 = new ArrayList<>();
        neighbours2.add(v3);
        neighbours2.add(v4);

        ArrayList<Vertex> neighbours3 = new ArrayList<>();
        neighbours3.add(v1);
        neighbours3.add(v2);
        neighbours3.add(v4);

        ArrayList<Vertex> neighbours4 = new ArrayList<>();
        neighbours4.add(v2);
        neighbours4.add(v3);

        adjacencyList.put(v0,neighbours0);
        adjacencyList.put(v1,neighbours1);
        adjacencyList.put(v2,neighbours2);
        adjacencyList.put(v3,neighbours3);
        adjacencyList.put(v4,neighbours4);

        Graph graph = new Graph();
        graph.setAdjacencyList(adjacencyList);

        List<Vertex> vertices = new ArrayList<>();
        vertices.add(v0);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);

        graph.setVertices(vertices);
        return graph;
    }

}
