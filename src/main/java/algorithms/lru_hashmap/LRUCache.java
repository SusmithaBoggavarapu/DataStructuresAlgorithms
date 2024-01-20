package algorithms.lru_hashmap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class Node {

    int val, key;

    Node(int key, int val) {
        this.val = val;
        this.key = key;
    }

    public String toString() {
        return String.valueOf(val);
    }
}

public class LRUCache {
    int capacity = 0;
    LinkedHashMap<Integer, Node> cache = new LinkedHashMap<>();

    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        System.out.println("get key :" + key + "cache :" + cache);

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            updateCache(node);
            return node.val;
        }
        return -1;
    }

    public void updateCache(Node node) {
        cache.remove(0);
        cache.put(node.key, node);
    }

    public void put(int key, int val) {

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = val;
            cache.remove(node.key);
            cache.put(node.key, node);
            return;
        }


        Node node = new Node(key, val);
        cache.put(key, node);

        if (cache.size() > capacity) {
            Map.Entry entry = cache.entrySet().iterator().next();
            cache.remove(entry.getKey());

        }

    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */