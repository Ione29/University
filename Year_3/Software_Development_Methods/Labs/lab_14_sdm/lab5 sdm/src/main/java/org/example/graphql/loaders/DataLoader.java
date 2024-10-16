package org.example.graphql.loaders;

import org.example.graphql.domain.*;
import org.example.graphql.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BuyerService buyerService;
    private final RatingService ratingService;

    public DataLoader(BookService bookService, PublisherService publisherService, AuthorService authorService, BuyerService buyerService, RatingService ratingService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.buyerService = buyerService;
        this.ratingService = ratingService;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher poli=new Publisher("Politehnica Press");
        Author joe=new Author("Joe Java");
        Author mary=new Author("Mary PHP");
        Book b1=new Book("Programming in Java","isbn123",joe,poli);
        Book b2=new Book("Programming in PHP","isbn124",mary,poli);
        bookService.saveBook(b1);
        bookService.saveBook(b2);

        Buyer b=new Buyer("John Doe");
        buyerService.saveBuyer(b);
        Buyer c=new Buyer("Jane Doe");
        buyerService.saveBuyer(c);
        b.getFriends().add(c);
        c.getFriends().add(b);
        buyerService.saveBuyer(b);

        Rating r1=new Rating(Grade.ONE,"Bad",b,b1);
        Rating r2=new Rating(Grade.FIVE,"Good",c,b2);
        ratingService.saveRating(r1);
        ratingService.saveRating(r2);
        buyerService.saveBuyer(b);
        buyerService.saveBuyer(c);
        bookService.saveBook(b1);
        bookService.saveBook(b2);







    }
}
