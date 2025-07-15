package org.acme;

import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import jakarta.inject.Inject;

public class Sentiment {

    @Inject
    SentimentAnalyzer sentimentClient;

    @Tool(description = "Get sentiment analysis for a review .")
    String getSentiment(@ToolArg(description = "A review submitted by a customer") String review) {
        SentimentAnalyzer.Sentiment result = sentimentClient.classifySentiment(review);
        return result.toString();
    }

}