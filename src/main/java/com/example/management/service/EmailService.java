package com.example.management.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@Slf4j
@AllArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    private static final String EMAIL = "kestutis.julius@gmail.com";

    public void sendEmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(EMAIL);
        simpleMailMessage.setTo(EMAIL);
        simpleMailMessage.setSubject("Email service test");
        simpleMailMessage.setText("please delete this");

        javaMailSender.send(simpleMailMessage);
        log.info("Email was sent!");
    }

    public void sendEmailWithAttachment() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setFrom(EMAIL);
        messageHelper.setTo(EMAIL);
        messageHelper.setSubject("subject with attachment test");
        messageHelper.setText("Message it works");

        File file = new File(PdfService.PDF_FILE_PATH);
        messageHelper.addAttachment("my_pdf" + file.getName(), file);

        javaMailSender.send(message);
        log.info("Email was send - ");

    }
}
