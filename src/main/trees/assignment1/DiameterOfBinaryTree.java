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
class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        
         
         int leftDiameter = root.left != null ? diameterOfBinaryTree(root.left) : 0;
         int rightDiameter = root.right != null ? diameterOfBinaryTree(root.right) : 0;
         int rootDiameter = height(root.left) + height(root.right) ;
        
        return Math.max(rootDiameter, Math.max(leftDiameter,rightDiameter));
        
        
    }
    
    public int height(TreeNode root){
        
        if(root == null)
            return 0;
        
        int leftHeight = root.left != null ? height(root.left) : 0;
        int rightHeight = root.right != null ? height(root.right) : 0;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}