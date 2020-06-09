package com.cache.multilevelCache;

import com.cache.customLruCache.CacheKey;

public interface IMultiLevelCache< K extends CacheKey, V> {

    void add(K key, V value);
    void remove(K key);
    V get(K key);
    void update(K key, V value);
    void show();

}
