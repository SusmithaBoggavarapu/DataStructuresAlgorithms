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
public class TraversalWithoutRecursion {

    public List<Integer> PostOrderTraversal(TreeNode root) {
        List<Integer> res  = new ArrayList<>();
        Stack<TreeNode> s = new Stack();
        TreeNode it = root;
        while (it != null || !s.isEmpty()) {
            while(it != null){
                if(it.right != null){
                    s.push(it.right);
                    s.push(it);
                    it = it.left;
                }
            }
            if(!s.isEmpty()){
                TreeNode n = s.pop();
                if(n.right == null){
                    res.add(n.val);
                }else{
                    if(s.peek() == n.right){
                        it = s.pop();
                        s.push(n);
                    }
                }

            }
        }

        return res;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        TreeNode it = root;
        List<Integer> res  = new ArrayList<>();
        while(it != null || !s.isEmpty()){
            while(it!=null){
                res.add(it.val);
                s.push(it);
                it = it.left;
            }
            
            if(!s.isEmpty()){
                TreeNode n = s.pop();
                it = n.right;
            }
        }
        return res;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        TreeNode it = root;
        List<Integer> res  = new ArrayList<>();
        while(it != null || !s.isEmpty()){
            while(it!=null){
                s.push(it);
                it = it.left;
            }

            if(!s.isEmpty()){
                TreeNode n = s.pop();
                res.add(n.val);
                it = n.right;
            }
        }
        return res;

    }
}