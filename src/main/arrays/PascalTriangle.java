package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*https://leetcode.com/problems/pascals-triangle-ii/submissions/ */
class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        if (rowIndex == 0) {
            return res;
        }

        List<Integer> prev = getRow(rowIndex - 1);
        int j = prev.get(0);
        for (int i = 1; i < prev.size(); i++) {
            int k = prev.get(i);
            res.add(j + k);
            j = k;
        }
        res.add(1);
        return res;


    }
}