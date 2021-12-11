 package arrays.assignment1;
//https://leetcode.com/problems/xor-operation-in-an-array/
class XorOperation {
    public int xorOperation(int n, int start) {
        int res = start;
        for(int i=1; i < n;i++){
            res = res ^ (start+2*i);
        }
        return res;
    }
}