package com.demo.axa.service;

import com.demo.axa.model.Request;
import com.demo.axa.model.User;
import com.demo.axa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasicService {
    private final UserRepository userRepository;

    public User sanitize(Request input) {
        String sanitizedInput = input.getName().trim();

        // Replace dangerous characters with safe alternatives
        sanitizedInput = sanitizedInput.replaceAll("<", "&lt;");
        sanitizedInput = sanitizedInput.replaceAll(">", "&gt;");
        sanitizedInput = sanitizedInput.replaceAll("'", "&#39;");
        sanitizedInput = sanitizedInput.replaceAll("\"", "&quot;");

        // Replace multiple spaces with a single space
        sanitizedInput = sanitizedInput.replaceAll("\\s+", " ");
        return userRepository.save(new User(input.getName(), input.getEmail(), input.getMessage()));
    }

    private void saveUser(Request input) {
        userRepository.save(new User(input.getName(), input.getEmail(), input.getMessage()));
    }
}
