package com.crud.tasks.service;

import com.crud.tasks.domain.EmailTemplate;
import com.crud.tasks.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RunWith(MockitoJUnitRunner.class)
public class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        // Given
        Mail mail = new Mail("test@test.com",  "Test", "Test message", EmailTemplate.TEXT_ONLY);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        if (mail.getToCc() != null) {
            mailMessage.setCc(mail.getToCc());
        }
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());

        // When
        simpleEmailService.send(mail);

        // Then
        Mockito.verify(javaMailSender, Mockito.times(1)).send(mailMessage);
    }
}