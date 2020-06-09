package com.cache.multilevelCache;

import com.cache.customLruCache.CustomLRUCache;

import java.io.Serializable;

public class LRUCache<K , V> extends CustomLRUCache<K, V> implements Serializable {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity);
        this.capacity = capacity;
    }

}
