//https://leetcode.com/problems/rotate-image/submissions/
/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    var n = matrix.length;
   for(let i=0;i< (n-1)/2 ; i++){
       for(let j=0;j<= (n-1)/2;j++){
           let firstValue = matrix[i][j];

           //copy 4rth to 1st
           matrix[i][j] =  matrix[n-1-j][i];

           //copy 3rd to 4rth
           matrix[n-1-j][i]=  matrix[n-1-i][n-1-j] ;

           //copy 2nd to 3rd
           matrix[n-1-i][n-1-j]= matrix[j][n-1-i];

           //copy 1st to 2nd
           matrix[j][n-1-i] = firstValue;
           console.log(matrix);
       }
   }
};