package arrays;

//https://leetcode.com/problems/divide-two-integers/submissions/

class DivideWithoutDivisionOperator {
    public int divide(int ipDividend, int ipDivisor) {


        int dividend = ipDividend < 0 ? 0 - ipDividend : ipDividend;
        int divisor = ipDivisor < 0 ? 0 - ipDivisor : ipDivisor;

        //handling corner case scenarios
        if (ipDividend == Integer.MIN_VALUE && ipDivisor == -1)
            return Integer.MAX_VALUE;

        if(ipDividend == Integer.MIN_VALUE && ipDivisor == Integer.MIN_VALUE)
            return 1;

        if(ipDividend == ipDivisor)
            return 1;

        if(ipDividend != Integer.MIN_VALUE){
            if(dividend < divisor)
                return 0;
        }

        if(ipDivisor == Integer.MIN_VALUE)
            return 0;

        if(divisor == 1)
            return ipDividend * ipDivisor;

        if(Math.abs(ipDividend) == Math.abs(ipDivisor))
            return (ipDividend < 0 ^ ipDivisor < 0) ? -1 :1;
        int cnt = 0;

        if(ipDividend < 0) {
            if(ipDivisor < 0){
                if(ipDividend == Integer.MIN_VALUE){
                    dividend = (ipDividend - divisor);
                    cnt = 1;
                }

                while (dividend >= divisor) {
                    dividend -= divisor;
                    cnt++;
                }
            }else{
                if(ipDividend == Integer.MIN_VALUE){
                    dividend = -1*(ipDividend + divisor);
                    cnt = 1;
                }

                while(dividend >= divisor ){
                    dividend -= divisor;
                    cnt++;
                }
            }
        } else {
            if(divisor < 0){
                if(divisor == Integer.MIN_VALUE){
                    return 0;
                }
                while(dividend > 0-divisor ){
                    dividend += divisor;
                    cnt++;
                }

            }else{
                while(dividend > divisor){
                    dividend -= divisor;
                    cnt++;
                }
            }
        }

        return (ipDividend<0) ^ (ipDivisor<0) ? 0-cnt : cnt;

    }
}

class DivideWithoutDivisionOperatorApp{

    public static void main(String[] args){
        DivideWithoutDivisionOperator d = new DivideWithoutDivisionOperator();
        System.out.println(d.divide(-2147483648,-3));
       // System.out.println(-1l*Integer.MIN_VALUE);-2147483648
        //2
    }


}