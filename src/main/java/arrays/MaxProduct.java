package arrays;

//https://leetcode.com/problems/maximum-product-subarray/submissions/
class MaxProduct {
    public int maxProduct(int[] nums) {
       
        int max = Integer.MIN_VALUE;
        int product = 1;
        for(int i=0;i < nums.length;i ++ ){
            product = 1;
          for(int j =i;j<nums.length;j++){
              product *= nums[j];
              if(max < product)
                 max = product;
          }
        }
        return max;
        
    }
}