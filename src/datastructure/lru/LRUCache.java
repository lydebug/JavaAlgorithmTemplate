package datastructure.lru;

import java.util.HashMap;

/**
 * @Author: liyang27
 * @Date: 2020/7/24 16:37
 * @Description:
 */
public class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = 0;
        map = new HashMap<>();
        cache = new DoubleList(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            int val = map.get(key).val;
            put(key, val);
            return val;
        }
    }

    public void put(int key, int val) {
        Node x = new Node(key, val);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
                cap--;
            }
            cache.addFirst(x);
            map.put(key, x);
            cap++;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
