package com.demo.axa.service;

import com.demo.axa.model.SanitizeRequest;
import com.demo.axa.model.SanitizedResponse;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    public SanitizedResponse sanitize(SanitizeRequest input) {
        String sanitizedInput = input.getValue().trim();

        // Replace dangerous characters with safe alternatives
        sanitizedInput = sanitizedInput.replaceAll("<", "&lt;");
        sanitizedInput = sanitizedInput.replaceAll(">", "&gt;");
        sanitizedInput = sanitizedInput.replaceAll("'", "&#39;");
        sanitizedInput = sanitizedInput.replaceAll("\"", "&quot;");

        // Replace multiple spaces with a single space
        sanitizedInput = sanitizedInput.replaceAll("\\s+", " ");

        return new SanitizedResponse(input.getValue(), sanitizedInput);
    }
}
