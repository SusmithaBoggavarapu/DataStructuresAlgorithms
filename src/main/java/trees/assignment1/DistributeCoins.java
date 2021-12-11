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
class DistributeCoins {
    int  noOfMoves = 0;
    public int distributeCoins(TreeNode root) {
       noOfMoves = 0;
        getExtraCoins(root);
        return noOfMoves;
    }
    
    public int getExtraCoins(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val-1;
        
       
        int left = getExtraCoins(root.left);
        int right = getExtraCoins(root.right);
        noOfMoves += Math.abs(left) + Math.abs(right) ;
        return root.val-1+left+right;
        
    }
}