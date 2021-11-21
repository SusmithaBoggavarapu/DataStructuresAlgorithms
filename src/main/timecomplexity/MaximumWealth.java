package leetcode.timecomplexity;

class MaximumWealth {
    public int maximumWealth(int[][] account) {
        int maxWealth = 0 ; 
        
        for(int i=0;i<account.length;i++){
            int wealth = account[i][0];
            for(int j=1;j<account[0].length;j++){
                wealth +=   account[i][j] ;
            }
            if(wealth > maxWealth ){
                maxWealth = wealth;
            }
        }
        return maxWealth;
        
    }
}