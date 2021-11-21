package leetcode.studyplan.dynamicprogramming;

class NTribonnacci {
    public int tribonacci(int n) {
        return tribonacci(n, new int[n]);
    }

    public int tribonacci(int n, int[] res) {
        if (n == 0) {
            res[0] = 0;
            return res[0];
        }
        if (n == 1) {
            res[1] = 1;
            return res[1];
        }
        if (n == 2) {
            res[2] = 1;
            return res[2];
        }

        // res[n] = res[n-1] + res[n-2] + res[n-3];
        return n;

    }
}