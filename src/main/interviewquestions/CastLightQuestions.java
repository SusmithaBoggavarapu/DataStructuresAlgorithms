package animal;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CastLightQuestions {
    //array of integers million numbers
    // 1000 largest numbers

    public static void largestNums(int[] ip) {
        int[] largestNums = new int[1000];

        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < ip.length; i++) {
                if (largestNums[j] < ip[i]) {
                    largestNums[j] = ip[i];
                    ip[i] = -1;
                }
                // need to exclude the added largest element

            }
        }
        System.out.println(Arrays.toString(largestNums));

    }

    class Singleton {
        private Singleton singleton;

        private Singleton() {

        }

        Singleton getInstance() {

            if(singleton !=null){
                return singleton;
            } else  {

                synchronized (this) {
                    if (singleton == null) {
                        singleton = new Singleton();
                    }

                }
            }
            return singleton;
        }
    }

    public static void main(String[] args) {
        int[] ip = new int[100000];
        for (int i = 0; i < ip.length; i++) {
            ip[i] = (int) Math.random();
        }

        System.out.println(Arrays.toString(ip));
        largestNums(ip);
    }
}
