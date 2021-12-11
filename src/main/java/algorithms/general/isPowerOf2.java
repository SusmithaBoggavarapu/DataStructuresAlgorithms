package algorithms.general;/*
Given a positive integer, write a function to find if it is a power of two or not.
*/

public class isPowerOf2 {
    /*this is a comment//More comments */
    // /* this is a// // comment */
    /* here is a comment ***** */
    /* this is also  /* more comments */
    public static void main(String[] args) {
        System.out.println(Double.parseDouble("595339099.147695795" ));
        int i = 0x000F;
        int j = 0x2222;
        System.out.println(i&j);
        System.out.println(j);
        //Test 1
        if(isPowerOfTwo(31) == false)
            System.out.println("Test 1 Passed");
        else
            System.out.println("Test 1 Failed");
        if(isPowerOfTwo(1) == true)
            System.out.println("Test 2 Passed");
        else
            System.out.println("Test 2 Failed");
        if(isPowerOfTwo(0) == false)
            System.out.println("Test 3 Passed");
        else
            System.out.println("Test 3 Failed");
        if(isPowerOfTwo(1024) == true)
            System.out.println("Test 4 Passed");
        else
            System.out.println("Test 4 Failed");
    }

    public static boolean isPowerOfTwo(int n){
        return (n & n-1) == 0;
    }
}
