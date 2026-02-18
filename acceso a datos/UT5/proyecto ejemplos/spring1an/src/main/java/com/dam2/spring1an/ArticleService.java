package com.dam2.spring1an;

import java.util.ArrayList;
import java.util.Optional;

public interface ArticleService {
    ArrayList<Article> findAll();
    Optional<Article> findById(Long id);
    void saveArticle(Article article);
    Article updateArticle(Long i, Article article);
    void deleteArticleById(Long productId);
}