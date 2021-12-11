package graphs;

import lombok.Data;

import java.util.Stack;

@Data
public class MazeSolver {
    private int[][] maze;
    private boolean[][] visited;
    private int startRow;
    private int startCol;
    private Stack<Index> solution = new Stack<>();

    public MazeSolver(int[][] maze,int startRow, int startCol){
        this.maze = maze;
        this.visited = new boolean[maze.length][maze[0].length];
        this.startCol = startCol;
        this.startRow = startRow;
    }

    public void findWay(){
        if(dfs(startRow,startCol,maze.length-1, maze.length-1)){
            System.out.println("solution exists..");
        }else {
            System.out.println("no solution exists...");
        }
    }
    private boolean isFeasible(int x, int y){
        //vertical dimension (though x indicates row index it indicates vertical dimesion
        if(x < 0 || x > maze.length -1)
            return false;
        //horizontal dimension
        if(y< 0 || y > maze.length -1)
            return  false;

        if(visited[x][y])
            return false;

        if(maze[x][y] > 0)
            return false;

        return true;
    }

    private boolean dfs(int x,int y, int a, int b){
        if(x == a && y == b)
            return true;

        if(isFeasible(x,y)){
            visited[x][y] = true;
            if(dfs(x+1,y,a,b)){
                solution.add(new Index(x+1,y));
                return true;
            }
            if (dfs(x-1,y,a,b)){
                solution.add(new Index(x-1,y));
                return true;
            }
            if(dfs(x,y+1,a,b)){
                solution.add(new Index(x,y+1));
                return true;
            }
            if(dfs(x,y-1,a,b)){
                solution.add(new Index(x,y-1));
                return true;
            }
            visited[x][y] = false;
        }

        return false;

    }
}
