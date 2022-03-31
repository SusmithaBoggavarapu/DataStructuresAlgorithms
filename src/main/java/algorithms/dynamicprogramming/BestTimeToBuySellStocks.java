package algorithms.dynamicprogramming;

import java.util.Arrays;

public class BestTimeToBuySellStocks {


    //Time complexity n square
    public int maxProfitUsingLoops(int[] prices) {

        int maxProfit = 0;

        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                int profit = prices[j]-prices[i];
                maxProfit = Math.max(profit, maxProfit);

            }
        }

        return maxProfit;
    }

    public int maxProfit(int[] prices){
        int[] minPriceToBuy = new int[prices.length];
        int[] maxPriceToSell = new int[prices.length];
        minPriceToBuy[0] = prices[0];
        maxPriceToSell[0] =0;
        for(int i=1;i< prices.length;i++){
            maxProfitDP(prices,minPriceToBuy,maxPriceToSell,i);
        }
        return maxPriceToSell[prices.length-1] - minPriceToBuy[prices.length-1];
    }

    private int maxProfitDP(int[] prices, int[] minPriceToBuy, int[] maxPriceToSell,int index){
        System.out.println("minPriceToBuy: "+ Arrays.toString(minPriceToBuy) + "maxPriceToSell: "+ Arrays.toString(maxPriceToSell)+ " index: "+index);
        if(index == prices.length-1){
            minPriceToBuy[index] = Math.min(minPriceToBuy[index-1],prices[index]);
            maxPriceToSell[index] = Math.max(maxPriceToSell[index-1],prices[index]);
            return maxPriceToSell[index-1] - minPriceToBuy[index-1];
        }
        minPriceToBuy[index] = Math.min(minPriceToBuy[index-1],prices[index]);
        maxPriceToSell[index] = Math.max(maxPriceToSell[index-1],prices[index]);
        return maxPriceToSell[index] - minPriceToBuy[index];
    }

}
