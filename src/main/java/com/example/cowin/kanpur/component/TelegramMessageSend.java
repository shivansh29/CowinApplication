package com.example.cowin.kanpur.component;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Component
public class TelegramMessageSend extends TelegramLongPollingBot {
	
	SendMessage sendMessage= new SendMessage();

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		
	}
	
	public void sendMessageShivanshBot(LinkedHashMap map) {
		sendMessage.setChatId("your chat Id here");
		String text=map.get("name")+" \n Age Limit:  "+map.get("min_age_limit")+"\n vaccine: "+map.get("vaccine")
		+"\n  date: "+map.get("date")+
		"\n Total Dose:  "+map.get("available_capacity")+
		"\n Fee Type: "+map.get("fee")+
		"\n dose 1 :  "+map.get("available_capacity_dose1")+
		"\n dose 2: "+map.get("available_capacity_dose2")
			+" Link: https://www.cowin.gov.in/home";
		
		sendMessage.setText(text);
		
		
		try {
			execute(sendMessage);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "your bot name here";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "your token here";
	}

}
