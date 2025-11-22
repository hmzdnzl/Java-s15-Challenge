package org.example.library;

import org.example.library.person.Author;
import org.example.library.person.LibraryStaff;
import org.example.library.person.Member;

import java.awt.print.Book;
import java.util.List;

public class Library {
    private static final String NAME = System.getenv("LIBRARY_NAME");
    private static final String ADDRESS = System.getenv("LIBRARY_ADDRESS");
    private static final String PHONE_NUMBER = System.getenv("LIBRARY_PHONE_NUMBER");
    private static final String EMAIL = System.getenv("LIBRARY_EMAIL");

    private List<Book> books;
    private List<Member> members;
    private List<Author> authors;
    private List<LibraryStaff> staffs;


    private static Library instance;

    private Library() {}

    public static Library getInstance() {
        if (instance == null)
            instance = new Library();
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int bookId) {
       if (!books.contains(bookId)) {
           throw new IllegalArgumentException(book.getTitle() + " isimli kitap kütüphanemizde bulunmamaktadır.");
       }
       books.remove(book);
    }

    public void findBookById(Book book) {

    }






    @Override
    public String toString() {
        return "Library{" +
                "name='" + NAME + '\'' +
                ", address='" + ADDRESS + '\'' +
                ", phoneNumber='" + PHONE_NUMBER + '\'' +
                ", email='" + EMAIL + '\'' +
                '}';
    }
}