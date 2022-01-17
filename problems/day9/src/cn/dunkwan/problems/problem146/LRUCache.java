package cn.dunkwan.problems.problem146;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {
    int cap;
    HashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 将该元素移到队头
        moveToHead(key);
        // 返回
        return map.get(key);
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (cap >= map.size()) {
                int oldKey = map.keySet().iterator().next();
                map.remove(oldKey);
            }
            map.put(key, value);
            return ;
        }
        map.put(key, value);
        moveToHead(key);
    }

    private void moveToHead(int key) {
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
    }
}
