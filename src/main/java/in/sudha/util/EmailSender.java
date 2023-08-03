package in.sudha.util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	private Logger logger=LoggerFactory.getLogger(EmailSender.class);

	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendMail(String subject,String body,String to,File f) {
		
		try {
			MimeMessage crtmime = mailSender.createMimeMessage();//send email with attachment
	
			MimeMessageHelper helper = new MimeMessageHelper(crtmime, true);//to set the values for sub,body,to
			helper.setSubject(subject);
			helper.setText(body, true);//body containainig html tag? so true else false
	        helper.setTo(to);
	        helper.addAttachment("Plans-Info", f);
			mailSender.send(crtmime);//send 
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}

		return true;
	}
}
