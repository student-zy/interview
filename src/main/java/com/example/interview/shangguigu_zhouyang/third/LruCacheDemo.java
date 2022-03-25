package com.example.interview.shangguigu_zhouyang.third;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: interview
 * @Author: zy_zhao
 * @Date: 2022-03-24
 */
public class LruCacheDemo<K,V> extends LinkedHashMap<K,V>{

    private int capacity;
    public LruCacheDemo(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {

        
        LruCacheDemo<Object,Object> lruCacheDemo = new LruCacheDemo<Object,Object>(3);
        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(4, "x");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(5, "y");
        System.out.println(lruCacheDemo.keySet());

    }
}