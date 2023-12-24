package algorithms.backtracking;


import java.util.ArrayList;
import java.util.List;

public class PrintCombinations {

    public static void main(String args[]) {

        List<List<Integer>> combinations = combine(5, 3);
        System.out.println(combinations);

    }


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> sols = new ArrayList<>();

        if (k == 1) {
            for (int j = 1; j <= n; j++) {
                List<Integer> sol = new ArrayList<>();
                sol.add(j);
                sols.add(sol);
            }
            return sols;
        }


        for (int i = 1; i <= n - k + 1; i++) {
            List<List<Integer>> subSol = combine(n, k, i);
            System.out.println("i:  + " + i + " k: " + k + " sols" + subSol);
            sols.addAll(subSol);
        }

        return sols;

    }

    private static List<List<Integer>> combine(int n, int k, int i) {

        System.out.println("calculating for i " + i + " k:" + k);

        if (k == 1) {
            List<List<Integer>> sols = new ArrayList<>();
            for (int j = i; j <= n; j++) {
                List<Integer> sol = new ArrayList<>();
                sol.add(j);
                sols.add(sol);
            }

            System.out.println("i: " + i + " k:" + k + " result: " + sols);
            return sols;
        }

        List<List<Integer>> sols = new ArrayList<>();
        for (int it = i + 1; it <= n-k; it++) {
            List<List<Integer>> subsols = combine(n, k - 1, it);

            for (List<Integer> sol : subsols) {
                sol.add(i);
            }

            sols.addAll(subsols);

        }

        return sols;

    }
}
