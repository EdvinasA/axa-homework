package com.demo.axa.user.converter;

import com.demo.axa.converter.UserConverter;
import com.demo.axa.model.User;
import com.demo.axa.model.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserConverterTest {

    private UserConverter userConverter = new UserConverter();


    @BeforeEach
    void setUp() {
        this.userConverter = new UserConverter();
    }

    @Test
    void testToUser() {
        UserEntity entity = new UserEntity();
        entity.setEmail("john@example.com");
        entity.setName("John Doe");
        entity.setMessage("Hello, world!");

        User user = userConverter.toUser(entity);

        assertNotNull(user);
        assertEquals("john@example.com", user.getEmail());
        assertEquals("John Doe", user.getName());
        assertEquals("Hello, world!", user.getMessage());
    }

    @Test
    void testToUserEntity() {
        User user = new User();
        user.setEmail("jane@example.com");
        user.setName("Jane Doe");
        user.setMessage("Goodbye, world!");

        UserEntity entity = userConverter.toUserEntity(user);

        assertNotNull(entity);
        assertEquals("jane@example.com", entity.getEmail());
        assertEquals("Jane Doe", entity.getName());
        assertEquals("Goodbye, world!", entity.getMessage());
    }
}
