package com.dam2.spring1an;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class WebController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;

    // Operación de guardar ARTICULO
// curl -X POST http://localhost:8080/articles/altaA -d '{"name": "serra del sit","category": "geografia", "numPages": 12}' -H "Content-Type: application/json"
    @PostMapping("/articles/altaA")
    public void saveArticle(@RequestBody Article article) {
        articleService.saveArticle(article);
    }

    // Operación de guardar COMENTARIO
    //  curl -X POST http://localhost:8080/articles/1/altaC -d '{"message": "és una ruta de dificultat mitjana"}' -H "Content-Type: application/json"
    @PostMapping("/articles/{idA}/altaC")
    public void saveMessage(@PathVariable("idA") Long idA, @RequestBody Comment comment) {
        Article article= articleService.findById(idA).get();
        //System.out.println(article);
        comment.setArticle(article);
        article.getCommentList().add(comment);

        //System.out.println(article);
        commentService.saveComment(comment);
        //articleService.updateArticle(idA, article);
        articleService.saveArticle(article);
    }
    // Read operation
    @GetMapping("/articles")
    // curl -X GET localhost:8080/articles
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @GetMapping("/articles/{id}")
    // curl -X GET localhost:8080/articles/1
    public Optional<Article> findOne(@PathVariable("id") Long Id) {
        return articleService.findById(Id);
    }

    @GetMapping("/articles/{idA}/{idC}")
    // curl -X GET localhost:8080/articles/1/1
    public Optional<Comment> findOne(@PathVariable("idA") Long idA, @PathVariable("idC") Long idC) {
        return articleService.findById(idA).get().getComment(idC);
    }

    // Update operation
    @PutMapping("/articles/{id}")
    public Article
    updateArticle(@PathVariable("id") Long Id, @RequestBody Article article) {
        return articleService.updateArticle(Id, article);
    }

    // Delete operation ARTICLE
    @DeleteMapping("/articles/{id}")
    //curl -X DELETE localhost:8080/articles/1
    // VIGILA QUE FALLARÁ (ERROR: update or delete on table "articles" violates foreign key constraint)
    // SI EL ARTICULO CONTIENE MENSAJES
    public String deleteArticleById(@PathVariable("id") Long Id) {
        articleService.deleteArticleById(Id);
        return "Deleted Successfully";
    }

    // Delete operation MESSAGE
    @DeleteMapping("/comments/{idC}")
    //curl -X DELETE localhost:8080/comments/1
    public String deleteCommentById(@PathVariable("idC") Long idC) {
        commentService.deleteCommentById(idC);
    return "Deleted Successfully";
    }
}
