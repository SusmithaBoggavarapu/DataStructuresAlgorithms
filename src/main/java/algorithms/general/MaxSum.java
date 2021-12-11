package algorithms.general;

public class MaxSum {
    public static void main(String[] args) {
        int[] ip = {5, 4, -1, 7,8};
        int op = maxSum(ip);
        System.out.println(op);
    }

    static int maxSum(int[] ip) {
        int sum = ip[0], maxSum = ip[0];

        for (int i = 1; i < ip.length; i++) {
            sum += ip[i];

                if (sum < ip[i]) {
                    sum = ip[i];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }

        }

        return maxSum;

    }
}
