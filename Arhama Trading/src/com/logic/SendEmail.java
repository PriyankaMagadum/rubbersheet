package com.logic;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail 
{
  public int send(String name, String number,String sub,String msg)
	  {  
          //Get properties object    
		  String password, from,to,cc;
		  to="jockey10@gmail.com";
		//  cc="komejwarnayan@gmail.com";
		  password="priyanka@123";
		  from="adamuthepriyankad@gmail.com";
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);  
           msg=msg+"name="+name+" number="+number;
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           //System.out.println("message sent successfully"); 
           return 1;
           } catch (MessagingException e) {
        	 e.printStackTrace();
        	 return 0;  
        	 }
	
	
    }  
    
}