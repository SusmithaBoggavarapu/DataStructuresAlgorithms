package algorithms.lru;

import java.util.HashMap;
import java.util.Map;

class Node {
    Node prev, next;
    int val,key;
    Node(int key, int val){
        this.val = val;
        this.key = key;
    }
    public String toString(){
        return String.valueOf(val);
    }
}
public class LRUCache {
    int capacity = 0;

    Map<Integer, Node> keyValue = new HashMap<>();

    Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        tail.prev = head;
        head.next = tail;
    }

    public void addFront(Node node){
       Node next = head.next;
        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
    }

    public void removeTail(){
       if(head.next == tail){
           return;
       }
       Node prev = tail.prev;
       keyValue.remove(prev.key);
       tail.prev = tail.prev.prev;
       tail.prev.next = tail;
    }

    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        System.out.println("get key :" + key+  "cache :" + keyValue);

        if(keyValue.containsKey(key)){
           Node node = keyValue.get(key);
            updateCache(node);
            return node.val;
        }
        return -1;
    }

    public void updateCache(Node node){
        removeNode(node);
        addFront(node);
    }

    public void put(int key, int val) {

        if(keyValue.containsKey(key)){
            Node node = keyValue.get(key);
            node.val = val;
            removeNode(node);
            addFront(node);
            return;
        }


        Node node = new Node(key,val);
        keyValue.put(key, node);

        addFront(node);

        if(keyValue.size() >= capacity){
            removeTail();
        }

    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */