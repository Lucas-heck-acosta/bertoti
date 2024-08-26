import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class BotTop implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    private final DBManager databaseManager;

    public BotTop(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
        String currentDir = System.getProperty("user.dir");
        databaseManager = new DBManager(currentDir + "/library.db");
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/books")) {
                String booksList = databaseManager.getBooks();
                sendResponse(chatId, booksList);
            } else if (messageText.startsWith("/addbook")) {
                // Command format: /addbook title,author,year
                String[] parts = messageText.split(",", 3);
                if (parts.length == 3) {
                    try {
                        String title = parts[0].replace("/addbook ", "").trim();
                        String author = parts[1].trim();
                        int year = Integer.parseInt(parts[2].trim());
                        databaseManager.addBook(title, author, year);
                        sendResponse(chatId, "Book added: " + title);
                    } catch (NumberFormatException e) {
                        sendResponse(chatId, "Invalid year format.");
                    }
                } else {
                    sendResponse(chatId, "Usage: /addbook title,author,year");
                }
            } else {
                sendResponse(chatId, messageText);
            }
        }
    }

    private void sendResponse(long chatId, String text) {
        SendMessage message = SendMessage.builder()
                .chatId(chatId)
                .text(text)
                .build();
        try {
            telegramClient.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
