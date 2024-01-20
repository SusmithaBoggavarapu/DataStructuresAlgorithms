package algorithms.general;
public class MergeSort {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int start, int end) {

        if (start == end) {
            return new int[]{nums[start]};
        }
        if (start == end - 1) {
            return new int[]{Math.min(nums[start], nums[end]), Math.max(nums[start], nums[end])};
        }
        int mid = (start + end) / 2;

        int[] leftSorted = mergeSort(nums, start, mid);
        int[] rightSorted = mergeSort(nums, mid + 1, end);

        int[] mergeSorted = new int[leftSorted.length + rightSorted.length];
        int i = 0, j = 0, k = 0;
        while (i < leftSorted.length && j < rightSorted.length) {
            mergeSorted[k++] = leftSorted[i] < rightSorted[j] ? leftSorted[i++] : rightSorted[j++];
        }
        while (j < rightSorted.length) {
            mergeSorted[k++] = rightSorted[j++];
        }
        while (i < leftSorted.length) {
            mergeSorted[k++] = leftSorted[i++];
        }
        return mergeSorted;
    }
}