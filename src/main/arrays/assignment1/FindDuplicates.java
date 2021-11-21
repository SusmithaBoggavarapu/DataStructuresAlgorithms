package leetcode.arrays.assignment1;
//https://leetcode.com/problems/find-all-duplicates-in-an-array/submissions/

import java.util.ArrayList;
import java.util.List;

class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        int[] charCnt = new int[nums.length];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            charCnt[nums[i] - 1]++;
        }

        for (int i = 0; i < charCnt.length; i++) {
            if (charCnt[i] == 2) {
                list.add(i + 1);
            }
        }
        return list;


    }
}