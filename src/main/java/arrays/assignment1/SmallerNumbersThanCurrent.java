package arrays.assignment1;
//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/submissions/
class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];


        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                if(nums[j] < nums[i])
                    res[i]++;

            }
        }
        return res;
    }

}