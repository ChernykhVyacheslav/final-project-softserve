package com.softserve.edu.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SprintScore)) return false;

        SprintScore that = (SprintScore) o;

        return score == that.score &&
                Objects.equals(sprintName, that.sprintName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sprintName, score);
    }
}
