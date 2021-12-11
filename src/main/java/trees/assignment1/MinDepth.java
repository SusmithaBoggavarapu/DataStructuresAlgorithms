package trees.assignment1;

/**
 * Definition for a binary tree node.
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(left == 0){
            return right+1;
        }
        
        if(right == 0){
            return left+1;
        }
        return Math.min(left, right) + 1 ;
    }
}