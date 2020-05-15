package com.cache.customLruCache;

public class CustomCacheValue<T> {
    T value;

    public CustomCacheValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
