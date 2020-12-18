package net.lilifei.telegrambotdemo.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {

    private final String username;

    private final String token;

    public TelegramBot(final String username, final String token) {
        this.username = username;
        this.token = token;
    }

    @Override
    public void onUpdateReceived(final Update update) {
        if (update.hasMessage()) {
            final Message message = update.getMessage();
            final SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            final String responseText = String.format("We have received your message. " +
                            "The message is %s. " +
                            "Your user ID is %d.",
                    message.getText(),
                    message.getFrom().getId());
            sendMessage.setText(responseText);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
