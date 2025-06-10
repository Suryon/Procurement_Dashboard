package com.mvp2.mvp2.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final ChatClient chatClient;

    public AIService(@Qualifier("ollamaChatModel") OllamaChatModel chatModel) {
        this.chatClient = ChatClient.builder(chatModel).build();
    }

    public String getSpendInsights(Double totalSpend, Long orderCount) {
        String prompt = String.format(
                "You are an amazing analyst. Analyze procurement data given: Total spend: $%.2f, Orders: %d. Give 2 simple insights in 50 words.",
                totalSpend, orderCount
        );
        return chatClient.prompt().user(prompt).call().content();
    }

    public String getRecommendation(String category, Double amount) {
        String prompt = String.format(
                "You are a guy who gives amazing advice to businesses. Procurement advice for %s category with $%.2f spend. Give 1 simple recommendation in 30 words.",
                category, amount
        );
        return chatClient.prompt().user(prompt).call().content();
    }
}
