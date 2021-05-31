package com.example.management.controller;


import com.example.management.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/")
    public void sendEmail() {
        emailService.sendEmail();
    }

    @PostMapping("/attachment")
    public void sendEmailWithAttachment() throws MessagingException {
     emailService.sendEmailWithAttachment();
    }

}
