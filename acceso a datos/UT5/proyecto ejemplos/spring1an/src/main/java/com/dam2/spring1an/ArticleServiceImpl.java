package com.dam2.spring1an;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public ArrayList<Article> findAll() {
        return (ArrayList<Article>) articleRepository.findAll();
    }
    @Override
    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }
    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }
    @Override
    public Article updateArticle(Long id, Article article)
    {
        Article prodDB = articleRepository.findById(id).get();
        if (Objects.nonNull(article.getName()) && !"".equalsIgnoreCase(article.getName())) {
            prodDB.setName(article.getName());
        }
        articleRepository.save(prodDB);
        return prodDB;
    }
    // delete operation
    @Override
    public void deleteArticleById(Long productId) {
        articleRepository.deleteById(productId);
    }
}

