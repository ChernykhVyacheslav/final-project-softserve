package com.softserve.edu.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentScore {
    private String studentName;
    private List<SprintScore> sprintScore;

    public StudentScore(String studentName) {
        this.studentName = studentName;
        this.sprintScore = new ArrayList<SprintScore>();
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
}
