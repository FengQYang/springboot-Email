package com.fqy;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void test01() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚去嗨皮！");
        message.setText("今晚9:00出发");
        message.setTo("h1468416647@163.com");
        message.setFrom("1468416647@qq.com");

        mailSender.send(message);
    }

    @Test
    public void test02() throws MessagingException {

        //1.创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("通知-今晚去嗨皮！");
        helper.setText("<b style='color:red'>今晚10:00出发</b>",true);
        helper.setTo("h1468416647@163.com");
        helper.setFrom("1468416647@qq.com");

        //上传文件
        helper.addAttachment("1.jpg",new File("C:\\Users\\86187\\Pictures\\Camera Roll\\1.jpg"));
        helper.addAttachment("2.png",new File("C:\\Users\\86187\\Pictures\\Camera Roll\\2.png"));

        mailSender.send(mimeMessage);
    }

}
