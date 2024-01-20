package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumbers {

    int[] cnt;
    public List<Integer> findDisappearedNumbers(int[] nums) {
        cnt = new int[nums.length+1];
        Arrays.stream(nums).forEach( i -> {
            if(i < nums.length+1 ){
                cnt[i]++;
            }
        });

        List<Integer> missingNums = new ArrayList<>();
        Arrays.stream(nums).forEach( i -> {
            if( cnt[i] == 0 ){
                missingNums.add(i);
            }
        });
        return missingNums;
    }
}
