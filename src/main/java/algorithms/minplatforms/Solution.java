package algorithms.minplatforms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * Given the arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays that represent the arrival and departure times of trains that stop.
 */
public class Solution{

    public static void main(String[] args) {
        Time[] sortedArrivalTimes = getArrivalTimes();
        Arrays.sort(sortedArrivalTimes);
        System.out.println(Arrays.toString(sortedArrivalTimes));

        //Arrays.stream(sortedArrivalTimes).collect(Co)
        Time[] sortedDepartureTimes = getDepartureTimes();
        Arrays.sort(sortedDepartureTimes);
        System.out.println(Arrays.toString(sortedDepartureTimes));

        System.out.println(getMinimumPlatforms(sortedArrivalTimes, sortedDepartureTimes));
       // Objects.hash()

    }

    public static int getMinimumPlatforms(Time[] sortedArrivalTimes, Time[] sortedDepartureTimes) {
        int noOfTrains = sortedArrivalTimes.length;
        int cnt = 0,maxCnt = 0;
        int ai = 0, aj = 0;

        while (ai < noOfTrains || aj < noOfTrains) {
            if (ai == noOfTrains - 1) {
                cnt -= noOfTrains - aj - 1;
                if (maxCnt < cnt)
                    maxCnt = cnt;

                break;
            }

            if (aj == noOfTrains - 1) {
                cnt += noOfTrains - ai - 1;

                if (maxCnt < cnt)
                    maxCnt = cnt;

                break;
            }

            if (sortedArrivalTimes[ai].compareTo(sortedDepartureTimes[aj]) > 0) {
                cnt--;
                aj++;
            } else if (sortedArrivalTimes[ai].compareTo(sortedDepartureTimes[aj]) < 0) {
                cnt++;
                ai++;
            } else {
                ai++;
                aj++;
            }
            if (maxCnt < cnt)
                maxCnt = cnt;

        }
        return maxCnt;

    }

    public static Time[] getArrivalTimes() {
        Time[] arrivalTimes = new Time[6];
        arrivalTimes[0] = new Time(9, 0);
        arrivalTimes[1] = new Time(9, 40);
        arrivalTimes[2] = new Time(9, 50);
        arrivalTimes[3] = new Time(11, 0);
        arrivalTimes[4] = new Time(15, 0);
        arrivalTimes[5] = new Time(18, 0);
        return arrivalTimes;
    }

    public static Time[] getDepartureTimes() {
        Time[] departureTimes = new Time[6];
        departureTimes[0] = new Time(9, 10);
        departureTimes[1] = new Time(12, 0);
        departureTimes[2] = new Time(11, 20);
        departureTimes[3] = new Time(11, 30);
        departureTimes[4] = new Time(19, 0);
        departureTimes[5] = new Time(20, 0);
        return departureTimes;
    }


}

class Time implements Comparable<Time> {
    int hours, minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public int compareTo(Time time) {
        if (time == null) {
            return 1;
        }
        if (this.hours == time.hours) {
            return this.minutes - time.minutes;
        }
        return this.hours - time.hours;
    }

    @Override
    public String toString() {
        return hours + ":" + minutes;
    }
}

