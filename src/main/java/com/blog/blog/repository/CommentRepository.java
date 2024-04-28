package com.blog.blog.repository;

import com.blog.blog.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {

    List<CommentEntity> findByPostId(Integer id);
}
