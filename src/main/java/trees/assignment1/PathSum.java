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
import java.util.*;
class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Queue<Integer> pathSum = new LinkedList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null){
           return false;
        }
        
        q.add(root);
        pathSum.add(root.val);
        
        while(!q.isEmpty()){
            TreeNode it = q.poll();
            int sum = pathSum.poll();
            
            if(it.left == null && it.right == null){
                if(sum == targetSum)
                     return true;
            }
            
            if(it.left != null) {
                q.add(it.left);
                pathSum.add(sum + it.left.val);
            }
            
            if(it.right != null){
                q.add(it.right);
                pathSum.add(sum + it.right.val);
            }
        
        }
        return false;
        
    }
}