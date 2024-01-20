package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    int[][] coinSols;
    int[] coins;

    public int change(int amount, int[] ip) {
        coins = ip;
        coinSols = new int[ip.length][amount];
        coinSols(0, amount);
        System.out.println("coinSols: " + coinSols);
        for (int i = 0; i < coinSols.length; i++) {
            Arrays.fill(coinSols[i], -1);
        }
        return coinSols[0][amount];
    }

    private int coinSols(int index, int amt) {
        if (coinSols[index][amt] != -1) {
            return coinSols[index][amt];
        }

        if (amt < 0) {
            coinSols[index][amt] = -1;
            return -1;
        }

        if (amt == 0) {
            coinSols[index][amt] = 1;
            return 1;
        }


        int sols = 0;
        for (int i = index; i < coins.length; i++) {
            if (coins[i] > amt) {
                continue;
            }

            int subSol1 = coinSols(i + 1, amt - coins[i]);
            int subSol2 = coinSols(i + 1, amt);
            if (subSol1 != -1) {
                sols = sols + subSol1;
            }

            if (subSol2 != -1) {
                sols = sols + subSol2;
            }
        }
        coinSols[index][amt] = sols;
        return sols;


    }
}