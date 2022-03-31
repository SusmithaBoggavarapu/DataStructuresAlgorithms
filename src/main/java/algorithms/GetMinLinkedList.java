package algorithms;

import lombok.Data;

public class GetMinLinkedList {
    Node node;
    int min;

    public void insert(int n) {

        if (node == null) {
            node = new Node(n);
        }
        min = Math.min(min, n);
    }

    public int getMin() {
        if (node == null)
            return -1;
        return node.val;
    }
}

@Data
class Node {
    int val;

    Node(int val) {
        this.val = val;
    }

    Node next;
}
