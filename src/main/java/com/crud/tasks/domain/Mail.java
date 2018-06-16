package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Mail {
    private String mailTo;
    private String toCc;
    private String subject;
    private String message;
    private EmailTemplate emailTemplate;

    public Mail(String mailTo, String subject, String message, EmailTemplate emailTemplate) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
        this.emailTemplate = emailTemplate;
    }
}
