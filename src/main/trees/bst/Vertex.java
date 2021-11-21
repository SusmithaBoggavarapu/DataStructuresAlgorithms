package CrackingCodingInterview.TreesAndGraphs.bst;

import lombok.Data;

@Data
public class Vertex {
    private String data;
    private boolean visited;
    private Vertex left, right;

    public Vertex(String data) {
        this.data = data;
    }

}
