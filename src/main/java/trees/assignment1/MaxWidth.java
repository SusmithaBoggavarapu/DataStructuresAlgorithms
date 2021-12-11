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
class MaxWidth {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> levelOrderQ = new LinkedList<>();
        Queue<Integer> positionFromCenterQ = new LinkedList<>();
        
        levelOrderQ.add(root);
        positionFromCenterQ.add(0);
        int maxWidth = 0;
        while(!levelOrderQ.isEmpty()){
            int levelSize = levelOrderQ.size();
            
            int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
            while(levelSize-- > 0){
                TreeNode parent = levelOrderQ.poll();
                int parentPos = positionFromCenterQ.poll();
                min = parentPos < min ? parentPos : min;
                max = parentPos > max ? parentPos : max;
                System.out.println("node val: " + parent.val + " position from center: "+ parentPos);
                System.out.println("min: "+ min+" max: "+ max);
                
                if(parent.left != null){
                    levelOrderQ.add(parent.left);
                    positionFromCenterQ.add(2*parentPos+1);
                }
                    
                if(parent.right != null){
                    levelOrderQ.add(parent.right);
                    positionFromCenterQ.add(2*parentPos+2);
                }
                
            }
            int width = max -min+1;
            maxWidth = maxWidth < width ? width : maxWidth;
            
        }
        
        return maxWidth;
        
    }
}