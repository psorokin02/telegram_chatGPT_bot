package school.sorokin.event.manager.telegrambot.command.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import school.sorokin.event.manager.telegrambot.command.TelegramCommandHandler;
import school.sorokin.event.manager.telegrambot.command.TelegramCommands;

@Component
public class StartCommandHandler implements TelegramCommandHandler {

    private final String HELLO_MESSAGE = """
            Привет %s,
            Этим ботом ты можешь пользоваться для общения с GPT
            Каждое сообщение запоминается для контекста
            Очистить контекст можно с помощью команды /clear
            """;

    @Override
    public BotApiMethod<?> processCommand(Message message) {
        return SendMessage.builder()
                .chatId(message.getChatId())
                .text(HELLO_MESSAGE.formatted(
                        message.getChat().getFirstName()
                ))
                .build();
    }

    @Override
    public TelegramCommands getSupportedCommand() {
        return TelegramCommands.START_COMMAND;
    }
}
