package com.softserve.edu.dto;

public class SprintScore {
    private String sprintName;
    private int score;

    public SprintScore(String sprintName, int score) {
        this.sprintName = sprintName;
        this.score = score;
    }

    public String getSprintName() {
        return sprintName;
    }

    public int getScore() {
        return score;
    }
}
