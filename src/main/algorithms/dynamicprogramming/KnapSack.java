package leetcode.studyplan.dynamicprogramming;

import java.util.Arrays;

class Item {
    int weight, price;

    public Item(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}

public class KnapSack {
    public static void main(String[] args) {
        Item[] ip = new Item[5];
        ip[0] = new Item(12, 4);
        ip[1] = new Item(2, 2);
        ip[2] = new Item(1, 2);
        ip[3] = new Item(1, 1);
        ip[4] = new Item(4, 10);

        System.out.println(getMaximizedValue(ip, 15));
        ip = new Item[3];
        ip[0] = new Item(10, 60);
        ip[1] = new Item(20, 100);
        ip[2] = new Item(30, 120);

        System.out.println(getMaximizedValue(ip, 50));

    }

    public static int getMaximizedValue(Item[] ip, int w) {
        int[][] res = new int[ip.length][w + 1];

        for (int i = 1; i < ip.length; i++) {
            Arrays.fill(res[i], -1);
        }


        int val = getMaximizedValue(ip, w, ip.length - 1, res);
        //System.out.println(Arrays.deepToString(res));
        return val;
    }

    public static int getMaximizedValue(Item[] ip, int w, int i, int[][] res) {
        if(i >= 0)
        System.out.println("w "+ w + " i " + i);
        //System.out.println(Arrays.deepToString(res));
        if (i < 0) {
            return 0;
        } else if (i == 0) {
            if (w >= ip[0].weight) {
                res[i][w] = ip[0].price;
                System.out.println("res[i][w] "+ res[i][w]);
                return ip[0].price;
            } else {
                res[i][w] = 0;
                System.out.println("res[i][w] "+ res[i][w]);
                return 0;
            }
        }

        if (res[i - 1][w] == -1){
            res[i - 1][w] = getMaximizedValue(ip, w, i - 1, res);
        }

        int w1 = w - ip[i].weight;
        if (w1 < 0) {
            res[i][w] = Math.max(res[i - 1][w], 0);
            return res[i][w];
        }
        if (res[i - 1][w1] == -1)
            res[i - 1][w1] = getMaximizedValue(ip, w1, i - 1, res);
        res[i][w] = Math.max(res[i - 1][w], ip[i].price + res[i - 1][w1]);
        System.out.println("w "+ w + " i " + i + " res[i][w] "+ res[i][w]+ " i-1 "+ (i-1) + " w1 " + w1 +" res[i-1][w1] " + res[i-1][w1]);
        return res[i][w];

    }


}
