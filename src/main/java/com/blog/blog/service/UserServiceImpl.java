package com.blog.blog.service;

import com.blog.blog.entity.UserEntity;
import com.blog.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserEntity userEntity) {
            userRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> getuserBYId(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> getuserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
