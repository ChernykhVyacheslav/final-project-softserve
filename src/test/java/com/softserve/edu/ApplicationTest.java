package com.softserve.edu;

import com.softserve.edu.controller.MarathonController;
import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Solution;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;
import com.softserve.edu.service.impl.DataServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTest {
    
    @Autowired
    private MarathonService marathonService;
    
    @Autowired
    private DataService dataService;

    @Autowired
    private MarathonController controller;

    @Autowired
    public ApplicationTest(MarathonService marathonService) {
        this.marathonService = marathonService;
        fillDataService();
    }
    
    private void fillDataService() {
        dataService = new DataServiceImpl();

        dataService.addMentor("Mentor1");
        dataService.addMentor("Mentor2");

        dataService.addStudent("Student1");
        dataService.addStudent("Student2");
        dataService.addStudent("Student3");
        dataService.addStudent("Student4");
        dataService.addStudent("Student5");

        dataService.addSprint("Sprint1");
        dataService.addSprint("Sprint2");
        dataService.addSprint("Sprint3");
        dataService.addSprint("Sprint4");
        dataService.addSprint("Sprint5");

        dataService.addCommunication("Mentor1", "Student1");
        dataService.addCommunication("Mentor1", "Student3");
        dataService.addCommunication("Mentor1", "Student4");
        dataService.addCommunication("Mentor1", "Student5");

        dataService.addCommunication("Mentor2", "Student1");
        dataService.addCommunication("Mentor2", "Student2");
        dataService.addCommunication("Mentor2", "Student4");

        dataService.addSolution("Student1", "Sprint1", 80);
        dataService.addSolution("Student1", "Sprint2", 75);
        dataService.addSolution("Student1", "Sprint3", 90);
        dataService.addSolution("Student1", "Sprint4", 100);
        dataService.addSolution("Student1", "Sprint5", 60);

        dataService.addSolution("Student2", "Sprint1", 60);
        dataService.addSolution("Student2", "Sprint2", 75);
        dataService.addSolution("Student2", "Sprint3", 85);
        dataService.addSolution("Student2", "Sprint4", 80);
        dataService.addSolution("Student2", "Sprint5", 70);
    }
    
    @Test
    public void checkGetStudents() {
        List<String> expected = new ArrayList<String>() {{
            add("Student1");
            add("Student2");
            add("Student3");
            add("Student4");
            add("Student5");
        }};
        List<String> actual = marathonService.getStudents();
        Assertions.assertEquals(expected, actual, "checkGetStudents()");
    }

    @Test
    public void checkGetMentors() {
        List<String> expected = new ArrayList<String>() {{
            add("Mentor1");
            add("Mentor2");
        }};
        List<String> actual = marathonService.getMentors();
        Assertions.assertEquals(expected, actual, "checkGetMentors()");
    }

    @Test
    public void checkGetCommunications() {
        List<Communication> expected = new ArrayList<Communication>() {{
            add(new Communication(dataService.getMentorId("Mentor1"), dataService.getStudentId("Student1")));
            add(new Communication(dataService.getMentorId("Mentor1"), dataService.getStudentId("Student3")));
            add(new Communication(dataService.getMentorId("Mentor1"), dataService.getStudentId("Student4")));
            add(new Communication(dataService.getMentorId("Mentor1"), dataService.getStudentId("Student5")));

            add(new Communication(dataService.getMentorId("Mentor2"), dataService.getStudentId("Student1")));
            add(new Communication(dataService.getMentorId("Mentor2"), dataService.getStudentId("Student2")));
            add(new Communication(dataService.getMentorId("Mentor2"), dataService.getStudentId("Student4")));
        }};
        List<Communication> actual = dataService.getCommunications();
        Assertions.assertEquals(expected, actual, "checkGetCommunications()");
    }

    @Test
    public void checkGetSolutions() {
        List<Solution> expected = new ArrayList<Solution>() {{
            add(new Solution(dataService.getStudentId("Student1"), dataService.getSprintId("Sprint1"), 80));
            add(new Solution(dataService.getStudentId("Student1"), dataService.getSprintId("Sprint2"), 75));
            add(new Solution(dataService.getStudentId("Student1"), dataService.getSprintId("Sprint1"), 90));
            add(new Solution(dataService.getStudentId("Student1"), dataService.getSprintId("Sprint1"), 100));
            add(new Solution(dataService.getStudentId("Student1"), dataService.getSprintId("Sprint1"), 60));

            add(new Solution(dataService.getStudentId("Student2"), dataService.getSprintId("Sprint1"), 60));
            add(new Solution(dataService.getStudentId("Student2"), dataService.getSprintId("Sprint2"), 75));
            add(new Solution(dataService.getStudentId("Student2"), dataService.getSprintId("Sprint3"), 85));
            add(new Solution(dataService.getStudentId("Student2"), dataService.getSprintId("Sprint4"), 80));
            add(new Solution(dataService.getStudentId("Student2"), dataService.getSprintId("Sprint5"), 70));
        }};
        List<Solution> actual = dataService.getSolutions();
        Assertions.assertEquals(expected, actual, "checkGetSolutions()");
    }

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(controller);
    }

}
