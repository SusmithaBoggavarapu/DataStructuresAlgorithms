package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class BribersNewResult {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int minimumBribes = 0;
        Stack<Integer> sortedStack = new Stack<>();

        for (int i = 0; i < q.size(); i++) {
            if (q.get(i) - i - 1 > 2) {
                System.out.println("Too chaotic");
                return;
            }

            if(sortedStack.isEmpty() || sortedStack.peek() < q.get(i)){
                sortedStack.push(q.get(i));
                continue;
            }
            Stack<Integer> poppedStack = new Stack<>();
            while (!sortedStack.isEmpty() && sortedStack.peek() > q.get(i)) {
                int pop = sortedStack.pop();
                poppedStack.add(pop);
                minimumBribes++;
            }
            sortedStack.push(q.get(i));
            while (!poppedStack.isEmpty()){
                sortedStack.push(poppedStack.pop());
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

public class BribersNew {
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
