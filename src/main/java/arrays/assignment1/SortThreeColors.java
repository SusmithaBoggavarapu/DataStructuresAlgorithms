package arrays.assignment1;
//https://leetcode.com/problems/sort-colors/submissions/
class SortThreeColors {
    public void sortColors(int[] nums) {
        int sp = 0;
        for(int i=0;i < nums.length;i++){
            if(nums[i] == 0){
                int tmp = nums[sp];
                nums[sp]  = 0;
                nums[i] = tmp;
                sp++;
            }
        }
        
        for(int i=sp;i < nums.length;i++){
            if(nums[i] == 1){
                int tmp = nums[sp];
                nums[sp]  = 1;
                nums[i] = tmp;
                sp++;
            }
        }
        
    }
}