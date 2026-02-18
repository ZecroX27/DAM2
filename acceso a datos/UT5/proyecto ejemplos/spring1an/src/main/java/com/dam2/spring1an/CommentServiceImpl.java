package com.dam2.spring1an;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public ArrayList<Comment> findAll() {
        return (ArrayList<Comment>) commentRepository.findAll();
    }
    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }
    @Override
    public void saveComment(Comment Comment) {
        commentRepository.save(Comment);
    }
    @Override
    public Comment updateComment(Long id, Comment Comment)
    {
        Comment comment = commentRepository.findById(id).get();
        if (Objects.nonNull(comment.getMessage()) && !"".equalsIgnoreCase(Comment.getMessage())) {
            comment.setMessage(Comment.getMessage());
        }
       commentRepository.save(comment);
        return comment;
    }
    // delete operation
    @Override
    public void deleteCommentById(Long productId) {
        commentRepository.deleteById(productId);
    }
}

