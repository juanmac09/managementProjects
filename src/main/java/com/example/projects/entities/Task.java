package com.example.projects.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title",nullable = false)

    private String title;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "due_date",nullable = false)
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name="project_id",nullable = false)
    private Project projectId;

    @ManyToOne
    @JoinColumn(name="assigned_to",nullable = false)
    private User assignedTo;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public Task() {}
    public Task(String title, String description, String status, Date dueDate, Project projectId,User assignedTo) {
        this.setTitle(title);
        this.setDescription(description);
        this.setStatus(status);
        this.setDueDate(dueDate);
        this.setProjectId(projectId);
        this.setAssignedTo(assignedTo);
    }

    // Setters and Getters here...
    public long getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public Date getDueDate(){
        return this.dueDate;
    }
    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }
    public Project getProjectId(){
        return this.projectId;
    }
    public void setProjectId(Project projectId){
        this.projectId = projectId;
    }
    public User getAssignedTo(){
        return this.assignedTo;
    }
    public void setAssignedTo(User assignedTo){
        this.assignedTo = assignedTo;
    }

}
