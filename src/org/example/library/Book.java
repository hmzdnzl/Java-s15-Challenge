package org.example.library;

import org.example.library.person.Author;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String title;
    private Type type;
    private Author author;
    private int bookId;
    private Shelf shelf;
    private LocalDate addedTime;
    private boolean isEnableBorrow;
    // Removed purchase-related field

    public Book() {
    }

    public Book(String title, Type type, Author author, int bookId, Shelf shelf, LocalDate addedTime, boolean isEnableBorrow, boolean isEnablePurchase) {
        this.title = title;
        this.type = type;
        this.author = author;
        this.bookId = bookId;
        this.shelf = shelf;
        this.addedTime = addedTime;
        this.isEnableBorrow = isEnableBorrow;
        // Removed purchase-related parameter
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public Author getAuthor() {
        return author;
    }

    public int getBookId() {
        return bookId;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public LocalDate getAddedTime() {
        return addedTime;
    }

    public boolean isEnableBorrow() {
        return isEnableBorrow;
    }

    // Removed purchase-related getter

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBookId(int bookId) {
        if (bookId<=0) {
            throw new IllegalArgumentException("id sıfır veya sıfırdan küçük olamaz!");
        } else {
            this.bookId = bookId;
        }
        }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public void setAddedTime(LocalDate addedTime) {
        this.addedTime = addedTime;
    }

    public void setEnableBorrow(boolean enableBorrow) {
        isEnableBorrow = enableBorrow;
    }

    // Removed purchase-related setter

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", author=" + author +
                ", bookId=" + bookId +
                ", shelf=" + shelf +
                ", addedTime=" + addedTime +
                ", isEnableBorrow=" + isEnableBorrow +
                "" +
                '}';
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
            Objects.equals(title, book.title) &&
            Objects.equals(author, book.author) &&
            type == book.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, author, type);
    }
}
