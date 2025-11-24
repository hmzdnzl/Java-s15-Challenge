package org.example.library;

import java.sql.Date;
import org.example.library.Book;
import org.example.library.person.Member;
import java.util.Objects;

public class BorrowRecord {
   private Book book;
   private Member member;
   private Date borrowDate;
   private Date returnDate;

   public BorrowRecord() {
   }

   public BorrowRecord(Book book, Member member, Date borrowDate, Date returnDate) {
      this.book = book;
      this.member = member;
      this.borrowDate = borrowDate;
      this.returnDate = returnDate;
   }

   public Book getBook() {
      return book;
   }

   public void setBook(Book book) {
      this.book = book;
   }

   public Member getMember() {
      return member;
   }

   public void setMember(Member member) {
      this.member = member;
   }

   public Date getBorrowDate() {
      return borrowDate;
   }

   public void setBorrowDate(Date borrowDate) {
      this.borrowDate = borrowDate;
   }

   public Date getReturnDate() {
      return returnDate;
   }

   public void setReturnDate(Date returnDate) {
      this.returnDate = returnDate;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      BorrowRecord that = (BorrowRecord) o;
      return Objects.equals(book, that.book) &&
            Objects.equals(member, that.member) &&
            Objects.equals(borrowDate, that.borrowDate) &&
            Objects.equals(returnDate, that.returnDate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(book, member, borrowDate, returnDate);
   }

   @Override
   public String toString() {
      return "BorrowRecord{" +
            "book=" + (book != null ? book.getTitle() : null) +
            ", member=" + (member != null ? member.getName() : null) +
            ", borrowDate=" + borrowDate +
            ", returnDate=" + returnDate +
            '}';
   }
}
