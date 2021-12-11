package trees.assignment1;
import java.util.*;
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
class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
         int level = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        
        while(!q.isEmpty() ){
            
            
            Queue<TreeNode> copyQ = new LinkedList<TreeNode>();
            
            List<Integer> treeAtLevel = new ArrayList<>();
            
             while(!q.isEmpty() ){
                 TreeNode tmp = q.poll();
                 copyQ.add(tmp);
                 if(tmp != null)
                    treeAtLevel.add(tmp.val);
             }
            
            while ( !copyQ.isEmpty()){
                TreeNode p = copyQ.poll();
                
                if(p == null)
                    continue;
                
                if(p.left != null){
                    q.add(p.left);
                }
                
                if(p.right != null){
                    q.add(p.right);
                }

            }
            if(treeAtLevel.size() > 0)
                res.add(treeAtLevel);
        
        }
        
        return res;
    }
}