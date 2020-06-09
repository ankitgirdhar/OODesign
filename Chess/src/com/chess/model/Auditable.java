package com.chess.model;

import java.util.Objects;

public abstract class Auditable {
    private final long uid;

    private static long NEW_UID=0;
    protected Auditable() {
        this.uid = NEW_UID++;
    }

    public long getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return "Auditable{" +
                "uid=" + uid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auditable)) return false;
        Auditable auditable = (Auditable) o;
        return getUid() == auditable.getUid();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid());
    }
}
