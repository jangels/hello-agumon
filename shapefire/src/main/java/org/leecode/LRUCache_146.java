package org.leecode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU cache
 */
public class LRUCache_146 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache_146(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache_146 cache = new LRUCache_146(3);
        cache.put(1,223);
        cache.put(2,22);
        cache.put(1111,1212);
        cache.put(112,112);

        System.out.println(cache);
        System.out.println(cache.get(1));
    }
}
