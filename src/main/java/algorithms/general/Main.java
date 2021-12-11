package algorithms.general;/*
Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}
*/

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class Main {
    public static void main(String[] args) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
        HashMap<Integer,String> idAndName = new HashMap<>();
        idAndName.put(10,"Susmitha");
        idAndName.put(11,"Atchyuth");
        idAndName.put(12,"Nandan");
        ConcurrentLinkedQueue list = new ConcurrentLinkedQueue();
        for(Map.Entry entry : idAndName.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
        Iterator it = list.iterator();

        list.add("susmitha");
        list.add("atchyth");
        list.add("nandan");
        list.add("puppyA");
        list.add("dogs");
        System.out.println(list);
        it = list.iterator();
        while (it.hasNext()){
            String str = (String) it.next();
            System.out.println(str);
            System.out.println(str.equals("dogs"));
            if(str.equals("dogs"))
                it.remove();
        }
        System.out.println(list);
        PriorityQueue<Interval> pq = new PriorityQueue<>();

        pq.add(new Interval(1,2));
        pq.add(new Interval(3,2));
        pq.add(new Interval(4,4));
        pq.add(new Interval(3,4));
        pq.add(new Interval(11,4));
        pq.add(new Interval(9,4));
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + ", ");
        }


        PriorityQueue<Integer> piq = new PriorityQueue<>();
        piq.add(1);
        piq.add(10);
        piq.add(111);
        piq.add(12);
        piq.add(13);
        System.out.println(piq);

        while (!piq.isEmpty()) {
            System.out.print(piq.poll() + " ");
        }

        HashSet s =  new HashSet();
        s.clone();
        ArrayList ar = new ArrayList();
        ar.clone();
        LinkedList ll = new LinkedList();
        ll.clone();
       TreeSet<Interval> set = new TreeSet<>();
        set.add(new Interval(1,2));
        set.add(new Interval(3,2));
        set.add(new Interval(4,4));
        set.add(new Interval(3,4));
        set.add(new Interval(11,4));
        set.add(new Interval(9,4));
        //Hashing techni
        System.out.println(set);
        HashSet hs = new HashSet();
        //set.add(null); treeset does not add nulls
        hs.add(null);
        hs.add(null);
        System.out.println("hash set"+ hs);
        ArrayList al  = new ArrayList();
        al.add(null);
        al.add(null);
        System.out.println("Al " + al);

        //list.add(null); - concurrent deque does not allow null insertions
       // piq.add(null); -  priority queue does not allow null insertions
        idAndName.put(null, "sus");
        idAndName.put(null, "hello");
        System.out.println(idAndName);
    }
    public static void mergeIntervals(Interval arr[])
    {
    }
}

class  IntervalNew {
    int start,end;
    IntervalNew(int start, int end)
    {
        this.start=start;
        this.end=end;
    }

}


class Interval implements Comparable<Interval>
{
    int start,end;
    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
    
    @Override
    public String toString(){
        return "start: " + start + " end: " + end;
    }

    @Override
    public int compareTo(Interval o) {
        return (this.start < o.start) ? -1 : ((this.start == o.start) ? 0 :1) ;
    }
}