package org.example.graphql.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Rating {
    @Id @GeneratedValue
    private Long id;
    private Grade grade;
    private String comment;
    @ManyToOne
    private Buyer buyer;
    @OneToOne
    private Book book;



    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Rating() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Rating(Grade grade, String comment, Buyer buyer, Book book) {
        this.grade = grade;
        this.comment = comment;
        this.buyer = buyer;
        this.book = book;
        this.book.getRatings().add(this);
        this.buyer.getRatings().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Objects.equals(getId(), rating.getId()) && getGrade() == rating.getGrade() && Objects.equals(getComment(), rating.getComment()) && Objects.equals(getBuyer(), rating.getBuyer()) && Objects.equals(getBook(), rating.getBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGrade(), getComment(), getBuyer(), getBook());
    }
}
