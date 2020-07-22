package com.softserve.edu.service;

import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;

import java.util.List;

public interface DataService {

    public void addStudent(String studentName);

    public void addMentor(String mentorName);

    public void addSprint(String sprintName);

    public void addCommunication(String studentName, String mentorName);
    
    public void addSolution(String studentName, String sprintName, int score);

    public List<Entity> getStudents();

    public List<Entity> getMentors();

    public List<Solution> getSolutions();

    public List<Communication> getCommunications();

    public List<Entity> getSprints();

    public String getSprintById(int sprintId);

    public int getStudentId(String studentName);

    public int getMentorId(String mentorName);

    public int getSprintId(String sprintName);

    public List<Communication> getCommunication();

    public List<Solution> getSolution();
}
