package CrackingCodingInterview.TreesAndGraphs;

public class MazeApp {
    public static void main(String[] args) {
        int[][] map = {
                {1,1,1,1,1,1},
                {2,0,0,0,0,1},
                {0,1,0,1,0,1},
                {0,1,0,1,0,0},
                {0,1,0,1,1,0},
                {0,0,0,1,0,0}
        };
        MazeSolver mazeSolver = new MazeSolver(map,2,0);
        mazeSolver.findWay();
        System.out.println(mazeSolver.getSolution());

    }
}
