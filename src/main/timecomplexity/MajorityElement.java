package leetcode.timecomplexity;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> occurances = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (occurances.containsKey(nums[i])) {
                occurances.put(nums[i], occurances.get(nums[i]) + 1);
            } else {
                occurances.put(nums[i], 1);
            }
        }
        int max = 1, maxEle = nums[0];
        for (Map.Entry<Integer, Integer> it : occurances.entrySet()) {
            if (it.getValue() > max) {
                max = it.getValue();
                maxEle = it.getKey();
            }
        }
        return maxEle;

    }
}