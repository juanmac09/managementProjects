package com.example.projects.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "email_attachments")
public class EmailAttachments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="email_id", nullable=false)
    private Email emailId;

    @Column(name = "file_path",nullable = false)
    private String filePath;



    public EmailAttachments() {}
    public EmailAttachments(Email emailId, String filePath) {
        this.setEmailId(emailId);
        this.setFilePath(filePath);
    }

    // Setters and Getters here...

    public long getId() {
        return this.id;
    }
    public Email getEmailId() {
        return this.emailId;
    }
    public void setEmailId(Email emailId) {
        this.emailId = emailId;
    }
    public String getFilePath() {
        return this.filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
