package com.blog.blog.service;

import com.blog.blog.entity.PostEntity;
import com.blog.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostEntity> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Optional<PostEntity> getPostById(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public List<PostEntity> getPostByUserId(Integer userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public void savePost(PostEntity post) {
        postRepository.save(post);
    }

    @Override
    public void updatePost(Integer id, PostEntity post) {
            PostEntity postDB = getPostById(id).orElseThrow(()->new InvalidParameterException("Invaliad postId"));
            postDB.setTitle(post.getTitle());
            postDB.setContent(post.getContent());
            postRepository.save(postDB);
    }


    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }



}
