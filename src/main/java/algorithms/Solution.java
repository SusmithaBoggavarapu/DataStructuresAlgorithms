package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    int nodes = 0;

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        HashMap<int[], Integer> visited = new HashMap<>();
        Set<Integer> visitedNodes = new HashSet<>();

        bfs(0, visited, visitedNodes, maxMoves, edges);
        System.out.println("visited nodes" + visitedNodes);
        return nodes + visitedNodes.size();
    }

    private void bfs(int source, HashMap<int[], Integer> visited, Set<Integer> visitedNodes, int maxLength, int[][] edges) {
        if (maxLength <= 0)
            return;

        System.out.print("source: " + source);
        for (int i = 0; i < edges.length; i++) {
            if (visited.containsKey(edges[i]))
                continue;
            int neighbour = edges[i][0] == source ? edges[i][1] : edges[i][0];

            System.out.println(" neighbour: " + neighbour);

            if (isEdgeCompletlyVisited(visited, edges[i]))
                continue;

            int splitNodes = edges[i][2];
            System.out.println("splitNodes: " + splitNodes + " max nodes:  " + maxLength);
            if (splitNodes > maxLength - 1) {
                visitedNodes.add(source);
                nodes += maxLength;
                visited.put(edges[i], visited.get(edges[i]) == null ? maxLength : visited.get(edges[i]) + maxLength);
                System.out.println("can traverse until: " + maxLength + "\n");

            } else {
                visitedNodes.add(source);
                visitedNodes.add(neighbour);
                nodes += splitNodes;
                visited.put(edges[i], visited.get(edges[i]) == null ? splitNodes : visited.get(edges[i]) + splitNodes);
                System.out.println(" visiting next node\n");
                bfs(neighbour, visited, visitedNodes, maxLength - splitNodes, edges);
            }
            System.out.println("nodes: " + nodes);

        }

    }

    private boolean isEdgeCompletlyVisited(HashMap<int[], Integer> visitedEdges, int[] edge) {
        if (!visitedEdges.containsKey(edge))
            return false;
        return visitedEdges.get(edge) >= edge[2] ? true : false;
    }
}