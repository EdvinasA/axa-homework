package com.demo.axa.user.service;

import com.demo.axa.exceptions.EmailInUseException;
import com.demo.axa.user.model.UserRequest;
import com.demo.axa.user.model.User;
import com.demo.axa.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private String sanitize(String input) {
        return input.trim()
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("'", "&#39;")
                .replaceAll("\"", "&quot;")
                .replaceAll("\\s+", " ");
    }

    public User createUser(UserRequest input) {
        if (this.userRepository.doesEmailExist(input.getEmail())) {
            throw new EmailInUseException();
        }
        return userRepository.save(new User(this.sanitize(input.getName()), this.sanitize(input.getEmail()), this.sanitize(input.getMessage())));
    }
}
