package algorithms.dynamicprogramming;

public class RodCutting {
    public static int maximizeRodCut(int[] rodPrices, int rodLength){
        int[][] memorizedSolution = new int[rodLength][rodLength];
        maximizeRodCut(rodPrices,rodLength,memorizedSolution);
        return 0;
    }

    private static void maximizeRodCut(int[] rodPrices, int rodLength, int[][] memorizedSolution) {
    }

    public static void main(String[] args) {

    }
}
