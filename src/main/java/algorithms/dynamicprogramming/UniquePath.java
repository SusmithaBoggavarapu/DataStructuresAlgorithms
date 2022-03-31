package algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class UniquePath {
    
    class Vertex{
    int m,n;
        public Vertex(int m, int n){
            this.m = m;
            this.n = n;
        }
    }
    
    Map<Vertex,Integer> numberofPaths = new HashMap<Vertex,Integer>();
    
    public int uniquePaths(int m, int n) {
        return -1;
    }
}