# TelegramBotDemoService
This is to demo how to build a service and serves Telegram bot traffic with Spring Boot Application.

With support of Telegram community, it's super simple and easy to create a service to serve as Telegram bot.

## Step 1: Create a Telegram bot

On your Telegram app, talk to Bot `@BotFather`. Follow the steps to create the bot. Note down two things:
* The bot "username".
* The token

## Step 2: Create a Spring Boot Application

Go to https://start.spring.io/ and follow the steps to create a Spring Boot Application. Download the zip file.

## Step 3: Implement Your Service

1.Add following maven dependencies (version number may subject to change as time goes):

```xml
<dependency>
	<groupId>org.telegram</groupId>
	<artifactId>telegrambots</artifactId>
	<version>4.9</version>
</dependency>
<dependency>
	<groupId>org.telegram</groupId>
	<artifactId>telegrambots-spring-boot-starter</artifactId>
	<version>4.1.2</version>
</dependency>
```

2.In your `@SpringBootApplication` file, add following into your `main()`:
```java
ApiContextInitializer.init();
```

3.Create a class that extends `TelegramLongPollingBot`, for example we can name it `TelegramBot`. Implement the abstract methods in there.

Couple of things to note:
* The `getBotUsername()` method should return the username you noted down in step 1.
* The `getBotToken()` method should return the token you noted down in step 1.
* You need to call `execute()` to send back the message if you want to. See source code for details.
```java
public class TelegramBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(final Update update) {
        // Logic here
    }

    @Override
    public String getBotUsername() {
        return "Your-username";
    }

    @Override
    public String getBotToken() {
        return "Your-token";
    }
}
```

4.Initialize the class as a `@Bean` in Spring.

## Step 5: Enjoy your bot!

Once you launch your Spring Boot Application, you are good to go! You don't have to deploy your application to a cloud server. Local server should work.

In Telegram app, search for your bot name, now you can talk to it!

## How to run the demo service

I `.gitignore`d my application properties file. In order to make the demo project work, you need to create a `application.properties` file under `src/main/resources` directory.
In that file, you need these entries:
```properties
telegram.demo.bot.token=<your-bot-token>
telegram.demo.bot.name=<your-bot-name>
``` 
Replace `<your-bot-token>` with your bot token, `<your-bot-name>` with your bot name.