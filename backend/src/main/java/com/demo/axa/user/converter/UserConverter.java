package com.demo.axa.user.converter;

import com.demo.axa.user.model.User;
import com.demo.axa.user.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public User toUser(UserEntity entity) {
        User user = new User();
        user.setEmail(entity.getEmail());
        user.setName(entity.getName());
        user.setMessage(entity.getMessage());
        return user;
    }

    public UserEntity toUserEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        entity.setMessage(user.getMessage());
        return entity;
    }
}