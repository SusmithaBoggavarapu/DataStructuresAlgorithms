package algorithms;

class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length - 1);
    }

    public int[] searchRange(int[] nums, int target, int left, int right) {
        if (left == right) {
            if (nums[left] != target) {
                return new int[]{-1, -1};
            }
        }
        if (left > right) {
            return new int[]{-1, -1};
        }

        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            while (left >= 0 && nums[left] != target) {
                left--;
            }

            while (right < nums.length && nums[right] != target) {
                right++;
            }

            return new int[]{left + 1, right - 1};

        } else if (nums[mid] > target) {
            return searchRange(nums, target, left, mid - 1);
        } else if (nums[mid] < target) {
            return searchRange(nums, target, mid + 1, right);
        }
        return new int[]{-1, -1};
    }
}