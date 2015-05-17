package com.example.moskva.bussine;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.example.moskva.model.Bill;
import com.example.moskva.model.User;



/**
 *@version 1.0 May 14, 2015.
 *@author Moscow209
 */
public class SendMail {
	private static final String USER_NAME = "moskva209@gmail.com";
	private static final String PASSWORD = "Thienduong123@";
	
	public static void sendPassword(String email, User user){
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER_NAME, PASSWORD);
			}
		  });
 
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("fashion-nicole@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Forgot password?");
			message.setText("Username: " + user.getUserName()
				+ "\n\nPassword: " + user.getPassword());
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void sendBill(String email, Bill bill){
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER_NAME, PASSWORD);
			}
		  });
 
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("fashion-nicole@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Bill");
			String mess = "Code Bill: " + bill.getId()
					+ "\n\nDate Bill: " + bill.getDate()
					+ "\n\nName Ship: " + bill.getName()
					+ "\n\nAddress: " + bill.getAddress()
					+ "\n\nPhone: " + bill.getPhone()
					+ "\n\nTotal: " + bill.getTotal() + "VND"
					+ "\n\nThank you buy at fashion!";
			message.setContent(mess, "text/plain; charset=UTF-8");
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
