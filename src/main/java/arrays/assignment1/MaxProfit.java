package arrays.assignment1;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i < prices.length ; i++){
            for(int j =i+1; j < prices.length;j++){
                int profit = j-i;
                if(maxProfit < profit ){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}