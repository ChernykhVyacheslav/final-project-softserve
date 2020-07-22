package com.softserve.edu;

import com.softserve.edu.controller.MarathonController;
import com.softserve.edu.dto.SprintScore;
import com.softserve.edu.dto.StudentScore;
import com.softserve.edu.entity.Communication;
import com.softserve.edu.entity.Entity;
import com.softserve.edu.entity.Solution;
import com.softserve.edu.service.DataService;
import com.softserve.edu.service.MarathonService;
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
    public ApplicationTest(MarathonService marathonService, DataService dataService) {
        this.marathonService = marathonService;
        this.dataService = dataService;
        fillDataService();
    }

    private void fillDataService() {
        dataService.clean();

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

        dataService.addCommunication("Student1", "Mentor1");
        dataService.addCommunication("Student3", "Mentor1");
        dataService.addCommunication("Student4", "Mentor1");
        dataService.addCommunication("Student5", "Mentor1");

        dataService.addCommunication("Student1", "Mentor2");
        dataService.addCommunication("Student2", "Mentor2");
        dataService.addCommunication("Student4", "Mentor2");

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
    public void checkGetSprints() {
        List<Entity> expected = new ArrayList<Entity>() {{
            add(new Entity("Sprint1"));
            add(new Entity("Sprint2"));
            add(new Entity("Sprint3"));
            add(new Entity("Sprint4"));
            add(new Entity("Sprint5"));
        }};
        List<Entity> actual = dataService.getSprints();
        Assertions.assertEquals(expected, actual, "checkGetSprints()");
    }

    @Test
    public void checkGetCommunications() {
        List<Communication> expected = new ArrayList<Communication>() {{
            add(new Communication(dataService.getStudentId("Student1"), dataService.getMentorId("Mentor1")));
            add(new Communication(dataService.getStudentId("Student3"), dataService.getMentorId("Mentor1")));
            add(new Communication(dataService.getStudentId("Student4"), dataService.getMentorId("Mentor1")));
            add(new Communication(dataService.getStudentId("Student5"), dataService.getMentorId("Mentor1")));

            add(new Communication(dataService.getStudentId("Student1"), dataService.getMentorId("Mentor2")));
            add(new Communication(dataService.getStudentId("Student2"), dataService.getMentorId("Mentor2")));
            add(new Communication(dataService.getStudentId("Student4"), dataService.getMentorId("Mentor2")));
        }};
        List<Communication> actual = dataService.getCommunications();
        Assertions.assertEquals(expected, actual, "checkGetCommunications()");
    }

    @Test
    public void checkGetSolutions() {
        List<Solution> expected = new ArrayList<Solution>() {{
            add(new Solution(dataService.getStudentId("Student1"), dataService.getSprintId("Sprint1"), 80));
            add(new Solution(dataService.getStudentId("Student1"), dataService.getSprintId("Sprint2"), 75));
            add(new Solution(dataService.getStudentId("Student1"), dataService.getSprintId("Sprint3"), 90));
            add(new Solution(dataService.getStudentId("Student1"), dataService.getSprintId("Sprint4"), 100));
            add(new Solution(dataService.getStudentId("Student1"), dataService.getSprintId("Sprint5"), 60));

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
    public void checkStudentResult() {
        String studentName = "Student1";

        StudentScore expected = new StudentScore(studentName);
        expected.addSprintScore(new SprintScore("Sprint1", 80));
        expected.addSprintScore(new SprintScore("Sprint2", 75));
        expected.addSprintScore(new SprintScore("Sprint3", 90));
        expected.addSprintScore(new SprintScore("Sprint4", 100));
        expected.addSprintScore(new SprintScore("Sprint5", 60));
        
        StudentScore actual = marathonService.studentResult(studentName);
        Assertions.assertEquals(expected, actual, "checkStudentResult()");
    }

    @Test
    public void checkAllStudentsResult() {
        List<StudentScore> expected = new ArrayList<>();
        
        StudentScore studentScore1 = new StudentScore("Student1");
        studentScore1.addSprintScore(new SprintScore("Sprint1", 80));
        studentScore1.addSprintScore(new SprintScore("Sprint2", 75));
        studentScore1.addSprintScore(new SprintScore("Sprint3", 90));
        studentScore1.addSprintScore(new SprintScore("Sprint4", 100));
        studentScore1.addSprintScore(new SprintScore("Sprint5", 60));

        StudentScore studentScore2 = new StudentScore("Student2");
        studentScore2.addSprintScore(new SprintScore("Sprint1", 60));
        studentScore2.addSprintScore(new SprintScore("Sprint2", 75));
        studentScore2.addSprintScore(new SprintScore("Sprint3", 85));
        studentScore2.addSprintScore(new SprintScore("Sprint4", 80));
        studentScore2.addSprintScore(new SprintScore("Sprint5", 70));

        expected.add(studentScore1);
        expected.add(studentScore2);
        expected.add(new StudentScore("Student3"));
        expected.add(new StudentScore("Student4"));
        expected.add(new StudentScore("Student5"));
        
        List<StudentScore> actual = marathonService.allStudentsResult();
        Assertions.assertEquals(expected, actual, "checkAllStudentsResult()");
    }

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(controller);
    }

}
