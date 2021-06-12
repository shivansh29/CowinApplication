package com.example.cowin.kanpur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.example.cowin.kanpur.component.TelegramMessageSend;

@SpringBootApplication
@EnableScheduling
//@EnableAsync
public class KanpurApplication {
	
	static {
		ApiContextInitializer.init();
	}

	public static void main(String[] args) {
		SpringApplication.run(KanpurApplication.class, args);
		
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TelegramMessageSend());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}
	/*
	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
	    ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
	    threadPoolTaskScheduler.setPoolSize(2);
	    return threadPoolTaskScheduler;
	}*/
	
	
	

}
