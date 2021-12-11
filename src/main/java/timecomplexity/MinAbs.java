package timecomplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class MinAbs {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minAbs = abs(arr[0], arr[1]);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int abs = abs(arr[i], arr[j]);
                if (minAbs < abs) {
                    continue;
                }
                if (minAbs > abs) {
                    ans.clear();
                    minAbs = abs;
                }
                add(ans,arr[i],arr[j]);

            }
        }
        return sort(ans);
    }
    public void add(List<List<Integer>> res, int a, int b){
        List<Integer> pair = new ArrayList<>();
        if (a > b) {
            pair.add(a);
            pair.add(b);
        } else {
            pair.add(a);
            pair.add(b);
        }
        res.add(pair);
    }
    public List<List<Integer>> sort(List<List<Integer>> res){
     return   res.stream().sorted(((o1, o2) -> {
            if(o1.get(0) > o2.get(0)) {
                return -1;
            }else if(o1.get(0) < o2.get(0) ){
                return 1;
            }
            return 0;
        })).collect(Collectors.toList());

    }

    public int abs(int a, int b) {
        return a > b ? a - b : b - a;
    }
}