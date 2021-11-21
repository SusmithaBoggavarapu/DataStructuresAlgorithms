package leetcode.timecomplexity;

class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        boolean isFound = false;
        for(int i=0;i<arr.length-2 ; i++){
            if(arr[i] %2 == 0 ){
                continue;
            } else {
                if(arr[i+1] % 2== 0){
                    continue;
                }else{
                    if(arr[i+2] %2 ==0){
                        continue;
                    }else{
                        isFound = true;
                        break;
                    }
                }
            }
        }
        return isFound;
        
    }
}