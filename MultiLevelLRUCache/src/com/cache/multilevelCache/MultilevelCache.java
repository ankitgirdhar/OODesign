package com.cache.multilevelCache;

import com.cache.customLruCache.CacheKey;
import com.cache.multilevelCache.IMultiLevelCache;
import com.cache.multilevelCache.LRUCache;

import java.util.*;

public class MultilevelCache< K extends CacheKey, V>  implements IMultiLevelCache<K,V> {

    private int levels;
    private int capacity;
    private Map< Integer, LRUCache< K, V>> multiLevelCache;
    private final int levelStart;
    private final int levelEnd;

    public MultilevelCache(int capacity, int levels) {
        this.multiLevelCache = new HashMap<>(levels);
        this.capacity = capacity;
        this.levels = levels;
        this.levelStart = capacity;
        this.levelEnd = levelStart * levels;
        init();
    }

    public MultilevelCache(int capacity) {
        this.multiLevelCache = new HashMap<>(levels);
        this.levels = 1;
        this.capacity = capacity;
        this.levelStart = capacity;
        this.levelEnd = levelStart * levels;
        init();
    }

    private final void init() {

        for(int i = levelStart; i<= levelEnd; i += levelStart)
        {
            multiLevelCache.put(i, new LRUCache<>(capacity));
        }
    }

    private final Set<Integer> getDesiredLevels(int id) {
        Set<Integer> levelSet = new HashSet();
        int level = id % levelEnd;

        for(int i = levelStart ; i <= levelEnd ;i += levelStart) {
            levelSet.add(i);
            if(level <= i)
                break;
        }
        return levelSet;
    }

    @Override
    public void add(K key, V value) {
        int id = key.getId();
        Set<Integer> levelSet = getDesiredLevels(id);

        for( Integer level : levelSet)
        {
            multiLevelCache.get(level).put(key, value);
        }
    }

    @Override
    public void remove(K key) {
        int id = key.getId();
        Set<Integer> levelSet = getDesiredLevels(id);

        for( Integer level : levelSet)
        {
            if(multiLevelCache.get(level).containsKey(key))
                multiLevelCache.get(level).remove(key);

        }
    }

    @Override
    public V get(K key) {
        for(Integer level : multiLevelCache.keySet()) {
            if(multiLevelCache.get(level).containsKey(key))
                return multiLevelCache.get(level).get(key);
        }
        return null;
    }

    @Override
    public void update(K key, V value) {
        for(Integer level : multiLevelCache.keySet()) {
            if(multiLevelCache.get(level).containsKey(key))
                multiLevelCache.get(level).put(key,value);
        }
    }

    @Override
    public void show() {
        for(Integer level : multiLevelCache.keySet()) {
            System.out.println("Level: " + level + "value: ");
            for(  K key : multiLevelCache.get(level).map.keySet()) {
                String keyString = key.toString();
                String valuesString =  multiLevelCache.get(level).map.get(key).toString();
                System.out.println( keyString  + " : " + valuesString);
            }
        }
    }
}
