package com.demo.axa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanitizedResponse {
    private String rawInput;
    private String sanitizedValue;
}
