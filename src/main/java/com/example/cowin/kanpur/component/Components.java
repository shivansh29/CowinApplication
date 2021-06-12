package com.example.cowin.kanpur.component;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.cowin.kanpur.dto.SessionDTO;
import com.example.cowin.kanpur.dto.Sessions;

@Component
public class Components {
	
	private final RestTemplate restTemplate;
	private final MailSend mailSend;
	private HttpHeaders  httpHeader;
	private static final String url="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict";
	private HashSet<Object> set=new HashSet<>();
	private final TelegramMessageSend messageSend;
	
	@Autowired
	public Components(RestTemplateBuilder restTemplate,MailSend mailSend,TelegramMessageSend messageSend) {
		super();
		this.restTemplate = restTemplate.build();
		this.mailSend=mailSend;
		this.messageSend=messageSend;
	}


	@Scheduled(fixedDelay = 10000)
	public void pincodeApi() {
		System.out.println("interval");
		
		
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("district_id", "664")
                .queryParam("date", "07-06-2021");
        
        
        HttpEntity entity = new HttpEntity(headers);
		
		ResponseEntity<Object> response=restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Object.class);
		
		
		
		
		LinkedHashMap sess=(LinkedHashMap)response.getBody();
		ArrayList<LinkedHashMap> temp=(ArrayList<LinkedHashMap>)sess.get("sessions");
		System.out.println("-------------------------------------");
		for(LinkedHashMap centres:temp) {
			if(!set.contains(centres.get("center_id"))) {
				System.out.println("kanpur");
				System.out.println(centres.get("available_capacity"));
				mailSend.sendMail("reciever mail", centres);
				messageSend.sendMessageShivanshBot(centres);
			}
			set.add(centres.get("center_id"));
		}
		
		
        
	}
	
	//@Scheduled(fixedRate = 10000)
	public void pincodeApiGorakhPur() {
		System.out.println("interval");
		
		
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("pincode", "273013")
                .queryParam("date", "31-05-2021");
        
        
        HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Object> response=restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Object.class);
		
		
		
		
		LinkedHashMap sess=(LinkedHashMap)response.getBody();
		ArrayList<LinkedHashMap> temp=(ArrayList<LinkedHashMap>)sess.get("sessions");
		System.out.println("-------------------------------------");
		for(LinkedHashMap centres:temp) {
			if(!set.contains(centres.get("center_id"))) {
				System.out.println("aqib");
				System.out.println(centres.get("available_capacity"));
				mailSend.sendMail("reciever mail", centres);
			}
			set.add(centres.get("center_id"));
		}
		
		
		System.out.println("-------------------------------------");
		
		
        
	}
}
