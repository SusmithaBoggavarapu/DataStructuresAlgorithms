package leetcode.timecomplexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class MinAbsOptimized {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minAbs = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < minAbs) {
                minAbs = diff;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff == minAbs) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            }
        }

        return ans;
    }

}