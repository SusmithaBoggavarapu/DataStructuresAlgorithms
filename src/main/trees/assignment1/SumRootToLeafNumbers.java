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
class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Queue<Integer> deciNos = new LinkedList<>();
        deciNos.add(root.val);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int deciNoSoFar = deciNos.poll();
            
            if(node.left == null && node.right == null)
                res = res+ deciNoSoFar;
            
            if(node.left != null){
                q.add(node.left);
                deciNos.add(10*deciNoSoFar + node.left.val);
                
            }
            
             if(node.right != null){
                q.add(node.right);
                deciNos.add(10*deciNoSoFar + node.right.val);
                
            }
            
        }
        
        return res;
        
        
        
    }
}