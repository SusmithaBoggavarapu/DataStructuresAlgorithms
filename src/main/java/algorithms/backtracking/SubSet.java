package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

    public static void main(String args[]) {
        int[] ip = {2,10,0,1};
        int targetSum = 10;
        List<List<Integer>>  subsets = powerSet(ip,ip.length-1);
        System.out.println(subsets);

    }

    private static List<List<Integer>>  powerSet(int[] ip, int start){
        if(start == -1){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        List<List<Integer>> res = powerSet(ip,start-1);
        System.out.println("subsets with startIndex "+ (start-1) + "subsets: " + res);
        int size = res.size();

        for(int i=0;i<size;i++){
            List<Integer> set = res.get(i);
            List<Integer> newSet = new ArrayList<>(set);
            newSet.add(ip[start]);
            res.add(newSet);

        }

       return res;

    }
}
