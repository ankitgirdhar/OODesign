package com.cache.customLruCache;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CustomLRUCache<K,V> {
    public class Entry {
        V value;
        K key;
        Entry left;
        Entry right;
        public Entry(K key, V val) {
            left = null;
            right = null;
            this.value = val;
            this.key = key;
        }

        @Override
        public String toString() {
            return "value=" + value.toString() +
                    ", key=" + key.toString();
        }
    }

    public HashMap<K, Entry> map;
    public Entry start,end;
    int LRU_SIZE;

    public CustomLRUCache(int capacity) {
        map = new HashMap<>();
        LRU_SIZE = capacity;
        start = null;
        end = null;
    }

    public V get(K key) {
        if(map.containsKey(key)) {
            Entry entry = map.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        return null;
    }

    public void put(K key, V val) {
        if(map.containsKey(key))
        {
            Entry node = map.get(key);
            node.value = val;
            removeNode(node);
            addAtTop(node);
        } else {
            Entry newNode = new Entry(key,val);
            if( map.size() >= LRU_SIZE) {
                map.remove(end.key);
                removeNode(end);
            }
            addAtTop(newNode);
            map.put(key,newNode);
        }
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public void remove(K key) {
        if(map.containsKey(key)) {
            Entry node = map.get(key);
            removeNode(node);
            map.remove(key);
        }
    }

    private void addAtTop(Entry node) {
        node.right = start;
        node.left = null;
        if(start != null)
            start.left = node;
        start = node;
        if(end == null)
            end = start;
    }

    private void removeNode(Entry node) {
        if(node.left!= null)
            node.left.right = node.right;
        else
            start = node.right;

        if(node.right!=null)
            node.right.left = node.left;
        else
            end = node.left;
    }
}
