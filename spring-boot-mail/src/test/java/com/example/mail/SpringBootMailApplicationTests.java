package com.example.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMailApplicationTests {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine templateEngine;

	@Test
	public void sendSimpleMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("496926024@qq.com");
		message.setTo("wyb496926024@gmail.com");
		message.setSubject("topic：simple mail");
		message.setText("test context");
		mailSender.send(message);
	}

	@Test
	public void sendAttachmentsMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("496926024@qq.com");
		helper.setTo("wyb496926024@gmail.com");
		helper.setSubject("主题：附件邮件");
		helper.setText("这是一个有附件的邮件");

		FileSystemResource file = new FileSystemResource(new File("/Users/wyb/Github/spring-boot-learning/spring-boot-mail/src/main/resources/static/photo-1.jpg"));
		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);
		mailSender.send(mimeMessage);
	}

	@Test
	public void sendInlineMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("496926024@qq.com");
		helper.setTo("wyb496926024@gmail.com");
		helper.setSubject("主题：嵌入静态资源");
		helper.setText("<html><body><img src=\"cid:photo\" ></body></html>", true);

		FileSystemResource file = new FileSystemResource(new File("/Users/wyb/Github/spring-boot-learning/spring-boot-mail/src/main/resources/static/photo-1.jpg"));
		helper.addInline("photo", file);
		mailSender.send(mimeMessage);
	}

	@Test
	public void sendTemplateMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		//创建邮件正文
		Context context = new Context();
		context.setVariable("id", "006");
		String template = templateEngine.process("template", context);

		//true表示需要创建一个multipart message
		helper.setFrom("496926024@qq.com");
		helper.setTo("wyb496926024@gmail.com");
		helper.setSubject("主题：这是模板邮件");
		helper.setText(template, true);

		mailSender.send(mimeMessage);
	}

}
