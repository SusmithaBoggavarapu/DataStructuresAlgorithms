package algorithms;

//array of positive integers
//2,10,8,0
// number as n - input - 10
//pairs

// 2, 5,0
// 2, 5, 5,0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String args[]) {
        int[] ip = {2,10,8,0};
        int targetSum = 10;
        getPairs(ip,targetSum);
        //HashSet<Integer> values = new HashSet<>()

    }

    private static List<Pair> getPairs(int[] ip, int targetSum){
        List<Pair> solPairs = new ArrayList<>();

        for (int i = 0; i < ip.length; i++) {
            int target = targetSum - ip[i];
            for(int j=0; j < ip.length; j++){
                if( i== j){
                    continue;
                }

                if(target == ip[j]){
                    solPairs.add(new Pair(ip[i],ip[j]));
                }

            }
        }

        solPairs.forEach(pair-> System.out.println(pair));
        return solPairs;

    }



}

class Pair {
    int x,y;

    public Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        boolean isequal =  (x == pair.x && y == pair.y) || (x == pair.y && y == pair.x);
        return isequal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
