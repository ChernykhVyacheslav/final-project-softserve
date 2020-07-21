package com.softserve.edu.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.edu.dto.AverageScore;
import com.softserve.edu.dto.MentorStudent;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;

@Service
public class MarathonServiceImpl implements MarathonService {

    private DataService dataService;

    @Autowired
    public MarathonServiceImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public List<String> getStudents() {
        return dataService.getStudents().stream()
                    .map(item -> item.getName())
                    .collect(Collectors.toList());
    }

    public List<String> getMentors() {
        return dataService.getMentors().stream()
                .map(item -> item.getName())
                .collect(Collectors.toList());
    }

    public StudentScore studentResult(String studentName) {
        // TODO
        return null;
    }

    public List<StudentScore> allStudentsResult() {
        // TODO
        return null;
    }

    public AverageScore studentAverage(String studentName) {
        // TODO
        return null;
    }

    public List<AverageScore> allStudentsAverage() {
        // TODO
        return null;
    }

    public MentorStudent mentorStudents(String mentorName) {
        // TODO
        return null;
    }
}
