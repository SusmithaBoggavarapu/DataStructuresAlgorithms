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
class InOrderTraversal {
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