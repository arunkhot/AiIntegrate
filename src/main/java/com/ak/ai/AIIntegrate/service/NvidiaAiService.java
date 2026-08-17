package com.ak.ai.AIIntegrate.service;

import com.ak.ai.AIIntegrate.models.ChatMessage;
import com.ak.ai.AIIntegrate.models.ChatRequest;
import com.ak.ai.AIIntegrate.models.ChatResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class NvidiaAiService {

    private final WebClient webClient;

    public NvidiaAiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String ask(String prompt) {

        ChatRequest request = new ChatRequest(
                "meta/llama-3.3-70b-instruct",
                List.of(new ChatMessage("user", prompt)),
                0.2,
                1000
        );

        ChatResponse response = webClient.post()
                .uri("/chat/completions")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ChatResponse.class)
                .block();

        return response.choices()
                .getFirst()
                .message()
                .content();
    }
}