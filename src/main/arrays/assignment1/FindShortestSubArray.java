package leetcode.arrays.assignment1;

import java.util.*;
//https://leetcode.com/problems/degree-of-an-array/submissions/
class FindShortestSubArray {
    public static int findShortestSubArray(int[] nums) {
        int[] left = new int[nums.length], right = new int[nums.length];
        HashMap<Integer, int[]> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] lr;
            if (!freq.containsKey(nums[i])) {
                lr = new int[3];
                lr[0] = i;
                lr[2] = 1;
            } else {
                lr = freq.get(nums[i]);
                lr[2]++;
            }
            lr[1] = i;
            freq.put(nums[i], lr);
        }
        int min = 1,max = -1;

        for (Map.Entry<Integer, int[]> entry : freq.entrySet()) {
           // System.out.println("Number "+ entry.getKey() + " start "+ entry.getValue()[0] + " end "+entry.getValue()[1] + " frequency " + entry.getValue()[2]);
           // System.out.println("max "+ max + " min "+min);
            int len = entry.getValue()[1] - entry.getValue()[0]+1;
            if (max < entry.getValue()[2]) {
                max = entry.getValue()[2];
                min = len;
            }

            if(max == entry.getValue()[2]){
                if(min > len)
                    min = len;
            }

        }

        return min;
    }

    public static void main(String[] args) {
        int[] ip = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(ip));
    }
}