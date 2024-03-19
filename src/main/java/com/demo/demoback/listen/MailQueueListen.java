package com.demo.demoback.listen;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author LHF
 * @Date 2024:03:19:21:29
 **/
@Component
@RabbitListener(queues = "mail")
public class MailQueueListen {

    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String username;

    @RabbitHandler
    public void sendMailMessage(Map<String, Object> data) {
        String email = (String) data.get("email");
        Integer code = (Integer) data.get("code");
        String type = (String) data.get("type");
        SimpleMailMessage message = switch (type) {
            case "register" ->
                createMessage("欢迎注册我们的网站", "您的邮箱注册验证码为: " + code + "，有效时间为3分钟，为保障您的安全，请勿向他人泄露验证码信息", email);
            case "reset" -> createMessage("你的密码重置邮件",
                    "你好，您正在进行重置密码操作，验证码: " + code + "，有效时间为3分钟，如非本人操作，请无视。", email);
            default -> null;
        };
        if (message == null) return;
        sender.send(message);
    }

    private SimpleMailMessage createMessage(String title, String content, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(title);
        message.setText(content);
        message.setTo(email);
        message.setFrom(username);
        return message;
    }
}
