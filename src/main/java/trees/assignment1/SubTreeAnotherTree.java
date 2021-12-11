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
class SubTreeAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode it = q.poll();
            
            if(identical(it,subRoot))
                return true;
            
            if(identical(it.left,subRoot))
                return true;
            
            if(it.left != null)
                q.add(it.left);
            
             if(identical(it.left,subRoot))
                return true;
            
            if(it.right != null)
                q.add(it.right);
        }
        
        return false;
        
    }
    
    public boolean identical(TreeNode root1, TreeNode root2){
        if(root1 == null){
            return root2 == null;
        } 
        if(root2 == null)
            return root1 == null;
        
        if(root1.val != root2.val)
            return false;
        
        return identical(root1.left,root2.left) && identical(root1.right,root2.right);
        
        
    }
}