package graphs.meetingroom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinNoOfMeetingRooms {
    public static void main(String[] args){
       System.out.println(minMeetingRooms(getInterval1()));
        System.out.println(minMeetingRooms(getInterval2()));
        System.out.println(minMeetingRooms(getInterval3()));
         System.out.println(" [[1,5],[8,9],[8,9]]" + minMeetingRooms(getInterval4()));
    }

    private static int[][] getInterval1(){
        int[][] intervals = new int[3][2];
        intervals[0][0] = 0;
        intervals[0][1] = 30;

        intervals[1][0] = 5;
        intervals[1][1] = 10;

        intervals[2][0] = 15;
        intervals[2][1] = 20;

        return intervals;

    }

    private static int[][] getInterval2(){
        int[][] intervals = new int[3][2];
        intervals[0][0] = 9;
        intervals[0][1] = 10;

        intervals[1][0] = 4;
        intervals[1][1] = 9;

        intervals[2][0] = 4;
        intervals[2][1] = 17;

        return intervals;

    }

    private static int[][] getInterval3(){
        int[][] intervals = new int[3][2];
        intervals[0][0] = 13;
        intervals[0][1] = 15;

        intervals[1][0] = 1;
        intervals[1][1] = 13;

        intervals[2][0] = 6;
        intervals[2][1] = 9;

        return intervals;

    }

    private static int[][] getInterval4(){
        int[][] intervals = new int[3][2];
        intervals[0][0] = 1;
        intervals[0][1] = 5;

        intervals[1][0] = 8;
        intervals[1][1] = 9;

        intervals[2][0] = 7;
        intervals[2][1] = 9;

        return intervals;

    }



    public static int minMeetingRooms(int[][] intervals) {
        return canAttendMeetings(intervals);
    }

    public static int canAttendMeetingsPQ(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i=1;i < intervals.length ; i++){

           if(pq.peek() <= intervals[i][0]){
               pq.poll();
           }

            pq.add(intervals[i][1]);

        }

        return pq.size();

    }

    public static int canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        List<int[]> meetingRooms = new ArrayList<>();
        meetingRooms.add(intervals[0]);
        for(int i=1;i < intervals.length ; i++){

                boolean foundMeeting = false;
                for(int j=0; j < meetingRooms.size() ; j++) {
                    int[] meetingRoom = meetingRooms.get(j);
                    int meetingStart = meetingRoom[0];
                    int meetingEnd = meetingRoom[1];

                    if(meetingEnd <= intervals[i][0] ) {
                        meetingRooms.set(j,intervals[i]);
                        foundMeeting =true;
                        break;
                    }

                }
                if(!foundMeeting) {
                    meetingRooms.add(intervals[i]);
                }



        }

        return meetingRooms.size();

    }
}
