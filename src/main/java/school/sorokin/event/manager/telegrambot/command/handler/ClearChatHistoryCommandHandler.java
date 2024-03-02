package school.sorokin.event.manager.telegrambot.command.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import school.sorokin.event.manager.telegrambot.command.TelegramCommandHandler;
import school.sorokin.event.manager.telegrambot.command.TelegramCommands;
import school.sorokin.event.manager.telegrambot.openai.ChatGptHistoryService;

@Component
@AllArgsConstructor
public class ClearChatHistoryCommandHandler implements TelegramCommandHandler {

    private final ChatGptHistoryService chatGptHistoryService;

    private final String CLEAR_HISTORY_MESSAGE = "Ваша история была очищена";

    @Override
    public BotApiMethod<?> processCommand(Message message) {
        chatGptHistoryService.clearHistory(message.getChatId());
        return SendMessage.builder()
                .chatId(message.getChatId())
                .text(CLEAR_HISTORY_MESSAGE)
                .build();
    }

    @Override
    public TelegramCommands getSupportedCommand() {
        return TelegramCommands.CLEAR_COMMAND;
    }
}
