package Lab11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StudentSystemTest {
    private StudentSystem system;

    @BeforeEach
    public void setUp() throws IOException, InvalidStudentDataExceptions {
        system = new StudentSystem("students.csv");
    }

    @Test
    public void testIfStudentIsPresent() {
        assertTrue(system.noOfStudents() > 0, "There should be at least one student.");
    }

    @Test
    public void testStudentWithId100() {
        assertThrows(StudentNotFoundException.class, () -> {
            system.getStudentById(100);
        }, "Expected StudentNotFoundException to be thrown.");
    }

    @Test
    public void testHighestGPAStudent() {
        Student highestGPAStudent = system.getHighestGPAStudent();
        assertEquals(9.8, highestGPAStudent.getGPA(), "The student with the highest GPA should have a GPA of 9.8.");
    }

    @Test
    public void testExceptionForEmptyStudentList() {
        StudentSystem emptySystem = new StudentSystem(new ArrayList<Student>());
        assertThrows(EmptyStudentListException.class, () -> {
            emptySystem.getHighestGPAStudent();
        }, "Expected EmptyStudentListException to be thrown.");
    }

    @Test
    public void testNamesArray() {
        List<String> names = StudentSystem.getNames(system.readStudents("students.csv"));
        List<String> expectedNames = Arrays.asList("Camila Wood", "Alexander Thompson", "Liam Taylor", "Evelyn Jenkins", "Michael Jackson");
        List<String> sublist = names.subList(0, 5);
        assertEquals(expectedNames, sublist, "The first five student names should match the expected list.");
    }

    @Test
    public void testSameStudent() {
        Student highestGPAStudent = system.getHighestGPAStudent();
        assertEquals(12, highestGPAStudent.getId(), "The student with the highest GPA should have ID 12.");
    }

    @Test
    public void testInvalidStudentDataException() {
        List<Student> invalidStudents = Arrays.asList(new Student(1, "Test", "Test University", "CS", 5.5));
        assertThrows(InvalidStudentDataExceptions.class, () -> {
            new StudentSystem(invalidStudents);
        }, "Expected InvalidStudentDataExceptions to be thrown.");
    }

    @Test
    public void testStudentNotFoundException() {
        assertThrows(StudentNotFoundException.class, () -> {
            system.getStudentById(999);
        }, "Expected StudentNotFoundException to be thrown.");
    }
}
