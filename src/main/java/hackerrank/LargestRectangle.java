package hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Node{
    int position;
    int height;
    @Override
    public String toString(){
        return  "Position: " + position + " Height: " + height;
    }
}
class Result {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */


    public static long largestRectangle(List<Integer> h) {
        // Write your code here
        long maxArea = 0;
        Stack<Node> s = new Stack<>();
        h.add(0);

        for(int i=0 ; i< h.size() ; i++){
            System.out.println("Stack " + s);
            int lastWidth = Integer.MAX_VALUE;
            while( !s.isEmpty() && s.peek().height > h.get(i)){
                System.out.println("Stack " + s);
                Node n = s.pop();
                int width = i - n.position;
                int height = n.height;
                lastWidth  = n.position;
                System.out.println("Last Width " + lastWidth);
                maxArea = max(maxArea,width*height);
            }

            System.out.println("Stack " + s);
            if(s.isEmpty() || s.peek().height < h.get(i)){
                Node n = new Node();
                n.position = lastWidth < i ? lastWidth : i ;
                n.height = h.get(i);
                s.push(n);
            }


        }

        while (!s.isEmpty()){
            System.out.println("Stack " + s);
            Node n = s.pop();
            int width = h.size()-n.position;
            int height = n.height;
            maxArea = max(maxArea,width*height);
        }
        return maxArea;
    }

    public static long max(long a, long b){
        return a > b ? a :b ;
    }

}

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.largestRectangle(h);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
        System.out.println(result);
    }
}
