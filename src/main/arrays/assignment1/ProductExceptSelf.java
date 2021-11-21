package leetcode.arrays.assignment1;

//https://leetcode.com/problems/product-of-array-except-self/
class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 1)
            return new int[]{1};

        int[] productToLeft = getProductToLeft(nums);
        int[] productToRight = getProductTorRight(nums);

        return multiplyTwoArrays(productToLeft, productToRight);

    }

    public int[] multiplyTwoArrays(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length ; i++) {
            res[i] = arr1[i] * arr2[i];
        }
        return res;
    }

    public int[] getProductToLeft(int[] nums) {
        int[] productToLeft = new int[nums.length];
        productToLeft[0] = 1;


        for (int i = 1; i < nums.length; i++) {
            productToLeft[i] = nums[i - 1] * productToLeft[i - 1];
        }
        return productToLeft;

    }

    public int[] getProductTorRight(int[] nums) {
        int[] productToRight = new int[nums.length];
        productToRight[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            productToRight[i] = nums[i + 1] * productToRight[i + 1];
        }
        return productToRight;

    }
}