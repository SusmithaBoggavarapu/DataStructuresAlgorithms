package leetcode.timecomplexity;

// https://leetcode.com/problems/container-with-most-water/
public class MaxAreaXY {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int start = i;
            for (int j = 0; j < i; j++) {
                if (height[j] >= height[i]) {
                    start = j;
                    break;
                }
            }
            int end = i;
            for (int j = height.length - 1; j > i; j--) {
                if (height[j] >= height[i]) {
                    end = j;
                    break;
                }
            }

            int area = height[i] * (end - start);
            if (area > max) {
                max = area;
            }
        }
        return max;
    }
}
