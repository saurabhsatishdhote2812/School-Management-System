package com.sms.schoolmanagementsystem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

public class Syllabus {
    private String grade;
    private String subject;
    private List<Unit> units;

    // Constructors
    public Syllabus() {}
    public Syllabus(String grade, String subject, List<Unit> units) {
        this.grade = grade;
        this.subject = subject;
        this.units = units;
    }

    // Getters and setters
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public List<Unit> getUnits() {
        return units;
    }
    public void setUnits(List<Unit> units) {
        this.units = units;
    }
}
