package com.icici.forex.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailSSLWithAttachment {

	public void SendReport(String path, String emailto) throws IOException {
		
		  final String username = "ban428735@ext.icicibank.com"; // Your Outlook 365 email address

          final String password = "QKquality@1101"; // Your Outlook 365 password or app-specific password



          Properties props = new Properties();

          props.put("mail.smtp.auth", "true");

          props.put("mail.smtp.starttls.enable", "true");

          props.put("mail.smtp.ssl.trust", "*");

          props.put("mail.smtp.host", "smtp.office365.com");

          props.put("mail.smtp.port", "587");

          // This will handle the complete authentication

//          Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//
//                 protected PasswordAuthentication getPasswordAuthentication() {
//
//                       System.out.println("Authenticating");
//
//                       return new PasswordAuthentication(username, password);
//
//                 }
//
//          });

          Session session = Session.getDefaultInstance(props);
          session.setDebug(true);

          try {



                 Message message = new MimeMessage(session);

                 message.setFrom(new InternetAddress(username));

                 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailto));

                 message.setSubject("API Execution report");

                 MimeMultipart mimeMultiPart = new MimeMultipart();

                 MimeBodyPart textMime = new MimeBodyPart();

                 MimeBodyPart fileMime = new MimeBodyPart();

                 textMime.setText("Find the attached execution report for API testing");



//                 File file = new File(path);
//
//                 fileMime.attachFile(file);

                 /*

                 * BodyPart messageBodyPart1 = new MimeBodyPart();

                 * messageBodyPart1.setText("Find the attached execution report for API testing"

                 * );

                 *

                  * MimeBodyPart messageBodyPart2 = new MimeBodyPart();

                 *

                  * System.out.println(path); String filename=path;

                 *

                  * DataSource source = new FileDataSource(filename);

                 * messageBodyPart2.setDataHandler(new DataHandler(source));

                 * messageBodyPart2.setFileName(filename);

                 *

                  * Multipart multipart = new MimeMultipart();

                 * multipart.addBodyPart(messageBodyPart2);

                 * multipart.addBodyPart(messageBodyPart1);

                 */

                 mimeMultiPart.addBodyPart(textMime);

                 mimeMultiPart.addBodyPart(fileMime);



                 message.setContent(mimeMultiPart, "text/html");



                 Transport.send(message);



                 System.out.println("=====Email Sent=====");



          } catch (MessagingException e) {



                 throw new RuntimeException(e);



          }
//	public static void SendReport(String path, String emailto) throws IOException {
//		final String username = "shiv.babu@ext.icicibank.com"; // Your Outlook 365 email address
//		final String password = "QKquality@110"; // Your Outlook 365 password or app-specific password
//
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.ssl.trust", "*");
//		props.put("mail.smtp.host", "smtp.office365.com");
//		props.put("mail.smtp.port", "587");
//		// This will handle the complete authentication
//		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				System.out.println("Authenticating");
//				return new PasswordAuthentication(username, password);
//			}
//		});
//
//		try {
//
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(username));
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailto));
//			message.setSubject("API Execution report");
//			MimeMultipart mimeMultiPart = new MimeMultipart();
//			MimeBodyPart textMime = new MimeBodyPart();
//			MimeBodyPart fileMime = new MimeBodyPart();
//			textMime.setText("Find the attached execution report for API testing");
//
//			File file = new File(path);
//			fileMime.attachFile(file);
//			/*
//			 * BodyPart messageBodyPart1 = new MimeBodyPart();
//			 * messageBodyPart1.setText("Find the attached execution report for API testing"
//			 * );
//			 * 
//			 * MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//			 * 
//			 * System.out.println(path); String filename=path;
//			 * 
//			 * DataSource source = new FileDataSource(filename);
//			 * messageBodyPart2.setDataHandler(new DataHandler(source));
//			 * messageBodyPart2.setFileName(filename);
//			 * 
//			 * Multipart multipart = new MimeMultipart();
//			 * multipart.addBodyPart(messageBodyPart2);
//			 * multipart.addBodyPart(messageBodyPart1);
//			 */
//			mimeMultiPart.addBodyPart(textMime);
//			mimeMultiPart.addBodyPart(fileMime);
//
//			message.setContent(mimeMultiPart, "text/html");
//
//			Transport.send(message);
//
//			System.out.println("=====Email Sent=====");
//
//		} catch (MessagingException e) {
//
//			throw new RuntimeException(e);
//
//		}
	}

}