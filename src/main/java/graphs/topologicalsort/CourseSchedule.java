package graphs.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int time = 1;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       GraphUtils graphUtils = new GraphUtils();
        Graph g  = graphUtils.transformGraph(numCourses,prerequisites);
       // g.print();
        return graphUtils.isAcyclic(g);
    }
 
}

class GraphUtils {
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
        for(int i=0; i< g.noOfVertices;i++){
            if(g.vertices[i].visited)
                continue;
              DFS(g.vertices[i], g);
        }
      
    }

    public boolean isAcyclic(Graph g) {
        DFS(g);
        g.print();
        //for any edge (A -> B) in the graph,
        // if the end time of B (end vertex) is greater than the end time of A (start vertex) then there is a back edge
        // Graph is acyclic if there are no back edges
        int[][] edges = g.getEdges();
        for (int i = 0; i < edges.length; i++) {
            Vertex startV = g.vertices[edges[i][0]];
            Vertex endV = g.vertices[edges[i][1]];
            if (endV.end >= startV.end)
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

         v.visited = true;
        
        if (neighbours == null) {
            v.end = ++time;
            return;
        }
       

        for (int neighbourIndex : neighbours) {
            Vertex neighbour = g.vertices[neighbourIndex];
            if (neighbour.visited)
                continue;
            DFS(neighbour, g);
        }

        v.end = ++time;

    }

    public Graph transformGraph(int noOfVertices, int[][] edges) {
        Graph g = new Graph(noOfVertices);
        convertEdgesToAdjacencyList(edges, g);
        g.setEdges(edges);
        return g;
    }


}

class Graph {
    int noOfVertices;
    List<Integer>[] adjacencylist;
    Vertex[] vertices;
    int[][] edges;
    public int[][] getEdges(){
        return edges;
    }
    public void setEdges(int[][] edges){
        this.edges = edges;
    }

    public Graph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.initializeVertices();
    }

    private void initializeVertices() {
        vertices = new Vertex[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            vertices[i] = new Vertex(i);
        }
    }

    void print() {
        if (noOfVertices <= 0) {
            System.out.println("no vertices");
        }

        for (int i = 0; i < noOfVertices; i++) {
            Vertex v = vertices[i];
            System.out.print("Vertex Number: " + i + " start: " + v.start + " end: " + v.end);
            List<Integer> neighbours = adjacencylist[i];
            if (neighbours == null || neighbours.isEmpty())
                continue;
           System.out.print(" neighbours: ");
            for (int j = 0; j < neighbours.size(); j++) {
                if (j == 0)
                    System.out.print(neighbours.get(j));
                else
                    System.out.print(", " + neighbours.get(j));
            }
            System.out.println();
        }
    }
}

class Vertex {
    int val, start, end;

    public Vertex(int val) {
        this.val = val;
    }

    boolean visited;
}