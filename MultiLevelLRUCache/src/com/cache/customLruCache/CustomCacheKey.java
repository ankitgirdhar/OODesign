package com.cache.customLruCache;

import java.util.Objects;

public class CustomCacheKey extends CacheKey {

    String key;

    public CustomCacheKey(int id, String key) {
        super(id);
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomCacheKey)) return false;
        CustomCacheKey that = (CustomCacheKey) o;
        int id1 = this.getId();
        int id2 = that.getId();
        if(id1 == id2)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "key=" + key  + " id=" + getId();
    }
}
