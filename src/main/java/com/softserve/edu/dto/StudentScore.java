package com.softserve.edu.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentScore {
    private String studentName;
    private List<SprintScore> sprintScore;

    public StudentScore(String studentName) {
        this.studentName = studentName;
        this.sprintScore = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public List<SprintScore> getSprintScore() {
        return sprintScore;
    }

    public void addSprintScore(SprintScore newSprintScore){
        sprintScore.add(newSprintScore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentScore)) return false;

        StudentScore that = (StudentScore) o;

        if(!sprintScore.equals(that.sprintScore)) {
            return false;
        }

        return studentName.equals(that.studentName);
    }

    @Override
    public int hashCode() {
        int result = getStudentName().hashCode();
        result = 31 * result + getSprintScore().hashCode();
        return result;
    }
}
