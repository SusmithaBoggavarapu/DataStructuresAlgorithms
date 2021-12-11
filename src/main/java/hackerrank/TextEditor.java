package hackerrank;

import java.io.*;
import java.util.*;

class Function {
    int operator;
    String operand;
    int index;

    public Function(int operator, String operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public Function(int operator, String operand, int index) {
        this.operator = operator;
        this.operand = operand;
        this.index = index;
    }
}

public class TextEditor {
    private static Stack<Function> s = new Stack<>();
    private static StringBuffer str = new StringBuffer();

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named HackerRank.Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        while (n > 0) {
            String ip = br.readLine().trim();
            int operator = getOperator(ip);
            String operand = "";
            if (operator != 4) {
                operand = getOperand(ip);
            }
            processTextEditor(operator, operand);

            n--;
        }
    }

    private static void processTextEditor(int operator, String operand) {
        System.out.println("before processing " + str);

        switch (operator) {
            case 1:
                s.push(new Function(operator, operand, str.length()));
                str.append(operand);
                break;
            case 2:
                int lastValues = Integer.parseInt(operand);
                String delValue = str.substring(str.length()-lastValues,str.length());
                Function f = new Function(operator, delValue,str.length()-lastValues );
                s.push(f);
                str.delete(str.length()-lastValues,str.length());
                break;
            case 3:
                System.out.println(str.charAt(Integer.parseInt(operand)-1));
                break;
            case 4:
                undoLastOperation();
                break;
        }
        System.out.println("after processing " + str);
    }

    private static void undoLastOperation() {
        Function f = s.pop();
        int operator = f.operator;

        switch (operator) {
            case 1:
                str.delete(f.index, f.index + f.operand.length());
                break;
            case 2:
                str.insert(f.index, f.operand);
                break;
        }
    }

    public static int getOperator(String ip) {
        String op = ip.split(" ")[0];
        return Integer.parseInt(op);
    }


    public static String getOperand(String ip) {
        return ip.split(" ")[1];
    }


}