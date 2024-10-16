package org.example.graphql.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Buyer {

    @Id @GeneratedValue
    private Long id;
    private String name;
    @OneToMany
    private List<Rating> ratings;
    @ManyToMany
    private List<Buyer> friends;

    public Buyer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Buyer> getFriends() {
        return friends;
    }

    public void setFriends(List<Buyer> friends) {
        this.friends = friends;
    }

    public Buyer(String name) {
        this.name = name;
        this.ratings = new ArrayList<>();
        this.friends = new ArrayList<>();
    }
}
