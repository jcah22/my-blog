package com.blog.blog.repository;

import com.blog.blog.entity.PostEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity,Integer> {

    List<PostEntity> findByUserId(Integer id);

    List<PostEntity> findByTitleContainingIgnoreCase(String title);


}
