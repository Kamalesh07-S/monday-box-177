package com.example.academics.model;

import javax.persistence.*;

@Entity
public class AcademicRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @ManyToOne
    private User student;

    public Long getId() { return id; }
    public String getReason() { return reason; }
    public RequestStatus getStatus() { return status; }
    public User getStudent() { return student; }

    public void setReason(String reason) { this.reason = reason; }
    public void setStatus(RequestStatus status) { this.status = status; }
    public void setStudent(User student) { this.student = student; }
}
