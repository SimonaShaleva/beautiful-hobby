package com.example.krasivohobi.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "articles")
public class ArticleEntity extends BaseEntity {

    private String name;
    private LocalDate addedOn;
    private int likes;
    private UserEntity publisher;

    public ArticleEntity() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public ArticleEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "added_on", nullable = false)
    public LocalDate getAddedOn() {
        return addedOn;
    }

    public ArticleEntity setAddedOn(LocalDate addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public int getLikes() {
        return likes;
    }

    public ArticleEntity setLikes(int likes) {
        this.likes = likes;
        return this;
    }

    @ManyToOne
    public UserEntity getPublisher() {
        return publisher;
    }

    public ArticleEntity setPublisher(UserEntity publisher) {
        this.publisher = publisher;
        return this;
    }

}
