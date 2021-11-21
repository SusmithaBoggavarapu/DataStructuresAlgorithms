package leetcode.arrays.assignment1;

//https://leetcode.com/problems/3sum-closest/submissions/

class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3)
            return nums[0]+nums[1]+nums[2];
        int minAbsDiff=Integer.MAX_VALUE,res=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                   int sum = nums[i]+nums[j]+nums[k];
                   int absDiff = Math.abs(target-sum);
                    if(absDiff < minAbsDiff){
                        res = sum; 
                        minAbsDiff = absDiff;
                    }
                    
                }
            }
        }
        return res;
    }
}