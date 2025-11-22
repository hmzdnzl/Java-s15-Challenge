package org.example.library.person;

public class Author extends Person {
    public Author(String name, String role) {
        super();
        setName(name);
        setRole(role);
    }

    @Override
    public String toString() {
        return "Author{" +
                ", name='" + getName() + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getName().equals(author.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
