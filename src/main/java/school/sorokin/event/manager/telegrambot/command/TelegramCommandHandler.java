package school.sorokin.event.manager.telegrambot.command;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramCommandHandler {

    BotApiMethod<?> processCommand(Message update);

    TelegramCommands getSupportedCommand();
}
