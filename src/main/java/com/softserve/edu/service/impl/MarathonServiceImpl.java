package com.softserve.edu.service.impl;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarathonServiceImpl implements MarathonService {

    private DataService dataService;

    @Autowired
    public MarathonServiceImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public List<String> getStudents() {
        return dataService.getStudents().stream()
                    .map(Entity::getName)
                    .collect(Collectors.toList());
    }

    public List<String> getMentors() {
        return dataService.getMentors().stream()
                .map(Entity::getName)
                .collect(Collectors.toList());
    }

    public StudentScore studentResult(String studentName) {
        int studentId = dataService.getStudentId(studentName);
        StudentScore studentScore = new StudentScore(studentName);
        dataService.getSolutions().stream()
                .filter(item -> item.getIdStudent()==studentId)
                .forEach(item -> {
                    studentScore.addSprintScore(
                        new SprintScore(dataService.getSprintNameById(item.getIdSprint()),
                                        item.getScore()));
                });
        return studentScore;
    }

    public List<StudentScore> allStudentsResult() {
        return dataService.getStudents().stream()
                .map(st -> studentResult(st.getName()))
                .collect(Collectors.toList());
    }

    public AverageScore studentAverage(String studentName) {
        StudentScore studentScore = studentResult(studentName);
        double avg = studentScore.getSprintScore().stream()
                .map(SprintScore::getScore)
                .collect(Collectors.summarizingInt(Integer::intValue)).getAverage();
        return new AverageScore(studentName, avg);
    }

    public List<AverageScore> allStudentsAverage() {
        return dataService.getStudents().stream()
                .map(st -> studentAverage(st.getName()))
                .collect(Collectors.toList());
    }

    public MentorStudent mentorStudents(String mentorName) {
        int mentorId = dataService.getMentorId(mentorName);
        MentorStudent result = new MentorStudent(mentorName);
        dataService.getCommunications().stream()
                .filter(item -> item.getIdMentor() == mentorId)
                .forEach(item -> {
                    result.addStudentName(
                            dataService.getStudentNameById(item.getIdStudent()));
                });
        return result;
    }
}
