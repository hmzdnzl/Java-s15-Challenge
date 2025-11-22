package org.example.library;

import java.util.Objects;

public class Shelf {
    private int shelfId;

    public Shelf(int shelfId) {
        this.shelfId=shelfId;
    }
    public int getShelfId() {
        return shelfId;
    }
    public void setShelfId() {
        this.shelfId=shelfId;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "shelfId=" + shelfId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Shelf shelf = (Shelf) o;
        return shelfId == shelf.shelfId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(shelfId);
    }
}
