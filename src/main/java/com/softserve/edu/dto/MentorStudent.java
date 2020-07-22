package com.softserve.edu.dto;

import java.util.ArrayList;
import java.util.List;

public class MentorStudent {
    private String mentortName;
    private List<String> studentNames;

    public MentorStudent(String mentortName) {
        this.mentortName = mentortName;
        this.studentNames = new ArrayList<>();
    }

    public String getMentortName() {
        return mentortName;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    public void addStudentName(String studentName) {
        studentNames.add(studentName);
    }

}
