package HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BribersResult {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int minimumBribes = 0;

        for (int i = 0; i < q.size()-1; i++) {
            if (q.get(i) - i - 1 > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = i+1; j < q.size() ; j++) {
                if (q.get(j) < q.get(i)) {
                    //swap variables
                    int tmp = q.get(i);
                    q.set(i, q.get(j));
                    q.set(j, tmp);
                    minimumBribes++;
                }

            }


        }
        System.out.println(minimumBribes);

    }

    static int findNoOfBribersInBetween(int i, int j, TreeSet<Integer> bribers) {
        if (j < i) {
            int tmp = j;
            j = i;
            i = tmp;
        }

        if (j - i == 1)
            return 0;
        int noOfBribers = 0;
        for (int briberNo : bribers) {
            if (briberNo > j) {
                return noOfBribers;
            }

            if (i < briberNo && j > briberNo) {
                noOfBribers++;
            }
        }
        return noOfBribers;
    }

}

public class Bribers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                BribersResult.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
