package com.demo.axa.controller;
import com.demo.axa.model.SanitizeRequest;
import com.demo.axa.model.SanitizedResponse;
import com.demo.axa.service.BasicService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BasicController {

    private BasicService basicService;

    @GetMapping("/sanitize")
    public ResponseEntity<SanitizedResponse> sanitize(@RequestBody SanitizeRequest input) {
        return ResponseEntity.ok(this.basicService.sanitize(input));
    }

}
