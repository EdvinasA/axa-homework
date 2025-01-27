package com.demo.axa.user.controller;
import com.demo.axa.user.model.UserRequest;
import com.demo.axa.user.model.User;
import com.demo.axa.user.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> sanitize(@Valid @RequestBody UserRequest input) {
        return ResponseEntity.ok(this.userService.createUser(input));
    }

}
