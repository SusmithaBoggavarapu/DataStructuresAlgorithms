package leetcode.studyplan.dynamicprogramming;

import java.util.Arrays;

public class PartitionEqualSet {
    public static void main(String[] args) {
        int[] ip = {1, 5, 10, 6};
        PartitionEqualSet p = new PartitionEqualSet();
        System.out.println(p.canPartition(ip));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1)
            return false;

        return arraySum(nums, sum / 2);

    }

    public boolean arraySum(int[] nums, int sum) {
        Boolean[][] res = new Boolean[nums.length][sum + 1];
        for (int i = 1; i < nums.length; i++) {
            Arrays.fill(res[i], null);
        }
        return arraySum(nums, sum, nums.length - 1, res);
    }

    public boolean arraySum(int[] nums, int sum, int i, Boolean[][] res) {
        if (i < 0) {
            return false;
        }

        if (i == 0) {
            if (nums[i] != sum) {
                res[i][sum] = false;
                return false;
            } else {
                res[i][sum] = true;
                return true;
            }
        }

        if (sum == 0) {
            res[i][sum] = true;
            return true;
        }

        if (nums[i] == sum) {
            res[i][sum] = true;
            return true;
        }

        if (res[i - 1][sum] == null) {
            res[i - 1][sum] = arraySum(nums, sum, i - 1, res);
        }

        int newSum = sum - nums[i];

        if (newSum < 0) {
            res[i][sum] = false;
            return false;
        }

        if (res[i - 1][newSum] == null) {
            res[i - 1][newSum] = arraySum(nums, newSum, i - 1, res);
        }


        res[i][sum] = res[i - 1][sum] || res[i - 1][newSum];

        return res[i][sum];


    }
}