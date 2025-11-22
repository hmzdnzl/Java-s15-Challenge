package org.example.library;

import java.util.Objects;

public class Bookshelf{
    private Shelf shelf;

public Bookshelf(Shelf shelf) {
    this.shelf=shelf;
}

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "Bookshelf{" +
                "shelf=" + shelf +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bookshelf bookshelf = (Bookshelf) o;
        return Objects.equals(shelf, bookshelf.shelf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(shelf);
    }
}