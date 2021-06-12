package com.example.cowin.kanpur.component;

import java.util.LinkedHashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class MailSend {

	public void sendMail(String email,LinkedHashMap map) {
		try {
                final String SEmail="your mail here";
                final String SPass="your password here";
                final String REmail=email;
                final String Sub="Vaccination Centre";
                String body="<h3>"+map.get("name")+"</h3><br> Age Limit:  "+map.get("min_age_limit")+"<br> vaccine: "+map.get("vaccine")
                				+"<br> date: "+map.get("date")+
                				"<br> <strong>Total Dose:</strong> "+map.get("available_capacity")+
                				"<br> Fee Type: "+map.get("fee")+
                				"<br> dose 1 :  "+map.get("available_capacity_dose1")+
                				"<br> dose 2: "+map.get("available_capacity_dose2")
                					+"<br> Link: https://www.cowin.gov.in/home";
                //mail send Code
            Properties props=new Properties();
            props.put("mail.smtp.host","smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port","465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.port","465");
            Session ses=Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(SEmail,SPass);
                }
            }
            );
            Message message=new MimeMessage(ses);
            message.setFrom(new InternetAddress(SEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(REmail));
            message.setSubject(Sub);
            message.setHeader("X-Priority", "1");
            message.setHeader("x-msmail-priority", "high");
            message.setContent(body, "text/html");
             
            Transport.send(message);
           
		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}
}
