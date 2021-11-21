package CrackingCodingInterview.TreesAndGraphs;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Data
public class Vertex {
    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList = new LinkedList<>();
    public Vertex(String name){
        this.name = name;
    }

    public void addNeighbor(Vertex v){
        this.adjacencyList.add(v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                '}';
    }
}
