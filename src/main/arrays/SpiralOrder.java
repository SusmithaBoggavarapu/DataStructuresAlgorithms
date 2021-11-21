package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/submissions/
class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        List<Integer> res = new ArrayList<>();
        int min = n > m ? m : n;
        int i=-1,j=-1;
        //each spiral
        for(int tmp=0;tmp<= (min-1)/2 ;tmp++){
            if(j==tmp){
                continue;
            }

            i = tmp;j=tmp;
            //right
            for(; j< n-tmp;j++){
                res.add(matrix[i][j]);
            }
            j--;i++;
            //bottom
            boolean bottomSet = false;
            for(;i<m-tmp;i++){
                bottomSet = true;
                res.add(matrix[i][j]);
            }
            i--;j--;
            //left
            if(!bottomSet)
                continue;
            boolean leftSet = false;
            for(;j>=tmp;j--){
                leftSet = true;
                res.add(matrix[i][j]);
            }
            if(!leftSet)
                continue;
            j++;i--;
            //up
            for(;i>tmp;i--){
                res.add(matrix[i][j]);
            }
            i++;

        }
        return res;

    }
}