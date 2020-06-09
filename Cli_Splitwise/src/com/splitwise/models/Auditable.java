package com.splitwise.models;

import java.time.LocalDateTime;

public abstract class Auditable {
    private long uid;
    private LocalDateTime updatedAt;

    private static int NEW_UID = 0;
    public Auditable() {
        setUid(NEW_UID++);
        setUpdatedAt(LocalDateTime.now());
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
