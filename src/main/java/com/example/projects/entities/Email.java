package com.example.projects.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "to_address",nullable = false)
    private String toAddress;

    @Column(name = "subject",nullable = false)
    private String subject;

    @Column(name = "body",nullable = false)
    private String body;

    @CreationTimestamp
    @Column(name = "sent_at", updatable = false )
    private Date sentAt;

    @OneToMany(mappedBy = "emailId")
    private List<EmailAttachments> emailAttachments;

    public Email() {}
    public Email(String toAddress, String subject, String body) {
        this.setToAddress(toAddress);
        this.setSubject(subject);
        this.setBody(body);
    }

    // Setters and Getters here...

    public long getId() {
        return this.id;
    }

    public String getToAddress() {
        return this.toAddress;
    }
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return this.subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return this.body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public Date getSentAt() {
        return this.sentAt;
    }

    public List<EmailAttachments> getEmailAttachments() {
        return this.emailAttachments;
    }
    public void setEmailAttachments(List<EmailAttachments> emailAttachments) {
        this.emailAttachments = emailAttachments;
    }
    public void addEmailAttachment(EmailAttachments emailAttachment) {
        if (this.emailAttachments == null){
            this.emailAttachments = new ArrayList<>();
        }
        this.emailAttachments.add(emailAttachment);
    }
}
