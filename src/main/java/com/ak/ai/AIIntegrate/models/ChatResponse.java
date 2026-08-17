package com.ak.ai.AIIntegrate.models;

import java.util.List;

public record ChatResponse(
        List<Choice> choices
) {

    public record Choice(
            ChatMessage message
    ) {}
}