package com.ak.ai.AIIntegrate.models;
import java.util.List;

public record ChatRequest(
        String model,
        List<ChatMessage> messages,
        double temperature,
        int max_tokens
) {}
