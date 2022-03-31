package algorithms;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

/**
 * Analysis1, sort an array and find the longest one, but we dont actually need to sort
 * complexity - n logn
 * We dont need to sort, we just need to group
 * 100-> 99/ 101 - form edge
 * 4 -> 3,5 ->
 * 200 -> 199,201
 * 1 -> 2
 * 3 -> 2 , 4
 * 2 -> 1
 *
 * HashSet<>.contains
 * edgelist()
 * 3,4
 * 1,2
 * 2,3
 */

public class LongestConsecutiveSequence {
    public static void main(String[] args){
         int[] sortedArray = {1,2,3,4,5,6,7,3,4,5,6,9,10,11,12,13,14,15,16,17,1,2,3,4,5,6,7,8,9,10,11};

         int longestConsecutiveNum = 1,i=1,currLength =1;

         while (i<sortedArray.length){
             if(sortedArray[i] == sortedArray[i-1]+1){
                 currLength++;
                 longestConsecutiveNum = Math.max(currLength,longestConsecutiveNum);
             } else{
                 currLength =1;
             }
             i++;
         }

         System.out.println(longestConsecutiveNum);
    }

}
