package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {



    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher viz = new Publisher();
        viz.setName("Viz Media");
        viz.setAddress("USA");
        publisherRepository.save(viz);

        Publisher blackHorse = new Publisher();
        blackHorse.setName("Black Horse");
        blackHorse.setAddress("USA");
        publisherRepository.save(blackHorse);

        System.out.println("Publisher count: " + publisherRepository.count());


        Author oda = new Author("Eichiro", "Oda");
        Book onePiece = new Book("One Piece", "123123");

        oda.getBooks().add(onePiece);
        onePiece.getAuthors().add(oda);
        onePiece.setPublisher(viz);
        viz.getBooks().add(onePiece);

        authorRepository.save(oda);
        bookRepository.save(onePiece);
        publisherRepository.save(viz);

        Author kentaro = new Author("Kentaro", "Miura");
        Book berserk = new Book("Berserk", "123456");
        kentaro.getBooks().add(berserk);
        berserk.getAuthors().add(kentaro);
        berserk.setPublisher(blackHorse);
        blackHorse.getBooks().add(berserk);

        authorRepository.save(kentaro);
        bookRepository.save(berserk);
        publisherRepository.save(blackHorse);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher number of books : " + viz.getBooks().size());
    }
}
