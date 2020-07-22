package com.softserve.edu.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MentorStudent)) return false;
        MentorStudent that = (MentorStudent) o;
        return Objects.equals(mentortName, that.mentortName) &&
                Objects.equals(studentNames, that.studentNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentortName, studentNames);
    }
}
