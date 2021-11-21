package leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class PopulateNextPtr {
    public Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Queue<Node> copyQ = new LinkedList<>();
            Node it = null, prev = null;
            while (!q.isEmpty()) {
                prev = it;
                it = q.poll();
                if (prev != null)
                    prev.next = it;
                copyQ.add(it);
            }

            it.next = null;

            while (!copyQ.isEmpty()) {
                Node newIt = copyQ.poll();
                if (newIt.left != null)
                    q.add(newIt.left);
                if (newIt.right != null)
                    q.add(newIt.right);

            }
        }

        return root;
    }
}