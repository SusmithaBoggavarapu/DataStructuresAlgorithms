package trees.assignment1.practise;

import java.util.*;

class Solution {
    int edgeCnt = 0, totalCost = 0, noOfPoints = 0;
    Set<Integer> visited = new HashSet<>();

    public int minCostConnectPoints(int[][] points) {
        HashSet<Integer> lastVertices = new HashSet<Integer>();
        noOfPoints = points.length;
        //cost b/w each edge
        HashMap<int[], Integer> costMap = getCosts(points);
        printCostMap(costMap);
        HashSet<int[]> visitedEdges = new HashSet<>();
        lastVertices.add(0);
        return minCostConnectPoints(costMap, visitedEdges, lastVertices);

    }

    private void printCostMap(HashMap<int[], Integer> costMap) {
        System.out.println(" cost map is :");
        int i = 0;

        for (Map.Entry<int[], Integer> edgeCost : costMap.entrySet()) {
            int[] edge = edgeCost.getKey();
            Integer cost = edgeCost.getValue();
            System.out.println("edge cost between : i " + edge[0] + " j:  " + edge[1] + " is: " + cost);
        }
    }

    private int minCostConnectPoints(HashMap<int[], Integer> cost, HashSet<int[]> visitedEdges, HashSet<Integer> lastVertices) {

        while (visited.size() < noOfPoints) {

            int[] nextMinCostEdge = getMinCostEdges(cost, visitedEdges, lastVertices);
            //noOfPoints--;
            if (nextMinCostEdge == null) {
                continue;
            }
            System.out.println(" minCostEdge: " + nextMinCostEdge[0] + " " + nextMinCostEdge[1]);
            visitedEdges.add(nextMinCostEdge);

        }
        return totalCost;
    }

    int[] getMinCostEdges(HashMap<int[], Integer> costMap, HashSet<int[]> visitedEdges, HashSet<Integer> lastVertices) {
        int minCost = Integer.MAX_VALUE;
        int[] minCostEdge = null;
        for (Map.Entry<int[], Integer> edgeCost : costMap.entrySet()) {

            int[] edge = edgeCost.getKey();
            Integer cost = edgeCost.getValue();

            if (visitedEdges.contains(edge) || (visited.contains(edge[0]) && visited.contains(edge[1])))
                continue;
            //    System.out.println("edge cost between : i " + edge[0] + " j:  " + edge[1] + " is: " + cost);
            if (lastVertices.contains(edge[0]) || lastVertices.contains(edge[1])) {

                if (minCost >= cost) {
                    minCost = cost;
                    minCostEdge = edge;

                }
            }
        }

        if (minCostEdge == null)
            return null;

        visited.add(minCostEdge[0]);
        visited.add(minCostEdge[1]);

        if (lastVertices.contains(minCostEdge[0])) {
            lastVertices.remove(minCostEdge[0]);
            lastVertices.add(minCostEdge[1]);
        } else {
            lastVertices.remove(minCostEdge[1]);
            lastVertices.add(minCostEdge[0]);
        }

        System.out.println("totalCost: " + totalCost + " min cost: " + minCost + " minCostEdge: " + minCostEdge[0] + " " + minCostEdge[1]);
        totalCost += minCost;
        return minCostEdge;
    }

    private HashMap<int[], Integer> getCosts(int[][] points) {

        HashMap<int[], Integer> costMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                int[] edge = {i, j};
                costMap.put(edge, cost);
            }
        }
        return costMap;
    }
}