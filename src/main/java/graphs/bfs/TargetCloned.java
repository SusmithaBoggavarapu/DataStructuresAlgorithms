package graphs.bfs;

import trees.bst.traversals.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TargetCloned {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        Queue<TreeNode> oq = new LinkedList<TreeNode>();
        oq.add(original);
        
        Queue<TreeNode> cq = new LinkedList<TreeNode>();
        cq.add(cloned);

        while(!oq.isEmpty()){
            TreeNode node = oq.remove();
            TreeNode cnode = cq.remove();
            if(node.equals(target)){
                return cnode;
            }

            if(!Objects.isNull(node.left)){
                oq.add(node.left);
                cq.add(cnode.left);
            }

            if(!Objects.isNull(node.right)){
                oq.add(node.right);
                cq.add(cnode.right);
            }


        }

        return null;

    }
}