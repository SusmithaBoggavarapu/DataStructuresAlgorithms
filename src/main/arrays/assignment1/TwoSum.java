package leetcode.arrays.assignment1;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length ; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target){
                    return new int[]{i+1,j+1};
                }
                if(numbers[i] + numbers[j] > target )
                    break;
            }
        }
        return new int[]{-1,-1};
    }
}