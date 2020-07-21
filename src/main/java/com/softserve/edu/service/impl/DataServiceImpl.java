package com.softserve.edu.service.impl;

import java.util.List;

import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import com.softserve.edu.service.DataService;

public class DataServiceImpl implements DataService {
    private List<Entity> students;
    private List<Entity> mentors;
    private List<Entity> sprints;
    private List<Communication> communication;
    private List<Solution> solution;

    public void addStudent(String studentName) {
        // TODO for students
    }

    public void addMentor(String mentorName) {
        // TODO for mentors
    }

    public void addSprint(String sprintName) {
        // TODO for sprints
    }

    public void addCommunication(String studentName, String mentorName) {
        // TODO for communication
    }

    public void addSolution(String studentName, String sprintName, int score) {
        // TODO for solution
    }
    
    // getters
    
    // TODO
}
