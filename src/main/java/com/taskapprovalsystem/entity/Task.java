package com.taskapprovalsystem.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;
    private String creatorEmail;

    @ElementCollection
    private Set<String> approvals = new HashSet<>();

    public boolean addApproval(String approver) {
        if (approvals.contains(approver)) {
            return false;
        }
        approvals.add(approver);
        return true;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<String> getApprovals() {
        return approvals;
    }


    public String getCreatorEmail() {
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setApprovals(Set<String> approvals) {
        this.approvals = approvals;
    }
}