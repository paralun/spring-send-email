package com.paralun.app.controller;

import com.paralun.app.domain.MailObject;
import com.paralun.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private SimpleMailMessage template;

    @Value("${attachment.file}")
    private String attachmentPath;

    @PostMapping("/send")
    public EmailResponse sendMail(@RequestBody MailObject mailObject) {
        emailService.sendSimpleMessage(mailObject.getTo(), mailObject.getSubject(), mailObject.getText());
        return new EmailResponse("Sukses", false);
    }

    @PostMapping("/sendTemplate")
    public EmailResponse sendMailWithTemplate(@RequestBody MailObject mailObject) {
        emailService.sendSimpleMessageUsingTemplate(mailObject.getTo(), mailObject.getSubject(), template, mailObject.getText());
        return new EmailResponse("Sukses", false);
    }

    @PostMapping("/sendAttachment")
    public EmailResponse sendMailWithAttachment(@RequestBody MailObject mailObject) {
        emailService.sendMessageWithAttachment(mailObject.getTo(), mailObject.getSubject(), mailObject.getText(), attachmentPath);
        return new EmailResponse("Sukses", false);
    }
}
