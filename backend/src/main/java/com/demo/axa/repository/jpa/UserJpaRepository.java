package com.demo.axa.repository.jpa;

import com.demo.axa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Custom query methods can be added here
}

