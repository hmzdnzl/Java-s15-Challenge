package org.example.library.person;

import java.util.Objects;

public class Member extends Person{
    private long memberId;
    public Member() {

    }

    public Member(long memberId, String name, String address, String phoneNumber, String email, String role) {
        super(name, address, phoneNumber, email, role);
        this.memberId=memberId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
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
