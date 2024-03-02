package school.sorokin.event.manager.telegrambot.openai;

import lombok.Builder;
import school.sorokin.event.manager.telegrambot.openai.api.Message;

import java.util.List;

@Builder
public record ChatHistory(
        List<Message> chatMessages
) {
}
