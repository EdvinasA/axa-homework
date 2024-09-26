package com.demo.axa.user.repository;

import com.demo.axa.user.converter.UserConverter;
import com.demo.axa.exceptions.UserNotFoundException;
import com.demo.axa.user.model.User;
import com.demo.axa.user.model.UserEntity;
import com.demo.axa.user.repository.jpa.UserJpaRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserConverter converter;

    public boolean doesEmailExist(String email) {
        return userJpaRepository.findByEmail(email)
                .map(converter::toUser)
                .isPresent();
    }

    public User save(User user) {
        UserEntity userEntity = userJpaRepository.save(converter.toUserEntity(user));

        return this.converter.toUser(userEntity);
    }
}
