package com.example.krasivohobi.model.entity;

import com.example.krasivohobi.model.entity.enums.ArtTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import javax.persistence.Entity;

@Entity
@Table(name = "arts")
public class ArtEntity extends BaseEntity {

    private String name;
    private String description;
    private BigDecimal price;
    private ArtTypeEnum artType;
    private UserEntity author;

    public ArtEntity() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public ArtEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArtEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ArtEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(name = "art_type", nullable = false)
    @Enumerated(EnumType.STRING)
    public ArtTypeEnum getArtType() {
        return artType;
    }

    public ArtEntity setArtType(ArtTypeEnum artType) {
        this.artType = artType;
        return this;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public ArtEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

}
