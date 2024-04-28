package com.blog.blog.service;

import com.blog.blog.entity.CommentEntity;

import java.util.Optional;

public interface CommentService {

    Optional<CommentEntity> getCommentById(Integer id);

    void createComment(CommentEntity commentEntity);

    void updateComment(Integer id, CommentEntity commentEntity);

    void deleteComment(Integer id);
}
