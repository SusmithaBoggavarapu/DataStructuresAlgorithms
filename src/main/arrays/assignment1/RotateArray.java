package leetcode.arrays.assignment1;

class RotateArray {
    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        if (k == 0) {
            return;
        }

        int[] tmp = new int[k];
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[len - k + i];
        }

        for (int i = len - 1 - k; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }

    }
}