package linkedlist;

public class LinkedList {
    private Node head, tail;
    private int len;

    public Node getHead() {
        return head;
    }

    public void add(int val) {
        Node n = new Node(val);
        if (head == null || tail == null) {
            head = n;
            tail = head;
        } else {
            tail.setNext(n);
            tail = n;
        }
        len++;
    }

    public int getLen() {
        return len;
    }

    public void printList(){
        Node k = head;
        while (k!=null){
            System.out.print(k.getVal() + " ");
            k = k.getNext();
        }
        System.out.println();
    }

}

class Node {
    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
    public Node getNext(){
        return next;
    }
}
