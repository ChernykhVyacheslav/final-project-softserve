package com.softserve.edu.entity;

public class Solution {
    private int idStudent;
    private int idSprint;
    private int score;

    public Solution(int idStudent, int idSprint, int score) {
        this.idStudent = idStudent;
        this.idSprint = idSprint;
        this.score = score;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public int getIdSprint() {
        return idSprint;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
