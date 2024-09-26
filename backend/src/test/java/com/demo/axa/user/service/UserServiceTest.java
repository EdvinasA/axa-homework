package com.demo.axa.user.service;

import com.demo.axa.exceptions.EmailInUseException;
import com.demo.axa.user.model.UserRequest;
import com.demo.axa.user.model.User;
import com.demo.axa.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private UserRequest userRequest;

    @BeforeEach
    void setUp() {
        this.userRequest = new UserRequest(" John Doe ", "john@example.com", " Hello, world! ");
    }

    @Test
    void testCreateUser() {
        when(userRepository.doesEmailExist(userRequest.getEmail())).thenReturn(false);

        User expectedUser = new User("John Doe", "john@example.com", "Hello, world!");
        when(userRepository.save(any(User.class))).thenReturn(expectedUser);

        User createdUser = userService.createUser(this.userRequest);

        assertNotNull(createdUser);
        assertEquals("John Doe", createdUser.getName());
        assertEquals("john@example.com", createdUser.getEmail());
        assertEquals("Hello, world!", createdUser.getMessage());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void testCreateUserWhenEmailExists() {
        when(userRepository.doesEmailExist("john@example.com")).thenReturn(true);

        assertThrows(EmailInUseException.class, () -> userService.createUser(this.userRequest));

        verify(userRepository, never()).save(any(User.class));
    }
}
