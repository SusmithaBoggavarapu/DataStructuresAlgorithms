package graphs.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
class Graph {
    int noOfVertices;
    List<Integer>[] adjacencylist;
    Vertex[] vertices;
    int[][] edges;

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
