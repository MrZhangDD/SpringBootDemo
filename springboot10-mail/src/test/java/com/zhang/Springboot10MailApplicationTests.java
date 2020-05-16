package com.zhang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot10MailApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Test
    void contextLoads() {
        //简单的邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("springboot主题");
        simpleMailMessage.setText("好好学习，天天向上");
        simpleMailMessage.setFrom("17633908117@163.com");
        simpleMailMessage.setTo("17633908117@163.com");
        javaMailSender.send(simpleMailMessage);
    }
    @Test
    void testMail() throws MessagingException {
        //复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"utf-8");
        helper.setSubject("springboot主题");
        helper.setText("<h1 style='color:red'>好好学习，天天向上</h1>",true);
        helper.addAttachment("1.jpg", new File("C:\\Users\\DELL\\Desktop\\1.jpg"));
        helper.setFrom("17633908117@163.com");
        helper.setTo("17633908117@163.com");
        javaMailSender.send(mimeMessage);

    }

}
