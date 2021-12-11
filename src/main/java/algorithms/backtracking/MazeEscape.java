package algorithms.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class MazeEscape {
    static int M = 1000000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0)
            return true;
        Set<Long> visited1 = new HashSet<>();
        Set<Long> visited2 = new HashSet<>();
        for (int i = 0; i < blocked.length; i++) {
            long xPlusY = blocked[i][0] + M * blocked[i][1];
            visited1.add(xPlusY);
            visited2.add(xPlusY);
        }

        return bfs(visited1, source, target) && bfs(visited2, target, source);
    }

    public boolean bfs(Set<Long> visited, int[] source, int[] target) {


        Queue<int[]> bfsq = new LinkedList<>();
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        bfsq.add(source);

        int radius = 0;
        while (!bfsq.isEmpty()) {
            if (radius++ > 200) {
                System.out.println("returning true as radius is greater than 200");
                return true;
            }


            int levelSize = bfsq.size();

            while (levelSize-- > 0) {

                int[] vertex = bfsq.poll();
                if (vertex[0] == target[0] && vertex[1] == target[1]) {
                    System.out.println("returning true as target reached x: " + vertex[0] + " y:" + vertex[1]);
                    return true;
                }


                for (int j = 0; j < directions.length; j++) {

                    int[] neighbour = new int[]{vertex[0] + directions[j][0], vertex[1] + directions[j][1]};
                    long xPlusY = neighbour[0] + M * neighbour[1];
                    if (isFeasible(neighbour, source) && visited.contains(xPlusY) == false) {
                        bfsq.add(neighbour);
                        visited.add(xPlusY);
                    }
                }
            }
        }

        return false;

    }

    public boolean isFeasible(int[] vertex, int[] src) {
        long xULimit = Math.min(M - 1, src[0] + 200);
        long xLLimit = Math.max(0, src[0] - 200);
        long yULimit = Math.min(M - 1, src[1] + 200);
        long yLLimit = Math.max(0, src[1] - 200);

        if (vertex[0] < xLLimit || vertex[0] > xULimit)
            return false;
        if (vertex[1] < yLLimit || vertex[1] > yULimit)
            return false;

        return true;
    }

}