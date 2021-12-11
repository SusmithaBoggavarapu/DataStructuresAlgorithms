package arrays;
//https://leetcode.com/problems/powx-n/submissions/
class MyPow {
    public double myPow(double x, int n) {
       
      if(n==0 || x == 1) return 1.0;
    
     if(n==1 ) return x;
     
    if(x == -1){
            return n%2 == 0 ? 1 : -1;
        
        }
        if( Integer.MIN_VALUE == n && Math.abs(x) > 1)
            return 0.0; 
    
        
        
        double res = 1.0;
        
        long tmp = n > 0 ? n : -1l* n;
        if(tmp %2 == 1){
            res = res*x;
            tmp--;
        }
        
        while( tmp >0 ) {
            res = x*x*res;
            tmp = tmp-2;
        }
       
        return n > 0 ? res : 1.0 / res;
       
    }
}