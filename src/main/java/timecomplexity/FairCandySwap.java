package timecomplexity;
//https://leetcode.com/problems/fair-candy-swap/
class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0, bobSum = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            aliceSum  += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length ; i++) {
            bobSum += bobSizes[i];
        }

        int expectedSum = (aliceSum + bobSum ) / 2 ;
        int swapVal = expectedSum - aliceSum ;
        int i=0,j=0;
        boolean isFound = false;
        for (i = 0; i < aliceSizes.length; i++) {
            for (j = 0; j < bobSizes.length; j++) {
                if(bobSizes[j] - aliceSizes[i] == swapVal){
                    isFound = true;
                    break;
                }
            }
            if(isFound) break;
        }
        int[] res = {aliceSizes[i], bobSizes[j]};
        return res;

    }
}