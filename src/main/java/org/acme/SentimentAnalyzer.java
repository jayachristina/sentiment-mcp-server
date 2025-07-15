package org.acme;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface SentimentAnalyzer {

    @SystemMessage("You are a sentiment classifier. Respond strictly with a json of format {'isAbusive': boolean, 'rating': 1-5 where 1 is low, 'amendedReview': replace all abusive words entirely with *s and return the review  }  and nothing else.")
    @UserMessage("Classify the sentiment of: {{text}}")
    SentimentAnalyzer.Sentiment classifySentiment(String text);
    
    record Sentiment(boolean isAbusive, int rating, String amendedReview) {
        @Override
        public String toString() {
            return "{" +
                    "isAbusive=" + isAbusive +
                    ", rating=" + rating +
                    ", amendedReview=" + amendedReview +
                    '}';
        }
    }
}