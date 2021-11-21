package leetcode.arrays.assignment1;

class FibNonRec {
    public int fib(int n) {
        
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        
        int sum1 = 0, sum2 = 1;
        
        for(int i=2; i <= n;i++){
            int tmp = sum2;
            sum2 += sum1;
            sum1 = tmp;
        }
        return sum2;
    }
}