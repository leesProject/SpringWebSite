package com.in.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class MailTest {	
	
	@RequestMapping(value="/mailTest")
	public void mailTest(){
		Properties p = new Properties();
		p.put("mail.smtp.user", "teamproject2usedcellphone@gmail.com"); // Google계정@gmail.com으로 설정
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.password", "LEE1234!");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable","true");
		p.put( "mail.smtp.auth", "true");
		 
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");


		 
		// 위 환경 정보로 "메일 세션"을 만들고 빈 메시지를 만든다		
		
		Session session = Session.getDefaultInstance(p, 
			    new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication() {
			            return new PasswordAuthentication(
			                "teamproject2usedcellphone", "LEE1234!");// Specify the Username and the PassWord
			        }
			});
		MimeMessage msg = new MimeMessage(session);
		 
		try {
		    // 발신자, 수신자, 참조자, 제목, 본문 내용 등을 설정한다
		    msg.setFrom(new InternetAddress("teamproject2usedcellphone@gmail.com", "중고핸드폰 사이트 관리자"));
		    msg.addRecipient(Message.RecipientType.TO, new InternetAddress("niflheim_v@hotmail.com", "김정현님"));
		    msg.setSubject("[새로운 비밀번호 안내]");
		    msg.setContent("안녕하세요 "+""+"님, 새로운 비밀번호 "+""+" 를 발급해드립니다.", "text/html; charset=utf-8");
		 
		    // 메일을 발신한다
		    Transport.send(msg);
		} catch (Exception e) {
			System.out.println("ERROR! "+e);
		    // 적절히 처리
		}
		
		
	}
}
