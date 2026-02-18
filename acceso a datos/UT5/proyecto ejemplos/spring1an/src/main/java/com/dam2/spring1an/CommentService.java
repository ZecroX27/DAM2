package com.dam2.spring1an;

import java.util.ArrayList;
import java.util.Optional;

public interface CommentService {
    ArrayList<Comment> findAll();
    Optional<Comment> findById(Long id);
    void saveComment(Comment comment);
    Comment updateComment(Long i, Comment comment);
    void deleteCommentById(Long Id);
}