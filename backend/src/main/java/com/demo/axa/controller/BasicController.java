package com.demo.axa.controller;
import com.demo.axa.model.Request;
import com.demo.axa.model.Response;
import com.demo.axa.service.BasicService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BasicController {

    private BasicService basicService;

    @PostMapping("/sanitize")
    public ResponseEntity<Response> sanitize(@Valid @RequestBody Request input) {
        return ResponseEntity.ok(this.basicService.sanitize(input));
    }

}
