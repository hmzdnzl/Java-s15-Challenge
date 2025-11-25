package org.example.library;

import org.example.library.person.Author;
import org.example.library.person.LibraryStuff;
import org.example.library.person.Member;

import org.example.library.Book;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {
    
     
    private static final String NAME = "Merkez Kütüphane";
    private static final String ADDRESS = "İstanbul";
    private static final String PHONE_NUMBER = "02124567899";
    private static final String EMAIL = "info@kutuphane.com";
    private int allowedDays = 30; 
    private double penaltyPerDay = 5.0;

  private Map<Integer, Book> books = new HashMap<>();
private Map<Long, Member> members = new HashMap<>();
    private List<Author> authors = new ArrayList<>();
    private Map<Long, LibraryStuff> stuffs = new HashMap<>();
    private List<BorrowRecord> borrowRecords = new ArrayList<>();
  private Map<Bookshelf, List<Book>> bookshelves = new TreeMap<>();


    private static Library instance;

    private Library() {}

    public static Library getInstance() {
        if (instance == null)
            instance = new Library();
        return instance;
    }

   public void addBook(Book book) {
    if (books.containsKey(book.getBookId())) {
        throw new IllegalArgumentException("Bu ID'ye sahip bir kitap zaten var!");
    }
    books.put(book.getBookId(), book);  
    Bookshelf bookshelf = new Bookshelf(book.getShelf());
    bookshelves.putIfAbsent(bookshelf, new ArrayList<>());
    bookshelves.get(bookshelf).add(book);
    bookshelves.get(bookshelf).sort(java.util.Comparator.comparing(Book::getTitle));
}

public void donateBook(Book book, Member donor) {
    if (books.containsKey(book.getBookId())) {
        throw new IllegalArgumentException("Bu ID'ye sahip bir kitap zaten var!");
    }
    if (!members.containsKey(donor.getMemberId())) {
        throw new IllegalArgumentException("Sadece üyeler kitap bağışı yapabilir.");
    }
    Member member = members.get(donor.getMemberId());
    books.put(book.getBookId(), book);
    member.getDonatedBooks().add(book);
    
    Bookshelf bookshelf = new Bookshelf(book.getShelf());
    bookshelves.putIfAbsent(bookshelf, new ArrayList<>());
    bookshelves.get(bookshelf).add(book);
    bookshelves.get(bookshelf).sort(java.util.Comparator.comparing(Book::getTitle));
}

    public void removeBook(int bookId) {
       Book removed = books.remove(bookId);
if (removed == null) {
    throw new IllegalArgumentException(bookId + " id'li kitap kütüphanemizde bulunmamaktadır.");
}
    }


   public Book findBookById(int bookId) {
    if (!books.containsKey(bookId)) {
        throw new IllegalArgumentException(bookId + " id'li kitap kütüphanemizde bulunmamaktadır.");
    }
    return books.get(bookId);
}

public Book findBookByTitle(String title) {
    for (Book book : books.values()) {
        if (book.getTitle().equalsIgnoreCase(title)) {
            return book;
        }
    }
    throw new IllegalArgumentException(title + " adlı kitap kütüphanemizde bulunmamaktadır.");
}

public List<Book> findBooksByAuthor(Author author) {
  List<Book> foundBooks = new ArrayList<>();
    for (Book book : books.values()) {
        if (book.getAuthor().equals(author)) {
            foundBooks.add(book);
        }
    }
    if (foundBooks.isEmpty()) {
        throw new IllegalArgumentException(author.getName() + " adlı yazarın kitapları kütüphanemizde bulunmamaktadır.");
    }
    return foundBooks;
}

public List<Book> findBooksByType(Type type) {
    List<Book> foundBooks = new ArrayList<>();
    for (Book book : books.values()) {
        if (book.getType() == type) {
            foundBooks.add(book);
        }
    }
    if (foundBooks.isEmpty()) {
        throw new IllegalArgumentException(type + " türündeki kitaplar kütüphanemizde bulunmamaktadır.");
    }
    return foundBooks;
}

public List<Book> findBooksByShelf(Shelf shelf) {
    Bookshelf bookshelf = new Bookshelf(shelf);
    List<Book> foundBooks = bookshelves.get(bookshelf);
        if (foundBooks == null || foundBooks.isEmpty()) {
            throw new IllegalArgumentException("Raf numarası " + shelf.getShelfId() + " olan kitaplar kütüphanemizde bulunmamaktadır.");
        }
        // Kitapları durumuna göre yazdır
        for (Book book : foundBooks) {
            if (!book.isEnableBorrow()) {
                System.out.println(book.getTitle() + " (Ödünç Verilmiştir)");
            } else {
                System.out.println(book.getTitle());
            }
        }
        return foundBooks;
}

public void addMember(Member member) {
   if (members.containsKey(member.getMemberId())) {
    throw new IllegalArgumentException("Bu ID'ye sahip bir üye zaten var!");
}
members.put(member.getMemberId(), member);
}

public void removeMember(Member member) {
    if (!members.remove(member.getMemberId(), member)) {
        throw new IllegalArgumentException(member.getName() + " adlı üye kütüphanemizde bulunmamaktadır.");
    }
    members.remove(member.getMemberId());
}

public void removeMember(long memberId) { 
    if (!members.containsKey(memberId)) {
        throw new IllegalArgumentException(memberId + " id'li üye kütüphanemizde bulunmamaktadır.");
    }
    members.remove(memberId);
}

public Member findMemberById(long memberId) {
    if (!members.containsKey(memberId)) {
        throw new IllegalArgumentException(memberId + " id'li üye kütüphanemizde bulunmamaktadır.");
    }
    return members.get(memberId);
}

public Member findMemberByName(String name) {
    for (Member member : members.values()) {
        if (member.getName().equalsIgnoreCase(name)) {
            return member;
        }
    }
    throw new IllegalArgumentException(name + " adlı üye kütüphanemizde bulunmamaktadır.");
}

public void addLibraryStuff(LibraryStuff stuffMember) {
    if (stuffs.containsKey(stuffMember.getStuffId())) {
        throw new IllegalArgumentException("Bu ID'ye sahip bir personel zaten var!");
    }
    stuffs.put(stuffMember.getStuffId(), stuffMember);
}

public void removeLibraryStuff(LibraryStuff stuffMember) {
    if (!stuffs.containsKey(stuffMember.getStuffId())) {
        throw new IllegalArgumentException(stuffMember.getName() + " adlı personel kütüphanemizde bulunmamaktadır.");
    }
    stuffs.remove(stuffMember.getStuffId());
}

public LibraryStuff findLibraryStuffByName(String name) {
    for (LibraryStuff stuffMember : stuffs.values()) {
        if (stuffMember.getName().equalsIgnoreCase(name)) {
            return stuffMember;
        }
    }
    throw new IllegalArgumentException(name + " adlı personel kütüphanemizde bulunmamaktadır.");
}

public LibraryStuff findLibraryStuffById(long stuffId) {
    if (!stuffs.containsKey(stuffId)) {
        throw new IllegalArgumentException(stuffId + " id'li personel kütüphanemizde bulunmamaktadır.");
    }
    return stuffs.get(stuffId);
}


public void lendBook(int bookId, long memberId) {
    Member member = members.get(memberId);
    Book book = books.get(bookId);
    if (!members.containsKey(memberId)) {
        throw new IllegalArgumentException(memberId + " id'li üye bulunamadı.");
    }
    if (!books.containsKey(bookId)) {
        throw new IllegalArgumentException(bookId + " id'li kitap bulunamadı.");
    }
    if (member.getBorrowedBooks().size() >= 5) {
        throw new IllegalArgumentException("Bir üye en fazla 5 kitap ödünç alabilir.");
    }
    member.getBorrowedBooks().add(book);
   
    book.setEnableBorrow(false);
    java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
    BorrowRecord borrowRecord = new BorrowRecord(book, member, today, null);
    borrowRecords.add(borrowRecord);
}

public void returnBook(int bookId, long memberId) {
    Member member = members.get(memberId);
    Book book = books.get(bookId);
    if (!members.containsKey(memberId)) {
        throw new IllegalArgumentException(memberId + " id'li üye bulunamadı.");
    }
    if (!books.containsKey(bookId)) {
        throw new IllegalArgumentException(bookId + " id'li kitap bulunamadı.");
    }
    if (!member.getBorrowedBooks().contains(book)) {
        throw new IllegalArgumentException("Üye bu kitabı ödünç almamış.");
    }
    member.getBorrowedBooks().remove(book);
    
    book.setEnableBorrow(true);
    for (BorrowRecord record : borrowRecords) {
        if (record.getBook().equals(book) && record.getMember().equals(member) && record.getReturnDate() == null) {
            record.setReturnDate(new java.sql.Date(System.currentTimeMillis()));
            break;
        }
    }
}

public double calculateLateReturnPenalty(long memberId, int bookId) {
    double totalPenalty = 0.0;
    Date borrowedDate = null;
    Date returnedDate = null;
    for (BorrowRecord record : borrowRecords) {
        if (record.getMember().getMemberId() == memberId &&
            record.getBook().getBookId() == bookId) {
            borrowedDate = record.getBorrowDate();
            returnedDate = record.getReturnDate();
            break;
        }
    }
    if (borrowedDate == null || returnedDate == null) {
        throw new IllegalArgumentException("Geçerli bir ödünç alma kaydı bulunamadı.");
    }
    long diffInMillis = returnedDate.getTime() - borrowedDate.getTime();
    long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);
    if (diffInDays > allowedDays) {
        int lateDays = (int) (diffInDays - allowedDays);
        totalPenalty = lateDays * penaltyPerDay;
    }
    Member member = members.get(memberId);
    member.setTotalPenalty(member.getTotalPenalty() + totalPenalty);
    return totalPenalty;
}
    
    public void updatePenaltyPolicy(int allowedDays, double penaltyPerDay) {
        if (allowedDays < 1 || penaltyPerDay < 0) {
            throw new IllegalArgumentException("Geçersiz ceza/ödünç kuralı değeri.");
        }
        this.allowedDays = allowedDays;
        this.penaltyPerDay = penaltyPerDay;
    }


public void updateBook(int bookId, Book updatedBook) {
    if (!books.containsKey(bookId)) {
        throw new IllegalArgumentException(bookId + " id'li kitap bulunamadı.");
    }
    Book existingBook = books.get(bookId);

    existingBook.setTitle(updatedBook.getTitle());
    existingBook.setType(updatedBook.getType());
    existingBook.setAuthor(updatedBook.getAuthor());
    existingBook.setShelf(updatedBook.getShelf());
    existingBook.setEnableBorrow(updatedBook.isEnableBorrow());
    existingBook.setAddedTime(updatedBook.getAddedTime());    
}

public void updateMember(long memberId, Member updatedMember) {
    if (!members.containsKey(memberId)) {
        throw new IllegalArgumentException(memberId + " id'li üye bulunamadı.");
    }
    Member existingMember = members.get(memberId);

    existingMember.setName(updatedMember.getName());
    existingMember.setEmail(updatedMember.getEmail());
    existingMember.setPhoneNumber(updatedMember.getPhoneNumber());
    existingMember.setAddress(updatedMember.getAddress());
    existingMember.setBorrowedBooks(updatedMember.getBorrowedBooks());
}

public void updateLibraryStuff(long stuffId, LibraryStuff updatedStuff) {
    if (!stuffs.containsKey(stuffId)) {
        throw new IllegalArgumentException(stuffId + " id'li personel bulunamadı.");
    }
    LibraryStuff existingStuff = stuffs.get(stuffId);
    existingStuff.setName(updatedStuff.getName());
    existingStuff.setEmail(updatedStuff.getEmail());
    existingStuff.setPhoneNumber(updatedStuff.getPhoneNumber());
    existingStuff.setAddress(updatedStuff.getAddress());
}

public List<Book> listAllBooks() { 
    List<Book> allBooks = new ArrayList<>(books.values());
    for (Book book : allBooks) {
        System.out.println(book.getTitle()+", "+book.getAuthor().getName()+", "+book.getType()+", "+book.isEnableBorrow());
    }
     return allBooks;
}

public List<Member> listAllMembers() { 
    List<Member> allMembers = new ArrayList<>(members.values());
    for (Member member : allMembers) {
        System.out.println(member.getName()+", "+member.getEmail()+", "+member.getPhoneNumber());
    }
     return allMembers;
}

public List<LibraryStuff> listAllLibraryStaff() { 
    List<LibraryStuff> allStaff = new ArrayList<>(stuffs.values());
    for (LibraryStuff staff : allStaff) {
        System.out.println(staff.getName()+", "+staff.getEmail()+", "+staff.getPhoneNumber());
    }
     return allStaff;
}

public List<Book> searchBooks(String keyword) {
    if (keyword == null || keyword.isEmpty()) {
        throw new IllegalArgumentException("Boş arama yapılamaz.");
    }
    List<Book> result = new ArrayList<>();
    String lowerKeyword = keyword.toLowerCase();
    for (Book book : books.values()) {
        if (book.getTitle() != null && book.getTitle().toLowerCase().contains(lowerKeyword)) {
            result.add(book);
        }
    }
    if (result.isEmpty()) {
        throw new IllegalArgumentException("Aranan başlığa uygun kitap bulunamadı.");
    }
    return result;
}

public List<Member> searchMembers(String keyword) {
    if (keyword == null || keyword.isEmpty()) {
        throw new IllegalArgumentException("Boş arama yapılamaz.");
    }   
    List<Member> result = new ArrayList<>();
    String lowerKeyword = keyword.toLowerCase();
    for (Member member : members.values()) {
        if (member.getName() != null && member.getName().toLowerCase().contains(lowerKeyword)) {
            result.add(member);
        }
    }
    if (result.isEmpty()) {
        throw new IllegalArgumentException("Aranan ada uygun üye bulunamadı.");
    }
    return result;
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