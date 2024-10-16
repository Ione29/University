package org.example.graphql.services;

import jakarta.transaction.Transactional;
import org.example.graphql.domain.Book;
import org.example.graphql.domain.Buyer;
import org.example.graphql.domain.Grade;
import org.example.graphql.domain.Rating;
import org.example.graphql.repositories.BookRepository;
import org.example.graphql.repositories.BuyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BuyerRepository buyerRepository;

    public BookService(BookRepository bookRepository, BuyerRepository buyerRepository) {
        this.bookRepository = bookRepository;
        this.buyerRepository = buyerRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getBooksRecommendations(Long id) {
        Optional<Buyer> buyer = buyerRepository.findById(id);
        return buyer.map(value -> value.getRatings().stream().filter(rating -> rating.getGrade() == Grade.FOUR || rating.getGrade() == Grade.FIVE)
                .map(Rating::getBook).toList()).orElseGet(List::of);
    }
}