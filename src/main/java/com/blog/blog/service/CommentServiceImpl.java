package com.blog.blog.service;

import com.blog.blog.entity.CommentEntity;
import com.blog.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Optional<CommentEntity> getCommentById(Integer id) {
        return commentRepository.findById(id);
    }

    @Override
    public void createComment(CommentEntity commentEntity) {
            commentRepository.save(commentEntity);
    }

    @Override
    public void updateComment(Integer id, CommentEntity commentEntity) {
        CommentEntity commentDB = getCommentById(id).orElseThrow( () -> new InvalidParameterException("Invalid comment id"));
        commentDB.setContent(commentEntity.getContent());
        commentRepository.save(commentDB);


    }

    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
