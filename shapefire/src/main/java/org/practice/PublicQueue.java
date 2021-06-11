package org.practice;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class PublicQueue<T> {

    private int offset;
    private int capacity = 10;

    private LinkedHashMap map = new LinkedHashMap<>();

    public synchronized void put(T msg) {
        if (map.size() == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            notifyAll();
        }

        map.put(offset, msg);
        System.out.println("produce-->" + msg + ",下标-->" + offset);

        offset = (offset + 1 >= capacity) ? (offset + 1) % capacity : (offset + 1);
    }

    public synchronized T get() {

        if (map.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            notifyAll();
        }

        Iterator iterator = map.entrySet().iterator();

        T value = null;
        if (iterator.hasNext()) {
            Map.Entry<Integer, T> item = (Map.Entry<Integer, T>) iterator.next();
            value = item.getValue();
            Integer key = item.getKey();

            System.out.println("consume-->" + value);
            map.remove(key);
        }

        return value;
    }

}
