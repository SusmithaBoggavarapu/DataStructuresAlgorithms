package CrackingCodingInterview.TreesAndGraphs.bst.traversals;

public class SumTree {
    public static TreeNode constructSumTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode sumRoot = new TreeNode();
        TreeNode leftSumNode = null;
        if (sumRoot.left != null) {
            leftSumNode = constructSumTree(root.left);
        }

        TreeNode rightSumNode = null;
        if (sumRoot.right != null) {
            rightSumNode = constructSumTree(root.right);
        }

        int leftSum = leftSumNode != null ? leftSumNode.val : 0;
        int rightSum = rightSumNode != null ? rightSumNode.val : 0;
        sumRoot.val = sumRoot.val + leftSum + rightSum;
        return sumRoot;
    }
}

