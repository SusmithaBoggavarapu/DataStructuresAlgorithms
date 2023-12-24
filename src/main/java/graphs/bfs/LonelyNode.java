package graphs.bfs;

import trees.bst.traversals.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-all-the-lonely-nodes/
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
class LonelyNode {
    public List<Integer> getLonelyNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> lonelyNodes = new ArrayList();

        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.left !=null) {
                queue.add(node.left);
                if(node.right ==null) {
                    lonelyNodes.add(node.left.val);
                }
            }

            if(node.right !=null) {
                queue.add(node.right);
                if(node.left ==null) {
                    lonelyNodes.add(node.right.val);
                }
            }

        }
        return lonelyNodes;

    }
}