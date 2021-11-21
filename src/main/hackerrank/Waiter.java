package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Pair {
    int a, b;

    public Pair() {

    }
}

class WaiterResult {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static void list(int[] arr) {
        List<List<Pair>> ans = new ArrayList<>();
        List<Integer> l = Arrays.stream(arr).boxed().toList();
        while (!l.isEmpty()) {
            l = Arrays.stream(arr).boxed().toList();
            Iterator<Integer> it = l.iterator();
            List<Pair> pairs = new ArrayList<>();
            while (it.hasNext()) {
                Pair pair = new Pair();
                pair.a = it.next();
                it.remove();
                while (it.hasNext()) {

                }
                pairs.add(pair);
            }
            ans.add(pairs);

        }

    }

    public List<List<Integer>> getPairs(List<Integer> list) {
        List<List<Integer>> ans = new ArrayList<>();
        Iterator<Integer> it = list.iterator();
        List<Pair> pairs = new ArrayList<>();
        while (it.hasNext()) {
            Pair pair = new Pair();
            pair.a = it.next();
            it.remove();
            while (it.hasNext()) {

            }
            pairs.add(pair);
        }
        //ans.add(pairs);
        return ans;

    }


    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> answers = new ArrayList<>();
        System.out.println("number list " + number);
        List<Integer> primes = getPrimesUntil(q);
        System.out.println("primes " + primes);
        List<Integer> A = new ArrayList<>();
        Stack<Integer> B = new Stack<>();
        int j = 0;
        for (int i = number.size() - 1; i >= 0; i--) {
            boolean isDivisibleByPrime = (number.get(i) % primes.get(j) == 0);
            if (isDivisibleByPrime) {
                B.push(number.get(i));
            } else {
                A.add(number.get(i));
            }
        }
        q--;
        j++;

        System.out.println("A: " + A);
        System.out.println("B: " + B);

        while (!B.isEmpty()) {
            answers.add(B.pop());
        }

        while (q > 0) {
            ListIterator it = A.listIterator(A.size());
            while (it.hasPrevious()) {
                Integer k = (Integer) it.previous();
                boolean isDivisibleByPrime = (k % primes.get(j) == 0);
                if (isDivisibleByPrime) {
                    B.push(k);
                    it.remove();
                }
            }
            System.out.println("A: " + A);
            System.out.println("B: " + B);
            while (!B.isEmpty()) {
                answers.add(B.pop());
            }

            q--;
            j++;
        }

        for (int i = A.size() - 1; i >= 0; i--) {
            answers.add(A.get(i));
        }

        return answers;

    }

    private static List<Integer> getPrimesUntil(int q) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        int i = 2;
        while (q > 1) {
            while (true) {
                i++;
                if (isPrime(i)) {
                    q--;
                    primes.add(i);
                    break;
                }
            }

        }
        return primes;
    }

    private static boolean isPrime(int i) {

        for (int j = 2; j < Math.sqrt(i); j++) {
            if (i % j == 2) {
                return false;
            }
        }
        return true;
    }

}

public class Waiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = WaiterResult.waiter(number, q);

        /* bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        ); */

        bufferedReader.close();
        System.out.println(result);
//        bufferedWriter.close();
    }
}
