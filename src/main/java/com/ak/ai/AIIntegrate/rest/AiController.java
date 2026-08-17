package com.ak.ai.AIIntegrate.rest;

import com.ak.ai.AIIntegrate.service.NvidiaAiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final NvidiaAiService aiService;

    public AiController(NvidiaAiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String prompt) {
        return aiService.ask(prompt);
    }
}