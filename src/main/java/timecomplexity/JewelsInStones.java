package timecomplexity;

public class JewelsInStones {
    public static int numJewelsInStones(String jewels, String stones) {
        int cnt = 0;
        for(int i=0; i < jewels.length();i++){
            System.out.println(jewels.substring(i,i+1));
            System.out.println(stones.contains( jewels.substring(i,i+1)));
            if(stones.contains( jewels.substring(i,i+1))){
                cnt++;
            }
        }
        return cnt;
        
    }
    public static void main(String[] args){
        int ans = numJewelsInStones("aA","aAAbbbb");
        System.out.println(ans);
    }
}