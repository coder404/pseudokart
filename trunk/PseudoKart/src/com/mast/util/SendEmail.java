package com.mast.util;

import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger; 

import com.opensymphony.xwork2.ActionContext;

public class SendEmail {
	private static final Logger logger = Logger.getLogger(SendEmail.class); 

	final String username = "com.iiitb.pseudokart@gmail.com";
	final String password = "kart@123";

	//flag = 0 for New User; flag = 1 for Forgot Password;
	public void Mail(String uemail, int flag) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
	
		/*Get a new Session Object */
		
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	
		try {
	
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("com.iiitb.pseudokart@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(uemail));
			
			if(flag==1) { //Forgot Password Message
				message.setSubject("Message from Flipkart: Password Recovery");
				message.setText("Dear Customer,"
						+ "\n\n Please click the following link to change your password: " + "http://192.168.12.152:8080/PseudoKart/recoveryLink.action?email=" 
						+ uemail + ".\n\nWarm Regards,\nFlipkart Customer Support Team");
			}
			else if(flag==0) { //New User Welcome Message
				message.setSubject("Greetings from Flipkart!");
				message.setText("Dear Customer,"
						+ "\n\n Welcome to Flipkart! Use the following user id to log in to your account\n"
						+ "Email ID: " + uemail
						+ "\nYou can log in from the following link: "
						+ "http://192.168.12.152:8080/PseudoKart/loginPage.action" 
						+ ".\n\nWarm Regards,\nFlipkart");
			}
			else if(flag==2) { //E-Gift Voucher
				String num, pin;
				num = (ActionContext.getContext().getSession().get("vouchernum")).toString();
				pin = (ActionContext.getContext().getSession().get("voucherpin")).toString();
				System.out.println("Inside SendEmail: num, pin - " + num + ", " + pin);
				message.setSubject("Greetings from Flipkart!");
				message.setText("Dear Customer,"
						+ "\n\n You have received a Gift Voucher from "
						+ (String)ActionContext.getContext().getSession().get("email")
						+ ".\nThe following are the voucher details: \n"
						+ "Number: " + num
						+ "\nPin: " + pin
						+ "\nHappy Shopping!!"
						+ "\n\nWarm Regards,\nFlipkart");
			}
			Transport.send(message);
			logger.debug("Done");
	
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
}
}