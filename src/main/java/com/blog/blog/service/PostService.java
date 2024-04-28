package com.blog.blog.service;

import com.blog.blog.entity.PostEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<PostEntity> getAllPost();

    Optional<PostEntity> getPostById(Integer id);

    List<PostEntity> getPostByUserId(Integer userId);

    void savePost(PostEntity post);

    void updatePost(Integer id, PostEntity post);

    void deletePost(Integer id);


}
