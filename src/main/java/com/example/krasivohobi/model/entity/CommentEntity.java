package com.example.krasivohobi.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class CommentEntity extends BaseEntity {

    private int score;
    private String textContent;
    private LocalDate addedOn;
    private UserEntity author;
    private ArtEntity artEntity;
    private ArticleEntity articleEntity;

    public CommentEntity() {
    }

    @Column(name = "score", nullable = false)
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Column(name = "text_content", columnDefinition = "TEXT")
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Column(name = "added_on", nullable = false)
    public LocalDate getAddedOn() {
        return addedOn;
    }

    public CommentEntity setAddedOn(LocalDate addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public CommentEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public ArtEntity getArtEntity() {
        return artEntity;
    }

    public CommentEntity setArtEntity(ArtEntity artEntity) {
        this.artEntity = artEntity;
        return this;
    }

    @ManyToOne
    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public CommentEntity setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
        return this;
    }
}
