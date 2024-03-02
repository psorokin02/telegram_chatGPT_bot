package school.sorokin.event.manager.telegrambot.openai.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Choice (
    @JsonProperty("message") Message message
) {}
