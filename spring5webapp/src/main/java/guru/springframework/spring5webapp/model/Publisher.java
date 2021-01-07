package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;
    private String address;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher(String name, String address) {

        this.name = name;
        this.address = address;
    }

    public Publisher() {
    }


    @Override
    public String toString() {
        return "Publisher{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return Id != null ? Id.equals(publisher.Id) : publisher.Id == null;
    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
