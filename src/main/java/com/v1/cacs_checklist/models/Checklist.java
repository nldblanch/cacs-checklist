package com.v1.cacs_checklist.models;

import java.util.*;

public class Checklist {
    String checklistId;
    String checklistName;
    boolean submitted;
    boolean assessed;
    String dueDate;
    String submissionDate;
    List<Field> fields;
    String ownerName;
    String ownerEmail;
    String submitterName;
    String submitterEmail;
    String assessorName;
    String assessorEmail;

    public Checklist(String checklistId, String checklistName, boolean submitted, boolean assessed,
                     String dueDate, String submissionDate, List<Field> fields,
                     String ownerName, String ownerEmail, String submitterName, String submitterEmail,
                     String assessorName, String assessorEmail) {
        this.checklistId = checklistId;
        this.checklistName = checklistName;
        this.submitted = submitted;
        this.assessed = assessed;
        this.dueDate = dueDate;
        this.submissionDate = submissionDate;
        this.fields = fields;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.submitterName = submitterName;
        this.submitterEmail = submitterEmail;
        this.assessorName = assessorName;
        this.assessorEmail = assessorEmail;
    }

    public String getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(String checklistId) {
        this.checklistId = checklistId;
    }

    public String getChecklistName() {
        return checklistName;
    }

    public void setChecklistName(String checklistName) {
        this.checklistName = checklistName;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public boolean isAssessed() {
        return assessed;
    }

    public void setAssessed(boolean assessed) {
        this.assessed = assessed;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

    public String getSubmitterEmail() {
        return submitterEmail;
    }

    public void setSubmitterEmail(String submitterEmail) {
        this.submitterEmail = submitterEmail;
    }

    public String getAssessorName() {
        return assessorName;
    }

    public void setAssessorName(String assessorName) {
        this.assessorName = assessorName;
    }

    public String getAssessorEmail() {
        return assessorEmail;
    }

    public void setAssessorEmail(String assessorEmail) {
        this.assessorEmail = assessorEmail;
    }
}