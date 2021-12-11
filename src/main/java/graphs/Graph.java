package graphs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@Data
@AllArgsConstructor
public class Graph {
    private Vertex root;
    public void bfsTraversal() {
        Queue<Vertex> queue = new LinkedList<>();
        root.setVisited(true);
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex start = queue.remove();
            System.out.println("Actual visited vertex: " + start.getName());
            for (Vertex v : start.getAdjacencyList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }

    }

    public static boolean routeExists(Vertex a, Vertex b){
        Queue<Vertex> queue = new LinkedList<>();
        a.setVisited(true);
        queue.add(a);
        while (!queue.isEmpty()){
            Vertex i = queue.remove();
            System.out.println("visited vertex: "+ i);
            for (Vertex neighbor: i.getAdjacencyList()){
                if(neighbor.isVisited() == false){
                    neighbor.setVisited(true);
                    queue.add(neighbor);
                }

                if(neighbor.equals(b)){
                    return true;
                }

            }
        }
        return false;
    }

    public void dfsTraversal(){
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);
        root.setVisited(true);
        while (!stack.isEmpty()){
            Vertex v = stack.pop();
            System.out.println("Vertex " + v);
            for (Vertex neighbor: v.getAdjacencyList()){
                if(neighbor.isVisited() == false){
                    neighbor.setVisited(true);
                    stack.add(neighbor);
                }
            }
        }

    }

    public void dfsUsingRecursion(Vertex vertex){
        vertex.setVisited(true);
        System.out.println("Vertex: "+ vertex);
        for (Vertex neighbor: vertex.getAdjacencyList()) {
            if(!neighbor.isVisited()) {
                dfsUsingRecursion(neighbor);
            }
        }
    }

}
