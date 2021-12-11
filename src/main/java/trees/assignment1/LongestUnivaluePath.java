package trees.assignment1;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LongestUnivaluePath {
    class Result{
        int maxSoFar,lenWithRoot,height;
        Result( int maxSoFar,int lenWithRoot,int height){
            this.maxSoFar = maxSoFar;
            this.lenWithRoot = lenWithRoot;
            this.height = height;
        }
    }
    static int max = Integer.MIN_VALUE ;
    
    public int longestUnivaluePath(TreeNode root) {
         if(root == null) {
            return 0;
        }
        Result res = longestUnivaluePathRec(root);
        return Math.max(res.maxSoFar, res.lenWithRoot)-1;
    }
    
     public Result longestUnivaluePathRec(TreeNode root) {
       
         if(root.left == null && root.right == null){
             return new Result(1,1,1) ;
         }
         int lenWithRoot = 1;
         int maxSoFar = 1;
         int rightHeight = 0;
         int leftHeight = 0;
         
         if(root.right != null){
             Result rightRes = longestUnivaluePathRec(root.right);
             
             if(root.val == root.right.val){
                 rightHeight = rightRes.height ;
             }
               
              maxSoFar = Math.max(rightRes.maxSoFar ,maxSoFar);
         }
         
         if(root.left != null){
             Result leftRes = longestUnivaluePathRec(root.left);
             
             if(root.val == root.left.val){
                 leftHeight = leftRes.height ;
             }
             
             maxSoFar = Math.max(leftRes.maxSoFar ,maxSoFar);
         
               
         }
         int height = Math.max(leftHeight,rightHeight) + 1;
         lenWithRoot = leftHeight +rightHeight +1;
          maxSoFar = Math.max(lenWithRoot ,maxSoFar);
         return new Result(maxSoFar,lenWithRoot,height);
    }
}