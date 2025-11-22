package org.example.library.person;

import java.util.Objects;

public class LibraryStaff extends Person{
    private long stuffId;
    public LibraryStaff() {

    }

    public LibraryStaff(long stuffId, String name, String address, String phoneNumber, String email, String role) {
        super(name, address, phoneNumber, email, role);
        this.stuffId=stuffId;
    }

    public long getStuffId() {
        return stuffId;
    }

    public void setStuffId(long stuffId) {
        this.stuffId = stuffId;
    }

    @Override
    public String toString() {
        return "LibraryStaff{" +
                "id=" + getStuffId() +
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
        LibraryStaff that = (LibraryStaff) o;
        return stuffId == that.stuffId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stuffId);
    }

}



