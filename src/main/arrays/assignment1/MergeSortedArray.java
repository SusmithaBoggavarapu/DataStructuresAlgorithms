package leetcode.arrays.assignment1;

import java.util.Arrays;

class MergeSortedArray {
    public static int[] merge(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length, i = 0, j = 0,k=0;
        int[] res = new int[len];

        while (k < len && i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[k] = nums1[i++];
            } else {
                res[k] = nums2[j++];
            }
            k++;
        }

        while (i < nums1.length){
            res[k++] = nums1[i++];
        }

        while (j < nums2.length){
            res[k++] = nums2[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3,4,9,12};
        int[] nums2 = {2, 5, 6,15,29,33};
        int[] res = merge(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}