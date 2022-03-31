package priorityqueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {


    }

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0;i<stones.length ; i++){
            pq.add(stones[i]);
        }

        while (pq.size() > 1){
            pq.add(pq.poll()- pq.poll());
        }

        return pq.poll();
    }


}

class ReverseOrderComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}



