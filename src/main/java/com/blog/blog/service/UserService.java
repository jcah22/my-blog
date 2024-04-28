package com.blog.blog.service;

import com.blog.blog.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    void createUser(UserEntity userEntity);

    Optional<UserEntity> getuserBYId(Integer id);

    Optional<UserEntity> getuserByUsername(String username);
}
