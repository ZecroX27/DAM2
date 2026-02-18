package com.dam2.spring1an;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
/*
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter*/
@Entity
@Table(name = "comments")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String message;
    @ManyToOne
    @JoinColumn(name = "articleId")
    // IMPRESCINDIBLE PARA EVITAR EL BUCLE INFINIT0 ENTRE ARTICLE I COMMENT QUE AL MISMO TIEMPO TIENE ARTICLE ...
    @JsonBackReference
    private Article article;

    public Comment() {
    }

    public Comment(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", article=" + article.getId() +
                '}';
    }
}
