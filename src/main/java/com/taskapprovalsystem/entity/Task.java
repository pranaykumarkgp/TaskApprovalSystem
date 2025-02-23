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


}