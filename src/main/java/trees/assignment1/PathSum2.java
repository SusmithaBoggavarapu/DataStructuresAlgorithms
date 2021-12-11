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
class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         Queue<Integer> pathSum = new LinkedList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null){
           return new ArrayList<>();
        }
        
        q.add(root);
        pathSum.add(root.val);
        Queue<List<Integer>> paths = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        paths.add(path);
        List<List<Integer>> result = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode it = q.poll();
            int sum = pathSum.poll();
            List<Integer> pathSoFar = paths.poll();
            
            if(it.left == null && it.right == null){
                if(sum == targetSum){
                    result.add(pathSoFar);
                }
                    
            }
            
            if(it.left != null) {
                q.add(it.left);
                List<Integer> pathLeft = new ArrayList<>();
                for(Integer n: pathSoFar){
                    pathLeft.add(n);
                }
                pathLeft.add(it.left.val);
                pathSum.add(sum + it.left.val);
                paths.add(pathLeft);
            }
            
            if(it.right != null){
                q.add(it.right);
                List<Integer> pathRight = new ArrayList<>();
                for(Integer n: pathSoFar){
                    pathRight.add(n);
                }
                pathRight.add(it.right.val);
                pathSum.add(sum + it.right.val);
                paths.add(pathRight);
            }
        
        }
        return result;
        
    }
}