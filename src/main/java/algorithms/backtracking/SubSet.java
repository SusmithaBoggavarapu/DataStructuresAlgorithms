package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {

    public static void main(String args[]) {
        int[] ip = {2,10,0,1};
        List<List<Integer>>  subsets = powerSet(ip,ip.length-1);

        System.out.println(subsets);
        System.out.println(bitMasking(ip));

    }
    private static  List<List<Integer>>  bitMasking(int[] ip){
        int len = ip.length;
        int start = (int) Math.pow(2,len);
        int end = (int) Math.pow(2,len+1);
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = start; i < end ; i++) {
            String bitMask = Integer.toBinaryString(i);

            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < len ; j++) {
                if(bitMask.charAt(j+1) == '1'){
                    subset.add(ip[j]);
                }
            }
            System.out.println(bitMask+" " + subset);
            sol.add(subset);
        }
        return sol;
    }


    private static List<List<Integer>>  powerSet(int[] ip, int start){
        if(start == -1){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        List<List<Integer>> res = powerSet(ip,start-1);
        //System.out.println("subsets with startIndex "+ (start-1) + "subsets: " + res);
        int size = res.size();

        for(int i=0;i<size;i++){
            List<Integer> set = res.get(i);
            List<Integer> newSet = new ArrayList<>(set);
            newSet.add(ip[start]);
            res.add(newSet);

        }

       return res;

    }

    private static List<List<Integer>> cascade(int[] nums){
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList<>());
        Arrays.stream(nums).forEach(num ->
        {
            List<List<Integer>> existingSets = new ArrayList<>(result);
            existingSets.parallelStream().forEach( set -> {
                set.add(num);
            });
            result.addAll(existingSets);
        });
                return result;
    }
}
