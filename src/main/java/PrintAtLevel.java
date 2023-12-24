import java.util.LinkedList;
import java.util.Queue;

public class PrintAtLevel {
    public static void main(String[] args) {
        TreeNode root = constructTree();
        printAtLevel(root, 3);

    }

    public static TreeNode constructTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        return root;
    }

    public static void printAtLevel(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        System.out.println("root: " + root.val);
        while (!q.isEmpty()) {
            System.out.println("q size: " + q.size() + " level: " + level);
            // print(q);
            int size = q.size();

            if (level == 1) {
                System.out.print("reached given level ");
                print(q);
                break;
            }

            while (size > 0) {
                TreeNode node = q.poll();
                System.out.println("node val: " + node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                size--;
            }

            level--;


        }

    }

    public static void print(Queue<TreeNode> q) {
        System.out.print("printing queue: ");
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}


