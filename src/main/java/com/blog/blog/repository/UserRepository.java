package com.blog.blog.repository;

import com.blog.blog.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    @Query("SELECT u FROM UserEntity  u WHERE  u.username = :username")
    Optional<UserEntity> findByUsername(@Param("username") String username);





}
