package com.demo.axa.repository;

import com.demo.axa.converter.UserConverter;
import com.demo.axa.model.User;
import com.demo.axa.model.UserEntity;
import com.demo.axa.repository.jpa.UserJpaRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserConverter converter;

    public User findByUserId(Long userId) {
        return userJpaRepository.findById(userId)
                .map(converter::toUser)
                .orElseThrow(RuntimeException::new);
    }

    public User save(User user) {

        UserEntity userEntity = userJpaRepository.save(converter.toUserEntity(user));
        return this.converter.toUser(userEntity);
    }
}
