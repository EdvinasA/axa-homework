package com.demo.axa.service;

import com.demo.axa.model.Request;
import com.demo.axa.model.Response;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    public Response sanitize(Request input) {
        String sanitizedInput = input.getName().trim();

        // Replace dangerous characters with safe alternatives
        sanitizedInput = sanitizedInput.replaceAll("<", "&lt;");
        sanitizedInput = sanitizedInput.replaceAll(">", "&gt;");
        sanitizedInput = sanitizedInput.replaceAll("'", "&#39;");
        sanitizedInput = sanitizedInput.replaceAll("\"", "&quot;");

        // Replace multiple spaces with a single space
        sanitizedInput = sanitizedInput.replaceAll("\\s+", " ");

        return new Response(input.getName(), sanitizedInput, sanitizedInput);
    }
}
