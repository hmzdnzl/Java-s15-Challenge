package org.example.library.person;

import java.util.Objects;

import org.example.library.Book;
import java.util.ArrayList;
import java.util.List;

public class Member extends Person{
    private long memberId;
    private List<Book> borrowedBooks = new ArrayList<>();
    private List<Book> donatedBooks = new ArrayList<>();
        public List<Book> getDonatedBooks() {
            return donatedBooks;
        }

        public void setDonatedBooks(List<Book> donatedBooks) {
            this.donatedBooks = donatedBooks != null ? donatedBooks : new ArrayList<>();
        }
    private double totalPenalty = 0.0;
       

    public Member() {
        this.borrowedBooks = new ArrayList<>();
        this.totalPenalty = 0.0;
    }

    public Member(long memberId, String name, String address, String phoneNumber, String email, String role, List<Book> borrowedBooks, double totalPenalty) {
        super(name, address, phoneNumber, email, role);
        this.memberId = memberId;
        this.borrowedBooks = borrowedBooks != null ? borrowedBooks : new ArrayList<>();
        this.totalPenalty = totalPenalty;
    }
    public double getTotalPenalty() {
        return totalPenalty;
    }

    public void setTotalPenalty(double totalPenalty) {
        this.totalPenalty = totalPenalty;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        if (memberId < 1) {
            throw new IllegalArgumentException("Member ID sıfır veya sıfırdan küçük olamaz.");
        }
        this.memberId = memberId;
    }

     public List<Book> getBorrowedBooks() {
            return borrowedBooks;
        }

        public void setBorrowedBooks(List<Book> borrowedBooks) {
        if (borrowedBooks.size() <= 5) {
            this.borrowedBooks = borrowedBooks;
        } else {
            throw new IllegalArgumentException("En fazla 5 kitap ödünç alabilirsiniz.");
        }
    }

    @Override
    public String toString() {
        return "LibraryStaff{" +
                "id=" + getMemberId() +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(memberId);
    }
}
