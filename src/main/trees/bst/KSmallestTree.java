package CrackingCodingInterview.TreesAndGraphs.bst;

import java.util.Stack;

public class KSmallestTree {
    public static void main(String[] args) {
        String[] preOrder = {"A", "B", "D", "G", "C", "E", "H", "I", "F"};
        String[] inOrder = {"D", "G", "B", "A", "H", "E", "I", "C", "F"};
        Vertex tree = constructTree(preOrder, inOrder);
        System.out.print("PreOrder: ");
        printPreorderRecursive(tree);
        System.out.print("\n InOrder: ");
        printInorderRecursive(tree);

    }


    public static void printPreorderRecursive(Vertex tree){
        if(tree == null){
            return;
        }
        System.out.print(tree.getData() + " ");
        printPreorderRecursive(tree.getLeft());
        printPreorderRecursive(tree.getRight());
    }

    public static void printInorderRecursive(Vertex tree){
        if(tree == null){
            return;
        }
        printInorderRecursive(tree.getLeft());
        System.out.print(tree.getData() + " ");
        printInorderRecursive(tree.getRight());
    }

    public static void printInorder(Vertex root) {
        Stack<Vertex> s = new Stack<>();
        Vertex it = root;
        s.push(it);

        while (!s.isEmpty() || it != null) {
            while (it != null) {
                s.push(it);
                it = it.getLeft();
            }

            if (!s.isEmpty()) {
                Vertex removedVertex = s.pop();
                System.out.print(removedVertex.getData()+" ");
                it = removedVertex.getRight();
            }
        }
    }


    public static Vertex constructTree(String[] preOrder, String[] inOrder) {
        if (preOrder == null || preOrder.length == 0)
            return null;
        Vertex root = new Vertex(preOrder[0]);
        Vertex it = root;
        for (int i = 1; i < preOrder.length; i++) {
            Vertex tmp = new Vertex(preOrder[i]);

            for (int j = 0; j < inOrder.length; j++) {
                if(inOrder[j] == preOrder[i]){
                    int index= j;
                }
            }
           // int[] left = new int[];

            it = tmp;
        }
        return root;

    }

    public static boolean isLeftChild(String parent, String child, String[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == parent) {
                return false;
            }

            if (inOrder[i] == child) {
                return true;
            }
        }

        return true;
    }
}
