package com.dam2.spring1an;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter*/
@Entity
@Table(name = "articles")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String category;
    @Column
    private int numPages;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @OneToMany(mappedBy = "article",cascade = CascadeType.PERSIST)
    // ANOTACIÓ IMPRESCINDIBLE PER A EVITAR EL BUCLE INFINIT ENTRE ARTICLE I COMMENT  ...
    @JsonManagedReference
    private List<Comment> commentList = new ArrayList<>();

    public Article() {
    }

    public Article(String name, String category, int numPages, LocalDateTime creationDate) {
        this.name = name;
        this.category = category;
        this.numPages = numPages;
        this.creationDate = creationDate;
        this.commentList = new ArrayList<Comment>();
    }
    public Article(String name, String category, int numPages, LocalDateTime creationDate, List<Comment> commentList) {
        this.name = name;
        this.category = category;
        this.numPages = numPages;
        this.creationDate = creationDate;
        this.commentList = commentList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", numPages=" + numPages +
                ", creationDate=" + creationDate +
                ", commentList=" + commentList +
                '}';
    }

    public Optional<Comment> getComment(Long id)
    {
        return commentList.stream().filter(c->c.getId() == id).findFirst();
    }

}
