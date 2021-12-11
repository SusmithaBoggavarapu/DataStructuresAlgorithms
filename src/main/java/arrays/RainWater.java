package arrays;

import java.util.Stack;

public class RainWater {
    public int trap(int[] h) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int max_so_far = 0;
        int area = 0;
        for(int i = 1; i < h.length;i++){
            if(s.peek() > h[i] || s.isEmpty()){
                s.push(h[i]);
                if(max_so_far < s.push(h[i])){
                    max_so_far = h[i];
                }
                continue;
            }

            if(s.peek() < h[i]){
                if(max_so_far > h[i]){
                    s.push(h[i]);
                }
                while(!s.isEmpty() && s.peek() < h[i]){
                    int l = s.pop() ;
                    if(l < 0){
                        continue;
                    }


                }
            }
        }
        return  1;
    }
}
