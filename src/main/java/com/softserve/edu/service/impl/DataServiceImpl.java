package com.softserve.edu.service.impl;

import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import com.softserve.edu.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    private List<Entity> students;
    private List<Entity> mentors;
    private List<Entity> sprints;
    private List<Communication> communication;
    private List<Solution> solution;

    @Autowired
    public DataServiceImpl() {
        this.students = new ArrayList<>();
        this.mentors = new ArrayList<>();
        this.sprints = new ArrayList<>();
        this.communication = new ArrayList<>();
        this.solution = new ArrayList<>();
    }

    public void addStudent(String studentName) {
        students.add(new Entity(studentName));
    }

    public void addMentor(String mentorName) {
        mentors.add(new Entity(mentorName));
    }

    public void addSprint(String sprintName) {
        sprints.add(new Entity(sprintName));
    }

    public void addCommunication(String studentName, String mentorName) {
        communication.add(new Communication(getStudentId(studentName),
                                            getMentorId(mentorName)));
    }

    public void addSolution(String studentName, String sprintName, int score) {
        solution.add(new Solution(  getStudentId(studentName),
                                    getSprintId(sprintName),
                                    score));
    }

    private Entity getEntityByName(List<Entity> entityList, String name) {
        for (Entity entity : entityList) {
            if(entity.getName().equals(name)) {
                return entity;
            }
        }
        return null;
    }
    
    private int getEntityId(List<Entity> entityList, String name) {
        Entity entity = getEntityByName(entityList, name);
        if(entity == null) {
            return -1;
        }
        return entity.getId();
    }

    public List<Entity> getStudents() {
        return students;
    }

    public List<Entity> getMentors() {
        return mentors;
    }

    public List<Entity> getSprints() {
        return sprints;
    }

    public List<Communication> getCommunication() {
        return communication;
    }

    public List<Solution> getSolution() {
        return solution;
    }

    public int getStudentId(String studentName){
        return getEntityId(students, studentName);
    }

    public int getMentorId(String mentorName){
        return getEntityId(mentors, mentorName);
    }

    public int getSprintId(String sprintName){
        return getEntityId(sprints, sprintName);
    }

}
